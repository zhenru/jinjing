package com.muzhe.model.template.core.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author muzhe-wang on 18/8/2.
 */
@Data
public class TreeNode {

    private String name;

    private String nodeId;

    private String value;

    private NodeConfValueType nodeConfValueType;

    private List<TreeNode> childTreeNode;


}
