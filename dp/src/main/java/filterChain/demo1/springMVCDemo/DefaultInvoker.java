package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午6:58.
 */
public class DefaultInvoker implements Invoker {

    public void invoke(String request, String response) {

        System.out.println("hello " + request + " " + response);

    }
}
