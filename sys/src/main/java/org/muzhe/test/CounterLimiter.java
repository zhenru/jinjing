package org.muzhe.test;

import java.util.LinkedList;

/**
 * @author muzhe-wang on  18-7-18 上午11:05.
 */
public class CounterLimiter {

    private LinkedList<Integer> ll = new LinkedList<Integer>();
    int counter = 0;


    public static void main(String[] args) {

        CounterLimiter counterLimiter = new CounterLimiter();
        for (int i = 0 ;i < 100 ; i++){

            counterLimiter.doCheck();
        }

    }

    /**
     * 判断当前的请求是否是合法的
     */
    private void doCheck() {

        while (true) {
            ll.add(counter);

            if (ll.size() > 10) {
                ll.removeFirst();
            }
            System.out.println(" -- ");

            if ((ll.peekLast() - ll.peekFirst()) > 100) {
                System.out.println("限流");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
