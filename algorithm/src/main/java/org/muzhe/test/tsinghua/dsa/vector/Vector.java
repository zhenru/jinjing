package org.muzhe.test.tsinghua.dsa.vector;

/**
 * @author muzhe-wang on 18/8/21.
 */
public interface Vector<T> {


    /**
     * 获取当前向量中的数据的个数
     * @return
     */
    int size();

    /**
     * 获取第r位置上的值
     * @param r
     * @return
     */
    T get(int r);

    /**
     * 用value替换r位置上的值
     * @param r
     * @param value
     */
    void put(int r , T value);

    /**
     * 将元素value插入到第r位置，后面的元素依次往后移动
     * @param r
     * @param value
     */
    void insert(int r , T value);

    /**
     * 删除第r位置上的值，后面的元素依次向前移动，并返回被删除的值
     * @param r
     * @return
     */
    T remove(int r);

    /**
     * 判断当前向量按照非降序排列
     * @return
     */
    boolean disordered();

    /**
     * 对当前向量进行排序
     */
    void sort();

    /**
     * 查找t在当前向量中的位置
     * @param t
     * @return
     */
    int find(T t);

    /**
     * note:这个向量是一个有序向量
     * 在向量中查找t,返回向量中不大于t的最大位置
     * @param t
     * @return
     */
    int search(T t);

    /**
     * 向量是一个无序向量
     * 删除当前向量中的重复的部分
     */
    void duplicate();

    /**
     * 有序向量中重复的部分删除
     */
    void uniquify();

    /**
     * 遍历当前向量并使用function函数来处理对应的元素
     * @param function
     */
    void traverse(Function<T> function);

}
