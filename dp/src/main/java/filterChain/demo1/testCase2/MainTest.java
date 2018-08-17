package filterChain.demo1.testCase2;

import filterChain.demo1.core.Filter;
import filterChain.demo1.core.FilterChain;
import filterChain.demo1.core.Request;
import filterChain.demo1.core.Response;

/**
 * @author muzhe-wang on  18-7-11 下午6:10.
 */
public class MainTest {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        Filter showFilter = new ShowFilter();
        Filter closeFilter = new CloseFilter();
        filterChain.registerFilter(showFilter);
        filterChain.registerFilter(closeFilter);

        FilterChain defaultFilterChain = new FilterChain();
        defaultFilterChain.registerFilter(new ShowFilter());
        defaultFilterChain.registerFilter(new ShowFilter());
        filterChain.registerFilter(defaultFilterChain);

        Request request = new Request();
        Response response = new Response();
        filterChain.doFilter(request, response);
        System.out.println(request.getContent());
        System.out.println(response.getContent());

    }

}
