package filterChain.demo1.testCase3;

import filterChain.demo1.core.Request;
import filterChain.demo1.core.Response;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-11 下午6:38.
 */
public class FilterChain implements Filter {

    private List<Filter> filterList = new LinkedList<Filter>();
    private int executePosition = 0;


    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (executePosition < filterList.size()) {
            filterList.get(executePosition++
            ).doFilter(request, response, this);
        }
    }

    public FilterChain addFilter(Filter filter) {
        filterList.add(filter);
        return this;
    }
}
