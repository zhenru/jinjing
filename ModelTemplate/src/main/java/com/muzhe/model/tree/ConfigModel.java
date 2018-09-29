package com.muzhe.model.tree;

import lombok.Data;

/**
 * 这个是一个横形树桩结构
 * @author muzhe-wang on  18-9-14 下午4:39.
 */
@Data
public class ConfigModel {

    /**
     * id
     */
    private int id;

    /**
     * 父节点
     */
    private int parentId;

    /**
     *
     */
    private String value;

}
