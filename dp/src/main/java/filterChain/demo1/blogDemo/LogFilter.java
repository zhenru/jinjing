package filterChain.demo1.blogDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author muzhe-wang on  18-7-12 上午11:27.
 */
@Slf4j
public class LogFilter implements  Filter {

    public void doSomething(String request, String response) {
        log.info("request : " + request + "  response : " + response);
    }

}
