package com.muzhe.model.util;

/**
 * @author muzhe-wang on  18-9-14 下午6:01.
 */
public class LocalException extends RuntimeException {

    private String errMsg;

    public LocalException(String message, String errMsg) {
        super(message);
        this.errMsg = errMsg;
    }
}
