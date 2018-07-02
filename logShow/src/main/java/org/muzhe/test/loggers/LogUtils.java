package org.muzhe.test.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author muzhe-wang on  18-7-2 下午4:33.
 */
public class LogUtils {

    public static <T>Logger logger (LogFileNameEnum logFileNameEnum){
        return LoggerFactory.getLogger(logFileNameEnum.getLogFIleName());
    }
}
