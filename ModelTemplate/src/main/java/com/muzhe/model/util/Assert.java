package com.muzhe.model.util;

import java.util.function.Supplier;

/**
 * @author muzhe-wang on  18-9-14 下午5:59.
 */
public class Assert {


    /**
     * 校验当前的表达式是否是合法的表达式
     * @param expression
     * @param supplier
     */
    public static void assertTrue(boolean expression, Supplier<LocalException> supplier) {
        if (expression) {
            throw supplier.get();
        }
    }
}
