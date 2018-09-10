package structure.adapters.adapter1;

/**
 * @author muzhe-wang on  18-9-10 下午3:25.
 */
public class TestDemo1 {

    public static void main(String[] args) {
        Targetable targetable = new Adapter1();
        targetable.method1();
        targetable.method2();
    }
}
