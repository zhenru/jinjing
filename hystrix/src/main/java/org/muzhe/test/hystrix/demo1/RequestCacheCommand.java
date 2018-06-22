package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * dagnqian xitong zhong de
 *
 *使用Ｃache可以确保使用了相同的CommandKey和相同的CommandGroupKey中共享缓存。这样能使得系统的性能得到提升。
 *
 * @author muzhe-wang on  18-6-14 下午3:51.
 */
public class RequestCacheCommand extends HystrixCommand<String> {

    private int id;

    protected RequestCacheCommand(int id) {
        super(HystrixCommandGroupKey.Factory.asKey("RequestCacheCommand"));
        this.id = id;
    }

    @Override
    protected String run() throws Exception {

        System.out.println(Thread.currentThread().getName() +" excute id " + id);
        return "execute id " + id;
    }


    @Override
    protected String getCacheKey(){
        return String.valueOf(id);
    }

    public static void main(String[] args) {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        System.out.println("- ");
        RequestCacheCommand requestCacheCommand1 = new RequestCacheCommand(2);
        RequestCacheCommand requestCacheCommand2= new RequestCacheCommand(2);
        System.out.println(requestCacheCommand1.execute());
        System.out.println(requestCacheCommand1.isResponseFromCache());
        System.out.println(requestCacheCommand2.execute());
        System.out.println(requestCacheCommand2.isResponseFromCache());
        context.shutdown();

        context = HystrixRequestContext.initializeContext();
        RequestCacheCommand requestCacheCommand3 = new RequestCacheCommand(2);
        System.out.println("-");
        System.out.println(requestCacheCommand3.execute());
        System.out.println(requestCacheCommand3.isResponseFromCache());;
        context.shutdown();;


    }
}
