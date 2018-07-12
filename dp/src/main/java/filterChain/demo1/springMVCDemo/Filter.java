package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午6:40.
 */
public interface Filter {

    /**
     *
     * @param request
     * @return
     */
    boolean preHandle(String request,String response);

    boolean postHandle(String request ,String response);


}
