package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:45.
 */
public class InvokerDemo {

    public static void main(String[] args) {

        Invoker invoker = new DefaultInvoker();
        Invoker invokerWrapper = FilterWrapper.buildFilterChain(invoker);
        String invocation = "hello";
        System.out.println("***************************** proxy **********************************************");
        String hello = invokerWrapper.doInvoke(invocation);
        System.out.println("*******************************no proxy*******************************************");
        invoker.doInvoke(invocation);
    }
}
