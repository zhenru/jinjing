package org.muzhe.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author muzhe-wang on  18-7-3 下午6:19.
 */

@Slf4j
public class EchoServiceImpl implements EchoService {
    public String sayHello(String name) {
        log.error("你好呀这个是一个测试的实现");
        return "hello world " + name;
    }


}
