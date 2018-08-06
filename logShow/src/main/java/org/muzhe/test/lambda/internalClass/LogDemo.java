package org.muzhe.test.lambda.internalClass;

import org.muzhe.test.loggers.LogFileNameEnum;
import org.muzhe.test.loggers.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author muzhe-wang on  18-7-2 下午3:17.
 */
public class LogDemo {

    public static void main(String[] args) {

        Logger infoLogger = LogUtils.logger(LogFileNameEnum.INFO);
        Logger userLogger = LogUtils.logger(LogFileNameEnum.USER);

        infoLogger.info("当前系统中的　的一些信息　" + new Date());
        userLogger.info("current system the user info " + new Date());

        Logger logger = LoggerFactory.getLogger(LogDemo.class);
        logger.info("这个是测试系统中info　级别的实现" + new Date());
        logger.error("这个是测试当前系统中　error级别的日志实现" + new Date());
        logger.debug("这个是测试当前系统中的　debug级别的日志实现" + new Date());

    }
}
