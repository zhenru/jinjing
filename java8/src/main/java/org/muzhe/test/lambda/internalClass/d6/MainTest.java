package org.muzhe.test.lambda.internalClass.d6;

/**
 * @author muzhe-wang on  18-7-19 下午5:52.
 */
public class MainTest {


    public static String test(MyInterface6 myInterface6) {

        int calResult = myInterface6.cal(1, 3);
        String testResult = "cal Result " + calResult + " send result " + " success ";
        System.out.println(testResult);
        return testResult;

    }

    public static void main(String[] args) {

        test((x, y) -> {
            System.out.println(x + " + " + y + " = " + (x + y));
            return x + y;
        });

    }
}
