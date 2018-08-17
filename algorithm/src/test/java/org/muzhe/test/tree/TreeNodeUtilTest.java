package org.muzhe.test.tree;

import org.junit.Test;
import org.muzhe.test.tree.model.TreeNode;

/**
 * @author muzhe-wang on 18/8/7.
 */
public class TreeNodeUtilTest {

    @Test
    public void preOrderTree() {
        TreeNode treeNode = TreeHelper.generateBinTree();
        TreeNodeUtil.preOrderTreeCircuite(treeNode);
    }

    @Test
    public void preOrderTreeCircuite() {
        TreeNode treeNode = TreeHelper.generateBinTree();
        TreeNodeUtil.preOrderTree(treeNode);
    }

    @Test
    public void preOrder2(){

        TreeNode treeNode = TreeHelper.generateBinTree();
        TreeNodeUtil.preOrderTree2(treeNode);

    }
    @Test
    public void inOrderTreeCircutie() {

        TreeNode root = TreeHelper.generateBinTree();
        TreeNodeUtil.inOrderTreeCircutie(root);

    }

    @Test
    public void inOrderTree() {

        TreeNode treeNode = TreeHelper.generateBinTree();
        TreeNodeUtil.inOrderTree(treeNode);

    }


    @Test
    public void testInOrderTree(){

        TreeNode root = TreeHelper.generateBinTree();
        TreeNodeUtil.inOrderTreeCircutie(root);

        System.out.println("========================================================");

        TreeNode treeNode = TreeHelper.generateBinTree();
        TreeNodeUtil.inOrderTree(treeNode);
    }

    @Test
    public void postOrderTree() {

        TreeNode root = TreeHelper.generateBinTree();
        TreeNodeUtil.postOrderTreeWithCircuit(root);
        System.out.println("===========================================================");
    }
}