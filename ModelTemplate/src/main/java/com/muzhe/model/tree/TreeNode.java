package com.muzhe.model.tree;

import lombok.Data;

import java.util.List;

/**
 * @author muzhe-wang on  18-9-14 下午5:23.
 */
@Data
public class TreeNode {

    /**
     * 节点定义信息
     */
    private ConfigModel configModel;

    /**
     * value
     */
    private Object value;

    /**
     * 所有的子节点
     */
    private List<TreeNode> children;

    /**
     * 深度copy
     * @return
     */
    public TreeNode depClone(){

        //todo 这里对节点进行一个深度copy的实现
        return null;
    }

}
