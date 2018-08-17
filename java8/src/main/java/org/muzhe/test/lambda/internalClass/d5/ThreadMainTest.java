package org.muzhe.test.lambda.internalClass.d5;

/**
 * @author muzhe-wang on  18-7-19 下午5:46.
 */
public class ThreadMainTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好，线程启动了");
            }
        });
        thread.start();

        Thread lambadaThread = new Thread(() -> System.out.println("helllo world"));
        lambadaThread.start();
    }
}
