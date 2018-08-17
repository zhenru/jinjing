package org.muzhe.test.tree;

import org.muzhe.test.tree.model.TreeNode;
import sun.jvm.hotspot.ui.tree.BadAddressTreeNodeAdapter;

/**
 * 树的帮助类，主要用来帮助生成一些帮助的类的实现。
 * @author muzhe-wang on 18/8/7.
 */
public class TreeHelper {

    /**
     *
     * 生成一课树
     * @return
     */
    public static TreeNode generateBinTree(){

        TreeNode root = new TreeNode("root" , null , null);

        TreeNode left = new TreeNode("left1" , null, null);
        TreeNode right = new TreeNode("right" , null , null);
        root.setLeftNode( left);
        root.setRightNode(right);

        TreeNode leftLeft = new TreeNode("left1.left" , null , null);
        TreeNode leftRight = new TreeNode("left1.right" , null , null);
        left.setLeftNode(leftLeft);
        left.setRightNode(leftRight);

        TreeNode rightLeft = new TreeNode("rightLeft" , null, null);
        TreeNode  rightRight = new TreeNode("rightRight"  , null , null);
        right.setLeftNode( rightLeft);
        right.setRightNode(rightRight);

        return  root;
    }
}
