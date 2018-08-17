package filterChain.demo1.blogDemo;

/**
 * @author muzhe-wang on  18-7-12 上午11:25.
 */
public class SoutFilter implements Filter {

    public void doSomething(String request, String response) {
        System.out.println("request : " + request + "  response : " + response);
    }

}
