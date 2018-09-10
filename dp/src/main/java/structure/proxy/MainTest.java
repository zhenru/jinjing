package structure.proxy;

/**
 * @author muzhe-wang on  18-9-10 下午6:20.
 */
public class MainTest {

    public static void main(String[] args) {

        Sourceable sourceable = new Source();
        Proxy proxy = new Proxy(sourceable);
        proxy.method();
    }
}
