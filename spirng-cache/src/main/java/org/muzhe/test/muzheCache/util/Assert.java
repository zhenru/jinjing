package org.muzhe.test.muzheCache.util;

import org.muzhe.test.muzheCache.exceptions.LocalException;

import java.util.function.Supplier;

/**
 * @author muzhe-wang on  18-8-20 下午2:53.
 */
public class Assert {

    /**
     * 判断当前表达式是否成立
     * @param expression        当前系统中的表达式
     * @param exceptionSupplier 异常提供信息
     */
    public static void assertTrue(boolean expression, Supplier<LocalException> exceptionSupplier) {
        if (expression) {
            throw exceptionSupplier.get();
        }
    }
}
