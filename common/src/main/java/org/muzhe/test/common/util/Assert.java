package org.muzhe.test.common.util;

import org.muzhe.test.common.exception.CommonException;

import java.util.function.Supplier;

/**
 * @author muzhe-wang on  18-8-16 下午4:32.
 */
public class Assert {

    /**
     * 如果expression不为真，抛出异常。
     * @param expression
     * @param exceptionSupplier
     */
    public static void assertTrue(boolean expression, Supplier<CommonException> exceptionSupplier) {
        if (!expression) {
            throw exceptionSupplier.get();
        }
    }
}
