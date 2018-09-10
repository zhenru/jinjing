package structure.decorator;

/**
 * @author muzhe-wang on  18-9-10 下午6:11.
 */
public class MainTest {

    /**
     * 装饰器和被装饰的对象是都实现了同意个对象，这种是对象的适配
     * @param args
     */
    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Decorator decorator = new Decorator(sourceable);
        decorator.method();
    }
}
