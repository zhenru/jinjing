package filterChain.demo1.blogDemo2;

/**
 * @author muzhe-wang on  18-7-12 下午2:27.
 */
public class StdFilter implements Filter {

    public void doFilter(String request, String response, FilterChain filterChain) {

        //前置执行
        System.out.println(request);
        //过滤链执行
        filterChain.doFilter(request,response , filterChain);
        //后置执行
        System.out.println(response);

    }

}
