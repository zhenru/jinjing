package org.muzhe.parser.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 配置中心
 * @author muzhe-wang on  18-6-22 下午6:25.
 */
@Setter
@Getter
@ToString
public class Registry {

    private String id;

    private String address;

    private String port;
}
