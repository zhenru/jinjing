package org.muzhe.test2;

import lombok.extern.slf4j.Slf4j;
import org.muzhe.test.EchoService;

/**
 * @author muzhe-wang on  18-7-3 下午6:19.
 */

@Slf4j
public class EchoServiceImpl implements EchoService {
    public String sayHello(String name) {
        log.error("echo 2");
        return "hello world " + name;
    }
}
