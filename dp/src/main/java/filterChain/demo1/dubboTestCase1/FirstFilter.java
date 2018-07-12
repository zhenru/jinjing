package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:24.
 */
public class FirstFilter implements Filter {

    public String filter(Invoker invoker, String invocation) {
        System.out.println("first　" + invocation);
        String result = invoker.doInvoke(invocation);
        System.out.println("first　" + invocation);
        return result;
    }

}
