package structure.adapters.adapter2;

import structure.adapters.adapter1.Source1;

/**
 * @author muzhe-wang on  18-9-10 下午3:45.
 */
public class MainTest {

    public static void main(String[] args) {
        Source1 source1 = new Source1();
        Wrapper wrapper = new Wrapper(source1);
        wrapper.method1();
    }
}
