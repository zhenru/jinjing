package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午6:50.
 */
public class FirstHandler implements Filter {
    public boolean preHandle(String request, String response) {
        System.out.println(" start hello " + request);
        return true;
    }

    public boolean postHandle(String request, String response) {
        System.out.println("end hello " + response);
        return true;
    }
}
