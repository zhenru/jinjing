package org.muzhe.test.tree.model;

import lombok.AllArgsConstructor;
import lombok.Data;



/**
 * @author muzhe-wang on 18/8/7.
 */
@Data
@AllArgsConstructor
public class TreeNode {

    private String value;

    private TreeNode leftNode;

    private TreeNode rightNode;


}
