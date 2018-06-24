package org.muzhe.bupt;

import org.muzhe.parser.bean.Application;
import org.muzhe.parser.bean.Registry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author muzhe-wang on  18-6-24 下午12:22.
 */
public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Application bean = classPathXmlApplicationContext.getBean(Application.class);
        System.out.println(bean);
        Registry registry = classPathXmlApplicationContext.getBean(Registry.class);
        System.out.println(registry);
    }
}
