package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午7:09.
 */
public class MainTest {

    public static void main(String[] args) {
        Invoker invoker = InvokerWrapper.wrapperInvoker(new DefaultInvoker());
        String request = "hello";
        String response = "world";
        invoker.invoke(request, response);
    }
}
