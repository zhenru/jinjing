package org.muzhe.test.tsinghua.dsa.vector;

/**
 * @author muzhe-wang on 18/8/21.
 */
public interface Function<T> {

    /**
     * 处理v的值
     * @param v  待处理的值
     */
    void handle(T v);
}