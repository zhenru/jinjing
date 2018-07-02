package org.muzhe.test.loggers;

/**
 * @author muzhe-wang on  18-7-2 下午4:34.
 */
public enum LogFileNameEnum {

    USER("user" , "用户信息"),
    INFO("info" , "系统信息");

    private String logFIleName;
    private String desc;


    LogFileNameEnum(String logFIleName, String desc) {
        this.logFIleName = logFIleName;
        this.desc = desc;
    }

    public String getLogFIleName() {
        return logFIleName;
    }

    public String getDesc() {
        return desc;
    }
}
