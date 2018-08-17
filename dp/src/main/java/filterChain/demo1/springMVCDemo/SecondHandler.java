package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午6:51.
 */
public class SecondHandler implements Filter {
    public boolean preHandle(String request, String response) {

        System.out.println(" start world" + request);
        return true;
    }

    public boolean postHandle(String request, String response) {
        System.out.println(" end world " + response);
        return true;
    }
}
