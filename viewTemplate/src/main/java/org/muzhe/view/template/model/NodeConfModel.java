package org.muzhe.view.template.model;

import lombok.Data;

/**
 * 树形节点描述信息，这个将会被描述在数据库中。使用了邻接表的形式来实现的。
 *
 * @author muzhe-wang on  18-8-6 下午3:41.
 */
@Data
public class NodeConfModel {

    /**
     * 当前节点标识Ｉd
     */
    private String id;

    /**
     * 节点名
     */
    private String name;

    /**
     * 节点值
     */
    private String value;

    /**
     * 描述信息
     */
    private String desc;

    /**
     * 值类型
     */
    private ValueTypeEnum valueType;

    /**
     * 父亲节点Ｉd.
     */
    private String parentId;

}
