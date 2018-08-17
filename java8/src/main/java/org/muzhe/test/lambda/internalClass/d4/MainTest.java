package org.muzhe.test.lambda.internalClass.d4;

/**
 * @author muzhe-wang on  18-7-19 下午5:39.
 */
public class MainTest {


    public static int test(MyInterface4 myInterface4) {

        int result = myInterface4.test(1, 2);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        int result = test((x, y) -> x + y);
//        ==> test((x,y) ->{
//              return x*y;
//          });

        System.out.println(result);


//        这里测试一些此啊多种实现情况
        int addResult = test((x, y) -> x + y);
        System.out.println(addResult);
        int calResult = test((x, y) -> x * y);
        System.out.println(calResult);
        int subResult = test((x, y) -> x - y);
        System.out.println(subResult);
        int multResult = test((x, y) -> x / y);
        System.out.println(multResult);
    }
}
