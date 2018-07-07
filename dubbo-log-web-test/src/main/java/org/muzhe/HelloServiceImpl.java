package org.muzhe;

import com.xiaomi.jack.annotation.ThriftService;
import com.xiaomi.log.plugin.thrift.Monitor;
import com.xiaomi.miliao.thrift.MiliaoSharedServiceBase;
import com.xiaomi.test.Hello;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

/**
 * @author muzhe-wang on  18-7-7 下午4:14.
 */
@Monitor
@Slf4j
public class HelloServiceImpl extends MiliaoSharedServiceBase implements Hello.Iface {

    @Override
    public String helloString(String s) throws TException {
        log.error("你好呀，这个是一个测试的用例");
        System.out.println("收到的数据信息：" + s);
        return "Hello World ：" + s;
    }

    @Override
    public void stop() {
        log.error("这个是一个测试的用例");
        System.out.println("服务关闭");
    }

}