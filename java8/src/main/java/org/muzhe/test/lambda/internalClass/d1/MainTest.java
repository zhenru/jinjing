package org.muzhe.test.lambda.internalClass.d1;

/**
 * @author muzhe-wang on  18-7-19 下午4:51.
 */
public class MainTest {

    public static void test(MyInterface myInterface) {
        myInterface.myMethod();
    }

    public static void main(String[] args) {
//       普通实现
        test(new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("Hello World");
            }
        });
//      lamda表达式
        test(() -> System.out.println("Hello World!"));
    }
}
