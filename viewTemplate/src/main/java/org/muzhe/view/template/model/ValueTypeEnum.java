package org.muzhe.view.template.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author muzhe-wang on  18-8-6 下午4:17.
 */
@Getter
@AllArgsConstructor
public enum  ValueTypeEnum {

    INT(1,"整形"),
    LONG(2,"Long类型"),
    CHAR(3,"字符类型"),
    FLOAT(4,"浮点型"),
    DOUBLE(5,"双精度类型"),
    BOOL(6,"布尔类型"),
    STRING(7,"字符串类型"),
    LIST(8,"序列类型"),
    MAP(9,"map类型")
    ;
    private int type;

    private String desc;

}
