package org.muzhe.test.tsinghua.dsa2.sequence;

import com.sun.org.glassfish.gmbal.ManagedObject;
import lombok.ToString;

import static org.muzhe.test.tsinghua.dsa2.sequence.Assert.assertTrue;

/**
 * 向量
 *
 * @author muzhe-wang on  18-9-3 下午2:46.
 */
public class Vector<T extends Comparable<T>> implements Sequence<T> {

    private static int DEFAULT_CAPACITY = 10;

    /**
     * 向量长度
     */
    private int size;

    /**
     * 存放元素元素的数组
     */
    private Object[] elements;

    /**
     * 容量
     */
    private int capacity;

    /**
     * @param c
     */
    public Vector(int c) {
        assertTrue(c > 0, () -> "c不能小于０");
        this.elements = new Object[c];
        this.size = 0;
        this.capacity = c;
    }

    public Vector() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public Vector(Vector vector) {
        copyFrom(vector, 0, vector.size);
        this.capacity = vector.capacity;
        this.size = vector.size;
    }

    /**
     * 使用copy的方式来初始化系统
     *
     * @param vector
     * @param low
     * @param high
     */
    public Vector(Vector vector, int low, int high) {

        this.elements = new Object[(high - low) * 2];
        copyFrom(vector, low, high);

    }

    /**
     * 将　[low,high)中的元素copy到当前的元素中
     *
     * @param vector
     * @param low
     * @param high
     */
    public void copyFrom(Vector vector, int low, int high) {
        assertTrue(vector != null && low >= 0 && high < vector.size, () -> "非法参数");

        while (low < high) {
            this.elements[size++] = vector.elements[low++];
        }
    }

    @Override
    public void expand() {

        //向量空间不足的时候需要对数组进行扩容
        //这个是在插入每一元素的时候需要对当前的数组进行扩容
        if (this.size < this.capacity) {
            return;
        }

        //不低于默认元素，主要是开始的时候可能会创建出比默认元素小的数组
        if (this.capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }

        Object[] oldElements = this.elements;
        this.elements = new Object[this.capacity <<= 1];
        for (int i = 0; i < size; i++) {
            this.elements[i] = oldElements[i];
        }
        oldElements = null;
    }

    @Override
    public void shrink() {

    }

    @Override
    public boolean bubble(int low, int high) {
        return false;
    }

    @Override
    public boolean bubbleSort(int low, int high) {
        return false;
    }

    @Override
    public int max(int low, int high) {
        return 0;
    }

    @Override
    public void selectSort(int low, int high) {

    }

    @Override
    public void merge(int low, int mid, int high) {

    }

    @Override
    public void mergeSort(int low, int high) {

    }

    @Override
    public int partition(int low, int high) {
        return 0;
    }

    @Override
    public void quickSort(int low, int high) {

    }

    @Override
    public void heapSort(int low, int high) {

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int disOrdered() {
        return 0;
    }

    @Override
    public int find(T ele) {
        return find(ele, 0, size);
    }

    @Override
    public int find(T ele, int low, int high) {
        checkSection(low, high);
        //从最后开始比较。这里的一个在第一个逻辑表达式里使用了high--来移动元素这里使用的挺巧妙的。
        //我一般习惯性的从low->high进行比较，这个过程不太方便处理，如果元素不存在返回　low-1的位置
        while (low < high-- && this.elements[high] != ele) {
        }
        return high;
    }

    @Override
    public int search(T ele) {
        return 0;
    }

    @Override
    public int search(T ele, int low, int high) {
        return 0;
    }

    @Override
    public T remove(int r) {
        return null;
    }

    @Override
    public int remove(int low, int high) {
        return 0;
    }


    /**
     * 将ele元素写到[0,size)元素的第r个元素的位置上去
     *
     * @param r
     * @param ele
     * @return
     */
    @Override
    public int insert(int r, T ele) {
        assertTrue(r <= size, () -> "参数非法");
        //1.扩容
        expand();
        //2.移动数据，腾位置
        for (int i = size; i > r; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[r] = ele;
        this.size++;
        return r;
    }

    /**
     * 默认将元素插入到当前元素的最后的地方
     *
     * @param ele
     * @return
     */
    @Override
    public int insert(T ele) {
        return insert(this.size, ele);
    }

    @Override
    public void sort(int low, int high) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void unSort() {

    }

    @Override
    public void unSort(int low, int high) {

    }

    @Override
    public int deduplicate() {
        return 0;
    }

    @Override
    public int uniquify() {
        return 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]).append(" ");
        }
        return sb.toString();
    }


    private void checkSection(int low, int high) {
        assertTrue(low >= 0 && low < high && high <= size, () -> "参数不合法");
    }


}
