package structure.adapters.adapter2;

import structure.adapters.adapter1.Source1;
import structure.adapters.adapter1.Targetable;

/**
 * @author muzhe-wang on  18-9-10 下午3:43.
 */
public class Wrapper implements Targetable {

    private Source1 source1;

    public Wrapper(Source1 source1) {
        this.source1 = source1;
    }

    public void method1() {
        System.out.println("===============================当前对象适配了　对象　Source =======================");
        source1.method1();
    }

    public void method2() {
        System.out.println("this is the object adapter method 2");
    }
}
