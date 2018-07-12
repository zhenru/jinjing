package filterChain.demo1.dubboTestCase1;

/**
 * @author muzhe-wang on  18-7-12 下午4:22.
 */
public interface Filter {

    /**
     * 执行当前系统中的实现
     *
     * @param invoker    执行器,这个执行器需要封装在当前的方法中，否则就需要提供一个方法给Filter取得当前Filter封装Invoker对象。
     * @param invocation 执行参数
     * @return 执行结果
     */
    public String filter(Invoker invoker, String invocation);

}
