package filterChain.demo1.dubboTestCase1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muzhe-wang on  18-7-12 下午4:29.
 */
public class FilterWrapper {

    /**
     * 返回执行之后的Filter对象。
     * @param invoker 执行器
     * @return 封装了Filter的Invoker对象
     */
    public static Invoker buildFilterChain(Invoker invoker) {

        Invoker last = invoker;
        final List<Filter> filterList = getFilterList(invoker);

        if (filterList.size() > 0) {
            //从后往前依次封装当前对象
            for (int i = filterList.size() - 1; i >= 0; i--) {
                final Invoker next = last;
                final Filter filter = filterList.get(i);
                last = new Invoker() {
                    public String doInvoke(String invocation) {
                        return filter.filter(next, invocation);
                    }
                };
            }
        }
        return last;
    }

    private static List<Filter> getFilterList(Invoker invoker) {

        List<Filter> filterList = new LinkedList<Filter>();
        filterList.add(new FirstFilter());
        filterList.add(new SecondFilter());

        return filterList;
    }

}
