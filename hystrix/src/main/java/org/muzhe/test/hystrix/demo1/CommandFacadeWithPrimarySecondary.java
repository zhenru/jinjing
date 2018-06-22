package org.muzhe.test.hystrix.demo1;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * '
 * 在当前的方法中，fallback方法不再作为服务降级来使用，而是当作服务逻辑进行处理的过程
 * @author muzhe-wang on  18-6-15 上午11:11.
 */
public class CommandFacadeWithPrimarySecondary extends HystrixCommand<String> {

    private static final String GROUP_KEY = "SystemX";

    private final int id;

    private final static DynamicBooleanProperty usePrimary = DynamicPropertyFactory.getInstance().getBooleanProperty("primarySecondary.usePrimary", true);

    protected CommandFacadeWithPrimarySecondary(int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(GROUP_KEY)).
                andCommandKey(HystrixCommandKey.Factory.asKey("PrimarySecondaryCommand")).
                andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        if (usePrimary.get()) {
            return new PrimarayCommand(id).execute();
        } else {
            return new SecondCommand(id).execute();
        }
    }


    private static class PrimarayCommand extends HystrixCommand<String> {
        private int id;

        public PrimarayCommand(int id) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(GROUP_KEY)).andCommandKey(HystrixCommandKey.Factory.asKey("PrimaryCommand"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("PrimaryCommand")).
                    //对于主要的线程一个600 ms的超时，todo 这个是这样吗？　这个需要确认一下的。
                            andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(600)));

            this.id = id;
        }

        @Override
        protected String run() throws Exception {
            return "responseFromSecondary - " + id;
        }
    }

    private static class SecondCommand extends HystrixCommand<String>{

        private int id;
        protected SecondCommand(int id) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(GROUP_KEY)).andCommandKey(HystrixCommandKey.Factory.asKey("SecondaryCommand"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("SecondaryCommand")).
                            andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(100)));
            this.id = id;
        }

        @Override
        protected String run() throws Exception {
            return "responseFromSecondary - " + id;
        }

    }

    public static void main(String[] args) {

        HystrixRequestContext requestContext = HystrixRequestContext.initializeContext();
        ConfigurationManager.getConfigInstance().setProperty("primarySecondary.usePrimary" , true);
        String executeResult = new CommandFacadeWithPrimarySecondary(20).execute();
        System.out.println(executeResult);
       requestContext.shutdown();
       ConfigurationManager.getConfigInstance().clear();
    }
}
