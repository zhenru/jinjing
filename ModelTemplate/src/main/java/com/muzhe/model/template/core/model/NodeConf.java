package com.muzhe.model.template.core.model;

import lombok.Data;

/**
 * 节点值的定义，值的定义同时也包含了
 * @author muzhe-wang on 18/8/2.
 */
@Data
public class NodeConf {
    /**
     *节点配置信息Id
     */
    private String nodeConfId;

    /**
     * 属于的产品 信息
     */
    private String productId;

    /**
     * 接入方信息
     */
    private  String familyId;

    /**
     * 节点类型
     */
    private String type;

    /**
     * 名称
     */
    private String  name;

    /**
     * 描述信息
     */
    private String  desc;


    /**
     * 值
     */
    private String  value;

    /**
     * 值的类型
     */
    private Integer valueType;

    /**
     * 父亲配置信息节点
     */
    private String parentNodeConfId;

}
