package structure.adapters.adapter1;

/**
 * @author muzhe-wang on  18-9-10 下午3:23.
 */
public class Adapter1 extends Source1 implements Targetable {


    public void method2() {
        System.out.println("这个是新的implement的对象");
    }
}
