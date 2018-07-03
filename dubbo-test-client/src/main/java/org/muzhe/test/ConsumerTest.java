package org.muzhe.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author muzhe-wang on  18-7-3 下午6:36.
 */
public class ConsumerTest {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-dubbo.xml");

        EchoService echoService2 = classPathXmlApplicationContext.getBean("echoService2", EchoService.class);
        EchoService echoService1 = classPathXmlApplicationContext.getBean("echoService1", EchoService.class);

        String zhangsan = echoService1.sayHello("张三");
        System.out.println(zhangsan);
        String lisi = echoService2.sayHello("lisi");
        System.out.println(lisi);


    }
}
