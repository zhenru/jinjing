package org.muzhe.test.tsinghua.dsa2.sequence.vector;


import java.util.function.Supplier;

/**
 * @author muzhe-wang on  18-9-3 下午3:00.
 */
public class Assert {

    public static void assertTrue(boolean expression, Supplier<String> supplier) {
        if (!expression) {
            throw new RuntimeException(supplier.get());
        }
    }
}
