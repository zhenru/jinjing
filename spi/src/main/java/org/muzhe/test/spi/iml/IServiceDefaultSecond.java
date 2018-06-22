package org.muzhe.test.spi.iml;

import org.muzhe.test.spi.IService;

/**
 * @author muzhe-wang on  18-6-22 下午3:10.
 */
public class IServiceDefaultSecond implements IService {

    @Override
    public String execute(String name, int age) {
        return " second : " + name + " age = " + age;
    }
}
