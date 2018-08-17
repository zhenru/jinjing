package filterChain.demo1.blogDemo2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-12 下午2:21.
 */
public class FilterChain implements Filter {

    private List<Filter> filterList;
    private int position;

    public FilterChain() {
        filterList = new LinkedList<Filter>();
        position = 0;
    }

    /**
     * 注册　过滤器
     *
     * @param filter
     * @return
     */
    public FilterChain addFilter(Filter filter) {
        this.filterList.add(filter);
        return this;
    }

    public void doFilter(String request, String response, FilterChain filterChain) {

        if (position < filterList.size()) {
            filterList.get(position++).doFilter(request, response, this);
        }

    }

}
