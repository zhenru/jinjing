package org.muzhe.test.hystrix.demo1;

import com.netflix.hystrix.*;

/**
 * GroupKey:对CommandKey进行分组。在逻辑上对这些关联的对象进行分组。
 * CommandKey:将相互关联的对象放在一起，使用CommandKey来实现当前的对象。
 * ThreadPoolKey:　使用线程池对执行的对象进行隔离。这里是无力隔离。
 *
 * @author muzhe-wang on  18-6-14 下午3:12.
 */
public class GroupHelloWorldCommand extends HystrixCommand<String> {

    private String name;

    public GroupHelloWorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroupKey")).
                andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorldCommandKey")).
                andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldThreadPoolKey")));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {

        System.out.println("the request param = " + name);
        return "hello " + name;
    }

    public static void main(String[] args) {
        GroupHelloWorldCommand helloWorldCommand = new GroupHelloWorldCommand("张三");
        helloWorldCommand.execute();
    }
}
