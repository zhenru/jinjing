package org.muzhe.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author muzhe-wang on  18-7-3 下午6:19.
 */

@Slf4j
public class EchoServiceImpl implements EchoService {
    public String sayHello(String name) {
        log.error("echo 1");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-demo-consumer.xml");
        System.out.println("开始启动...");
        context.start();
        EchoService bean = context.getBean("echoService2", EchoService.class);
        String result = bean.sayHello("这里是 service2的调用");
        log.info(result);
        String results2 = bean.sayHello("这里是对Service2的第二次调用");
        log.info(results2);
        return "hello world " + name;
    }


}
