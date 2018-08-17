package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:23.
 */
public class DefaultInvoker implements Invoker {
    public String doInvoke(String invocation) {
        System.out.println(invocation);
        return "hello " + invocation;
    }
}
