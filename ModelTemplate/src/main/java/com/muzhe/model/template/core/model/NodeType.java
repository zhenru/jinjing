package com.muzhe.model.template.core.model;

import lombok.AllArgsConstructor;

/**
 * @author muzhe-wang on 18/8/2.
 */
@AllArgsConstructor
public enum NodeType {

    DEFINE(1),
    BRANCH(3),;

    private Integer type;

}
