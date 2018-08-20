package com.muzhe.model.template.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author muzhe-wang on 18/8/2.
 */
@AllArgsConstructor
@Getter
public enum NodeConfValueType {

    INT(1),

    LONG(2),

    CHAR(3),

    FLOAT(4),

    DOUBLE(5),

    BOOL(6),

    STRING(7),

    LIST(8),

    MAP(9),

    NONE_VALUE(10);
    /**
     * 类型编码
     */
    private Integer valueType;


}
