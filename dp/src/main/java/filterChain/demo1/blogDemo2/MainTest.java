package filterChain.demo1.blogDemo2;

/**
 * @author muzhe-wang on  18-7-12 下午2:31.
 */
public class MainTest {

    public static void main(String[] args) {

        FilterChain filterChain = generateStdLogFilter();
        String request = "request";
        String response = "response";
        filterChain.doFilter(request, response, filterChain);
        System.out.println("**********************************");
        FilterChain filterChain2 = genearteLogStdFilter();
        filterChain2.doFilter(request, response, filterChain2);
    }

    private static FilterChain genearteLogStdFilter() {

        FilterChain filterChain = new FilterChain();
        Filter logFilter = new LogFilter();
        Filter stdFilter = new StdFilter();
        filterChain.addFilter(logFilter).addFilter(stdFilter);
        return filterChain;

    }

    private static FilterChain generateStdLogFilter() {
        FilterChain filterChain = new FilterChain();
        Filter stdFilter = new StdFilter();
        Filter logFilter = new LogFilter();
        filterChain.addFilter(stdFilter).addFilter(logFilter);
        return filterChain;
    }
}
