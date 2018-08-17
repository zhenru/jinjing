package org.muzhe.test.lambda.internalClass.d3;

/**
 * @author muzhe-wang on  18-7-19 下午5:36.
 */
public class MainTest {

    public static void test(MyInterface3 interface3) {
        interface3.handle("nihao");
    }

    public static void main(String[] args) {

        test((s) -> {
            s = s + s;
            System.out.println(s);
        });

    }
}
