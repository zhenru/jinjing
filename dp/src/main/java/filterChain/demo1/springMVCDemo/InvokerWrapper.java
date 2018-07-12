package filterChain.demo1.springMVCDemo;

/**
 * @author muzhe-wang on  18-7-12 下午7:00.
 */
public class InvokerWrapper {

    public static Invoker wrapperInvoker(Invoker invoker) {

        final Invoker invokerF = invoker;
        return new Invoker() {
            public void invoke(String request, String response) {
                FilterChain filterChain = getFilterChain();
                filterChain.preHandle(request, response);
                invokerF.invoke(request, response);
                filterChain.postHandle(request, response);
            }
        };
    }

    private static FilterChain getFilterChain() {

        FilterChain filterChain = new FilterChain();

        FirstHandler firstHandler = new FirstHandler();
        SecondHandler secondHandler = new SecondHandler();
        filterChain.addFilterChain(firstHandler).addFilterChain(secondHandler);

        return filterChain;
    }
}
