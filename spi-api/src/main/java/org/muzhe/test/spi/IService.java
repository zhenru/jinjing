package org.muzhe.test.spi;

/**
 *  org.muzhe.test.spi.IService
 * @author muzhe-wang on  18-6-21 下午6:28.
 */
public interface IService {

    /**
     * 这个是一个接口实现的对象
     * @param name　　　　名称
     * @param age       年龄
     * @return          返回执行结果
     */
    String  execute(String name, int age);
}
