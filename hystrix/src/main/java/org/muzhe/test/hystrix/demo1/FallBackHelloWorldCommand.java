package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * 这里设置一个一个超时的fallback熔断器，保证在超时的时候熔断。
 * 其中任何在run中促发的任何异常都会触发getFallback降级的实现。
 * @author muzhe-wang on  18-6-14 下午2:54.
 */
public class FallBackHelloWorldCommand extends HystrixCommand<String> {

    private String name;

    public FallBackHelloWorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("FallBackHelloWorld")).
                //配置执行的时候超时时间是500毫秒
                        andCommandPropertiesDefaults(HystrixCommandProperties.Setter().
                        withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }

    @Override
    protected String getFallback(){
        System.out.println("当前方法执行失败");
        return " execute fail...";
    }
    @Override
    protected String run() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "Hello " + name + "thread " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        FallBackHelloWorldCommand fallBackHelloWorldCommand = new FallBackHelloWorldCommand("test-fallback");
        String execute = fallBackHelloWorldCommand.execute();
        System.out.println(execute);
    }
}
