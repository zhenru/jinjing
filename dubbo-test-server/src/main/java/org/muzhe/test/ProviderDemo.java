package org.muzhe.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author muzhe-wang on 18/7/4.
 */
public class ProviderDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        System.out.println("开始启动...");
        context.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
