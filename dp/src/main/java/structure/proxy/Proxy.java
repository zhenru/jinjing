package structure.proxy;

/**
 * @author muzhe-wang on  18-9-10 下午6:15.
 */
public class Proxy implements Sourceable {


    private Sourceable source;

    public Proxy(Sourceable source) {
        super();
        this.source = source;
    }

    public void method() {

        before();
        source.method();
        after();

    }

    private void before() {
        System.out.println("开始执行一些代理实现");
    }

    private void after() {
        System.out.println("结束执行一些代理实现");
    }
}
