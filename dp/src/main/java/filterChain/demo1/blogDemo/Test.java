package filterChain.demo1.blogDemo;

/**
 * @author muzhe-wang on  18-7-12 上午11:05.
 */
public class Test {


    public void handlerRequest(String request, String response) {

        doSomething1(request, response);
        doSomething2(request, response);
        doSomething3(request, response);

    }

    private void doSomething3(String request, String response) {

    }

    private void doSomething2(String request, String response) {

    }

    private void doSomething1(String request, String response) {

    }
}
