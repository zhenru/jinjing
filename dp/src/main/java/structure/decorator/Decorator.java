package structure.decorator;

/**
 * @author muzhe-wang on  18-9-10 下午6:10.
 */
public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void method() {

        System.out.println("开始装饰");
        sourceable.method();
        System.out.println("结束装饰");

    }
}
