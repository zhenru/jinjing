package org.muzhe.test.spi.iml;

import org.muzhe.test.spi.IService;

/**
 *  org.muzhe.test.spi.iml.IServiceDefaultFirst
 * @author muzhe-wang on  18-6-21 下午6:33.
 */
public class IServiceDefaultFirst implements IService {

    @Override
    public String execute(String name, int age) {
        return "first " + name + " age = " + age;
    }

}
