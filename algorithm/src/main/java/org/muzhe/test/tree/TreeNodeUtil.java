package org.muzhe.test.tree;

import org.muzhe.test.tree.model.TreeNode;

import java.util.Stack;

/**
 * @author muzhe-wang on 18/8/7.
 */
public class TreeNodeUtil {


    /**
     * 使用递归的方式先序遍历一棵树
     * @param root
     */
    public static void preOrderTreeCircuite(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());

        preOrderTreeCircuite(root.getLeftNode());
        preOrderTreeCircuite(root.getRightNode());

    }

    /**
     * 先序遍历一棵树，使用费递归
     *
     *
     * @param root 根节点
     */
    public static void preOrderTree(TreeNode root) {

        if (root == null){
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            handleNode(node);
            if (node.getRightNode() != null){
                nodeStack.push(node.getRightNode());
            }
            if (node.getLeftNode() != null){
                nodeStack.push(node.getLeftNode());
            }
        }

    }

    public static void preOrderTree2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        while (true){

            visitAlongLeftTreeNode(root , nodeStack);
            if (nodeStack.isEmpty()){
                return;
            }
            root = nodeStack.pop();

        }

    }


    /**
     * 访问左侧节点
     * @param root
     */
    private static void visitAlongLeftTreeNode(TreeNode root , Stack<TreeNode> treeNodeStack){

        while (root!= null){
            handleNode(root);
            treeNodeStack.push(root.getRightNode());
            root = root.getLeftNode();
        }

    }

    /**
     * 使用递归的方式中序的访问一棵树
     * @param root      根节点
     */
    public static void inOrderTreeCircutie(TreeNode root){

        if (root == null){
            return;
        }
        inOrderTreeCircutie(root.getLeftNode());
        handleNode(root);
        inOrderTreeCircutie(root.getRightNode());

    }


    /**
     * 使用普通的方式去遍历一棵树
     * @param root
     */
    public static  void inOrderTree(TreeNode root){

        if (root == null){
            return;
        }

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();

        pushRootLeftNode(treeNodeStack , root);

        while (!treeNodeStack.isEmpty()){

            TreeNode top = treeNodeStack.pop();
            handleNode(top);
            pushRootLeftNode(treeNodeStack , top.getRightNode());
        }

    }

    /**
     * 将当前节点所有的左子树都压到栈中去，然后将数据从栈中弹出
     * @param treeNodeStack     数据栈
     * @param node              节点
     */
    private static void pushRootLeftNode(Stack<TreeNode> treeNodeStack,TreeNode node){

            while (node!=null){
                treeNodeStack.push(node);
                node = node.getLeftNode();
            }

    }


    /**
     * 后序访问一棵树使用递归
     * @param root
     */
    public static  void postOrderTreeWithCircuit(TreeNode root){

        if (root == null){
            return;
        }
        postOrderTreeWithCircuit(root.getLeftNode());
        postOrderTreeWithCircuit(root.getRightNode());
        handleNode(root);

    }


    /**
     * 后序访问一棵树
     * @param root  根节点
     */
    public static void  postOrderTree(TreeNode root){

        if (root == null){
            return;
        }

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode top = treeNodeStack.peek();
            if (top.getRightNode()!= null){
                treeNodeStack.push(top.getRightNode());
            }else if (top.getLeftNode() != null){
                treeNodeStack.push(top.getLeftNode());
            }else {
                handleNode(top);
                treeNodeStack.pop();
            }
        }

    }

    private static void handleNode(TreeNode node) {
        System.out.println(node.getValue());
    }
}
