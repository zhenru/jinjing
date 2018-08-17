package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:18.
 */
public interface Invoker {

    /**
     * 执行当前的实现。这个类是被封装的对象
     * @param invocation
     * @return
     */
    String doInvoke(String invocation);

}
