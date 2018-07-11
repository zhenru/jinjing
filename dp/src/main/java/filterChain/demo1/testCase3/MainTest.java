package filterChain.demo1.testCase3;

import filterChain.demo1.core.Request;
import filterChain.demo1.core.Response;

/**
 * @author muzhe-wang on  18-7-11 下午6:42.
 */
public class MainTest {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        Filter helloFilter = new HelloFilter();
        Filter worldFilter = new WorldFilter();
        filterChain.addFilter(helloFilter).addFilter(worldFilter);
        Request request = new Request();
        Response response = new Response();
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.getContent());
        System.out.println(response.getContent());
    }

}
