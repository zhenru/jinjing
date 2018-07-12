package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午6:58.
 */
public interface Invoker {

    void invoke(String request, String response);

}
