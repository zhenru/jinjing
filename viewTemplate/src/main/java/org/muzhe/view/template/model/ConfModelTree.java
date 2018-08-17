package org.muzhe.view.template.model;

import com.google.common.base.Predicates;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.muzhe.view.template.util.ListHelper;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * 上午先搞定这个树形结构的数据处理的过程
 * todo 树形结果的各种处理方式 muzhe
 *
 * @author muzhe-wang on  18-8-6 下午4:32.
 */
public class ConfModelTree {


    private static final String VIRTUAL_ROOT_ID = "0";
    private static final String VIRTUAL_ROOT_NAME = "ROOT";
    private TreeNode root;

    public ConfModelTree(TreeNode treeNode){
        this.root = treeNode;
    }
    /**
     * 这里是将使用邻接表定义的一棵树编译为一棵树
     *
     * @param confModels 　邻接表定义的树
     * @return 描述的树
     */
    public static ConfModelTree compile(List<NodeConfModel> confModels) {

        //所有创建树的过程都是以　TreeNode为核心来实现的。
        Map<String, TreeNode> id2TreeNodeMap = initTreeNodeMapper(confModels);

        //将所有的　subTreeNode写到id2TreeNodeMap中的TreeNode中去。
        confModels.stream()
                .collect(groupingBy(NodeConfModel::getParentId))
                .forEach((parentId, subNodeConfList) -> Optional.ofNullable(id2TreeNodeMap.get(parentId))
                        .orElseThrow(() -> new ApiServiceException("can not find parent node by parentId : " + parentId))
                        .setSubTreeNodes(subNodeConfList.stream().
                                map(nodeConfModel -> id2TreeNodeMap.get(nodeConfModel.getId())).collect(toList())));

        ConfModelTree confModelTree = buildConfModelTree(id2TreeNodeMap);
        return confModelTree;

    }

    /**
     * 根据TreeNodemap创建　树。　ConfModelTree节点。
     *
     * @param id2TreeNodeMap map.
     * @return
     */
    private static ConfModelTree buildConfModelTree(Map<String, TreeNode> id2TreeNodeMap) {

        /**
         * VirtualRootNode应该只有一个SubList，同时这个ＳubList就是RealRootNode.如果不是就将VIRTUAL_ROOT_ID的子类的id都打印出来。
         */
        assertTrue(ListHelper.safeSize(id2TreeNodeMap.get(VIRTUAL_ROOT_ID).getSubTreeNodes()) == 1,
                () -> new ApiServiceException("root nodes number must be only one , current nodes is : " +
                        Optional.ofNullable(id2TreeNodeMap.get(VIRTUAL_ROOT_ID).getSubTreeNodes())
                                .orElse(Collections.emptyList()).stream().map(treeNode -> treeNode.getNodeConfModel().getId()).collect(toList())));

        TreeNode root = id2TreeNodeMap.get(VIRTUAL_ROOT_ID).getSubTreeNodes().get(0);
        Map<String, Boolean> visitMap = new HashMap<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            visitMap.put(node.getNodeConfModel().getId(), Boolean.TRUE);

            if (node.getSubTreeNodes() != null && node.getSubTreeNodes().size() != 0) {
                queue.addAll(node.getSubTreeNodes());
            }
        }

        List<String> unVisit = id2TreeNodeMap.keySet().stream()
                .filter(id -> !visitMap.containsKey(id))
                .filter(id -> !id.equals(VIRTUAL_ROOT_ID))
                .collect(toList());

        assertTrue(ListHelper.isEmpty(unVisit), () -> new ApiServiceException(" circular reference exist , " + visitMap.toString()));
        return new ConfModelTree(root);
    }

    /**
     * 对ConfModel的列表转变为一个mapper。key= id.value是一个TreeNode
     * 将一个对象转变为TreeNode和　id之间的影射的实现
     *
     * @param confModels 节点定义列表
     * @return
     */
    private static Map<String, TreeNode> initTreeNodeMapper(List<NodeConfModel> confModels) {

        Predicates.notNull().apply(confModels);
        assertTrue(confModels.stream().anyMatch(ConfModelTree::modelValid), () -> new ApiServiceException("node conf invalid..."));

        Map<String, TreeNode> id2TreeNode = writeVirtualRoot(confModels)
                .stream()
                .collect(toMap(NodeConfModel::getId, nodeConfModel -> new TreeNode(null, nodeConfModel, false, null)));

        boolean rootExist = confModels.stream().map(NodeConfModel::getParentId)
                .peek(parentId -> assertTrue(id2TreeNode.get(parentId) != null, () -> new ApiServiceException("parentId:" + parentId + "can not match any model")))
                .anyMatch(parentId -> parentId.equals("0"));

        assertTrue(rootExist, () -> new ApiServiceException("can not find root node."));
        return id2TreeNode;
    }

    /**
     * 判断checkResult是否为真
     *
     * @param checkResult       待校验结果
     * @param exceptionSupplier 异常
     */
    private static void assertTrue(boolean checkResult, Supplier<ApiServiceException> exceptionSupplier) {

        if (!checkResult) {
            throw exceptionSupplier.get();
        }

    }

    /**
     * 校验NodeConfModel是否合法
     * 将当前对象转变为一个　List,然后使用stream + filter进行处理。
     *
     * @param nodeConfModel
     * @return
     */
    private static boolean modelValid(NodeConfModel nodeConfModel) {

        return ListHelper.safeAssembleList(nodeConfModel).stream()
                .filter(Objects::nonNull)
                .filter(model -> model.getValueType() != null)
                .filter(model -> model.getName() != null)
                .filter(model -> model.getId() != null)
                .filter(model -> model.getParentId() != null)
                .count() == 1;

    }

    /**
     * 向节点列表中写入一个虚拟根节点
     *
     * @param nodeConfModelList
     * @return
     */
    private static List<NodeConfModel> writeVirtualRoot(List<NodeConfModel> nodeConfModelList) {

        NodeConfModel virtualNodeConfModel = new NodeConfModel();
        virtualNodeConfModel.setId(VIRTUAL_ROOT_ID);
        virtualNodeConfModel.setName(VIRTUAL_ROOT_NAME);
        List<NodeConfModel> fullList = new ArrayList<>(nodeConfModelList);
        fullList.add(virtualNodeConfModel);

        return fullList;

    }


    @Data
    @AllArgsConstructor
    public static class TreeNode {

        /**
         * 父亲节点引用
         */
        private TreeNode parentNode;

        /**
         * 节点对应的描述
         */
        private NodeConfModel nodeConfModel;

        /**
         * 是否由nodeConfModel转变为一个TreeNode
         */
        private boolean isParsed;

        /**
         * 当前节点的子节点
         */
        private List<TreeNode> subTreeNodes;

    }
}
