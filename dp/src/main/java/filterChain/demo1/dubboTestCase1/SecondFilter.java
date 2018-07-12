package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:27.
 */
public class SecondFilter implements Filter {
    public String filter(Invoker invoker, String invocation) {

        System.out.println("second 你好" + invocation);
        String result = invoker.doInvoke(invocation);
        System.out.println("end second 你好" + invocation);

        return result;
    }
}
