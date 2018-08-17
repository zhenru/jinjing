package filterChain.demo1.blogDemo2;

/**
 * @author muzhe-wang on  18-7-12 下午2:20.
 */
public interface Filter {

    /**
     * 过滤接口
     * @param request       请求参数
     * @param response      返回结果
     * @param filterChain   过滤链　由于需要在过滤链之后执行操作，所以需要将过滤链作为参数传递进来
     */
    void doFilter(String request ,String response , FilterChain filterChain);

}
