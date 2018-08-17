package filterChain.demo1.core;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-11 下午5:58.
 */
public class FilterChain implements Filter {

    private List<Filter> filterList = new LinkedList<Filter>();

    @Override
    public void doFilter(Request request, Response response) {
        System.out.println(" 开始执行过滤链");
        for (Filter filter : filterList) {
            filter.doFilter(request, response);
        }
        System.out.println("结束执行过滤链");
    }

    public FilterChain registerFilter(Filter filter) {
        filterList.add(filter);
        return this;
    }

}
