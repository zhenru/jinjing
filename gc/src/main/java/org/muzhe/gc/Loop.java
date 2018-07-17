package org.muzhe.gc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muzhe-wang on  18-7-17 下午3:43.
 */
public class Loop {

    public static void main(String[] args) throws InterruptedException {

        final ArrayList<byte[]> context = new ArrayList<byte[]>();
        final Set<byte[]> contextSet = new HashSet<byte[]>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    context.add(generate1m(100));
                    contextSet.add(generate1m(50));
                }
            }, "Thread--" + i);
            thread.start();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }


    private static byte[] generate1m(int num) {
        return new byte[num * 1024 * 1024];
    }


}
