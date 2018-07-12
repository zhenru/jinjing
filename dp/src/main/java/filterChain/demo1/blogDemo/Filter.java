package filterChain.demo1.blogDemo;

/**
 * @author muzhe-wang on  18-7-12 上午11:22.
 */
public interface Filter {

    /**
     * 处理请求
     * @param request
     * @param response
     */
    public void doSomething(String request , String response);

}
