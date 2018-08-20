package org.muzhe.test.muzheCache.exceptions;

/**
 * @author muzhe-wang on  18-8-20 下午2:55.
 */
public class LocalException  extends RuntimeException{

    private String errMsg;

    public LocalException(String errMsg) {
        this.errMsg = errMsg;
    }

    public LocalException(String message, String errMsg) {
        super(message);
        this.errMsg = errMsg;
    }

    public LocalException(String message, Throwable cause, String errMsg) {
        super(message, cause);
        this.errMsg = errMsg;
    }
}
