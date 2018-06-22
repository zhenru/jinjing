package org.muzhe.test.spi.iml;

import org.muzhe.test.spi.IService;

/**
 * @author muzhe-wang on  18-6-22 下午3:17.
 */
public class DefaultService implements IService {
    @Override
    public String execute(String name, int age) {
        return "default  name:=" + name + " age=:" + age;
    }
}
