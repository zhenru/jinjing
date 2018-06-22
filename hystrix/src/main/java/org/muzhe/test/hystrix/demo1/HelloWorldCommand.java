package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * 这个方法中主要是如何包装了调用对象。主要分为同步和异步两种方式。
 * 异步调用使用　command.queue.get(timeout, TimeUnit);
 * 同步调用：　　command.execute();
 * @author muzhe-wang on  18-6-13 下午5:24.
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private final String name;
    public HelloWorldCommand(String name) {
        //指定这个命令组的名称
        super(HystrixCommandGroupKey.Factory.asKey("demo1"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        //依赖逻辑写到这个方法中
        return "hello  " + name+ "  thread:" + Thread.currentThread().getName();
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");

        String  result = helloWorldCommand.execute();
        System.out.println("result = " + result);

        //一部调用
        helloWorldCommand = new HelloWorldCommand(" Asynchronous-hystrix");
        Future<String> queue = helloWorldCommand.queue();
        result = queue.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result = " + result);
        System.out.println("main Thead = " + Thread.currentThread().getName());

    }
}
