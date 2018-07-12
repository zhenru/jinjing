package filterChain.demo1.blogDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-12 上午11:32.
 */
public class FilterChain implements Filter {

    private List<Filter> filterChain = new LinkedList<Filter>();

    public FilterChain addFilterChain(Filter filter) {
        filterChain.add(filter);
        return this;
    }

    public void doSomething(String request, String response) {
        for (Filter filter : filterChain) {
            filter.doSomething(request, response);
        }
    }

}
