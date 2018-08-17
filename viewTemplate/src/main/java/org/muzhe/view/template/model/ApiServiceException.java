package org.muzhe.view.template.model;

/**
 * @author muzhe-wang on  18-8-6 下午4:47.
 */
public class ApiServiceException extends RuntimeException {

    public ApiServiceException(String msg) {
        super(msg);
    }

    public ApiServiceException(Exception ex) {
        super(ex);
    }

}
