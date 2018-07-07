package org.muzhe;

import org.apache.thrift.TException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-7-7 下午6:40.
 */
public class HelloServiceImplTest {

    @org.junit.Test
    public void helloString() throws TException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        HelloServiceImpl bean = classPathXmlApplicationContext.getBean(HelloServiceImpl.class);
        String nihao = bean.helloString("nihao");
        System.out.println(nihao);
    }
}