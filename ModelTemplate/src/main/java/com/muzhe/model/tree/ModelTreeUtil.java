package com.muzhe.model.tree;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

import static java.util.stream.Collectors.toMap;

/**
 * @author muzhe-wang on  18-9-14 下午5:20.
 */
public class ModelTreeUtil {

    /**
     * 将list类型的定义的节点转变化为ＴreeNode.
     * @param configModelList   平行节点
     * @return                  树形结构
     */
    public TreeNode compile(List<ConfigModel> configModelList){
        //todo
        if (CollectionUtils.isEmpty(configModelList)){
            return null;
        }

        checkConfigModel(configModelList);
        TreeNode treeNode = generateTreeNode(configModelList);
        return null;
    }

    /**
     * 校验这些参数是否合适作为一颗树形结构
     * @param configModelList
     */
    private void checkConfigModel(List<ConfigModel> configModelList) {



    }

    /**
     * 构造一个　treeNode.
     * @param configModelList
     * @return
     */
    private TreeNode generateTreeNode(List<ConfigModel> configModelList) {

        configModelList.stream();

        return null;
    }





}
