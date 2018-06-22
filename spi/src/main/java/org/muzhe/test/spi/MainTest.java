package org.muzhe.test.spi;

/**
 * @author muzhe-wang on  18-6-22 下午3:19.
 */
public class MainTest {

    public static void main(String[] args) {
        ServiceFramework serviceFramework = new ServiceFramework();
        String result = serviceFramework.serviceFramework("你好", 12);
        System.out.println(result);
    }
}
