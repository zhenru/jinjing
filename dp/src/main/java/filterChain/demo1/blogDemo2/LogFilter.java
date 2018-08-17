package filterChain.demo1.blogDemo2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author muzhe-wang on  18-7-12 下午2:28.
 */
@Slf4j
public class LogFilter implements Filter {

    public void doFilter(String request, String response, FilterChain filterChain) {

        //前置执行
        log.info(request);
        //过滤链执行
        filterChain.doFilter(request , response, filterChain);
        //后置执行
        log.info(response);

    }

}
