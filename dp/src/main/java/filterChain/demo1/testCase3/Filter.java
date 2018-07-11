package filterChain.demo1.testCase3;

import filterChain.demo1.core.Request;
import filterChain.demo1.core.Response;

/**
 * @author muzhe-wang on  18-7-11 下午6:37.
 */
public interface Filter {

    public void doFilter(Request request, Response response , FilterChain filterChain);
}
