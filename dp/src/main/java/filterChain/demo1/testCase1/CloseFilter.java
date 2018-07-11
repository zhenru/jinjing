package filterChain.demo1.testCase1;

import filterChain.demo1.core.Filter;
import filterChain.demo1.core.Request;
import filterChain.demo1.core.Response;

/**
 * @author muzhe-wang on  18-7-11 下午6:10.
 */
public class CloseFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response) {
        response.append("+ close");
        request.append("- close");
    }

}
