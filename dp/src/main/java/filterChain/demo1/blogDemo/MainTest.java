package filterChain.demo1.blogDemo;

/**
 * @author muzhe-wang on  18-7-12 上午11:37.
 */
public class MainTest {

    public static void main(String[] args) {

        Filter filter = generateFilterChain();
        String request = "张三";
        String response = "zhagnsan";
        filter.doSomething(request, response);

    }

    private static Filter generateFilterChain() {

        FilterChain filterChain = new FilterChain();
        filterChain.addFilterChain(new SoutFilter());
        filterChain.addFilterChain(new LogFilter());
        return filterChain;

    }
}
