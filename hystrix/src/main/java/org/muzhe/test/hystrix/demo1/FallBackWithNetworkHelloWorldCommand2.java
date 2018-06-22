package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * 依赖调用和服务降级使用不同的线程池，这样能够保证在以来服务使用线程池用满了以后，保证降级服务也能够正常执行。
 * @author muzhe-wang on  18-6-14 下午6:16.
 */
public class FallBackWithNetworkHelloWorldCommand2 extends HystrixCommand<String> {

    private int id;

    protected FallBackWithNetworkHelloWorldCommand2(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueCommand")));
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        throw new RuntimeException("force failure for example");
    }

    @Override
    protected String getFallback(){

        return new FallBackViaNetwork(id).execute();
    }

    private static class  FallBackViaNetwork extends HystrixCommand<String>{

        private int id;
        protected FallBackViaNetwork(int id) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX")).
                    andCommandKey(HystrixCommandKey.Factory.asKey("GetValueFallbackCommand")).
                    //使用不同的线程池做隔离，防止商城的线程池跑慢了影响服务降级的逻辑。
            andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("RemoteServiceFallback")));
            this.id= id;
        }

        @Override
        protected String run() throws Exception {
           return "hello world "+ id;
        }

        @Override
        protected String getFallback(){
            return "fallback";
        }
    }
}
