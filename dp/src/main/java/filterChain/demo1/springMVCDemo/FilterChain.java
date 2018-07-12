package filterChain.demo1.springMVCDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-12 下午6:54.
 */
public class FilterChain implements Filter {

    private List<Filter> filterList = new LinkedList<Filter>();
    private int index = 0;

    public boolean preHandle(String request, String response) {

        for (index = 0; index < filterList.size(); index++) {
            if (!filterList.get(index).preHandle(request, response)) {
                return false;
            }
        }
        return true;
    }

    public boolean postHandle(String request, String response) {
        for (int i = filterList.size() - 1; i >= 0; i--) {
            if (!filterList.get(i).postHandle(request, response)) {
                return false;
            }
        }
        return true;
    }

    public FilterChain addFilterChain(Filter filter) {
        filterList.add(filter);
        return this;
    }
}
