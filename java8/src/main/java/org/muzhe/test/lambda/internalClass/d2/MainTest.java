package org.muzhe.test.lambda.internalClass.d2;

/**
 * 当前方法中是一个带参数的实现。
 * @author muzhe-wang on  18-7-19 下午4:58.
 */
public class MainTest {


    /**
     * 表示cal这个方法当中需要一个函数来帮助处理。这里使用了一个匿名内部类来处理
     * 一个方法将一个处理器添加到当前方法中去。
     *
     * @param myInterface
     */
    public static void cal(MyInterface2 myInterface) {
        myInterface.calculate("你好呀");
    }


    public static void main(String[] args) {
        cal((s)-> System.out.println("hello wolrd" + s));
    }

}
