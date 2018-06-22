package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import sun.java2d.SurfaceDataProxy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author muzhe-wang on  18-6-14 下午6:01.
 */
public class SemphoreIsolateHelloWorldCommand extends HystrixCommand<String> {
    private String name;
    protected SemphoreIsolateHelloWorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                //设置一些常见的属性
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                //指定当前的系统隔离的策略，使用信号量来隔离。使用当前的线程池。
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));

    }

    @Override
    protected String run() throws Exception {
        String result = "HystrixThread : " + Thread.currentThread().getName();
        System.out.println(result);
        return  result;
    }


    public static void main(String[] args) {
           final int count = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0 ; i<= count ; i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await(3,TimeUnit.SECONDS);
                        final SemphoreIsolateHelloWorldCommand semphoreIsolateHelloWorldCommand = new SemphoreIsolateHelloWorldCommand("SemphoreHelloWorldCommand");

                        semphoreIsolateHelloWorldCommand.execute();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("Thread "+ i+ " start running.");
            countDownLatch.countDown();
        }

        System.out.println("所有的线程启动完毕");
    }
}
