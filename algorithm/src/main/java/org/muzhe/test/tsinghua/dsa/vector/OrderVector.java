package org.muzhe.test.tsinghua.dsa.vector;

/**
 * 有序向量
 *
 * @author muzhe-wang on 18/8/21.
 */
public class OrderVector<T> implements Vector<T> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     *
     * 存储数据的容器
     */
    private Object[] elements;

    /**
     * 当前向量的容量
     */
    private int capacity;

    /**
     * 当前容器中数据个数
     */
    private int size = 0;

    public OrderVector() {
        elements = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;

    }

    public OrderVector(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("数组的长度不能小于0");
        }
        elements = new Object[capacity];
        this.capacity = capacity;
        this.size  = 0;
    }

    public OrderVector(OrderVector orderVector) {
        copyFrom(orderVector.elements, 0, orderVector.size);
    }

    public OrderVector(OrderVector orderVector , int start , int end){
        copyFrom(orderVector.elements, start , end);
    }

    public int size() {
        return this.size;
    }

    public T get(int r) {

        if (r>= size|| r<0){
            throw new RuntimeException("当前的元素的位置非法");
        }
        return (T)elements[r];

    }

    /**
     * 将第r个位置上的值设置为value
     * @param r
     * @param value
     */
    public void put(int r, T value) {

        if (r>=size || r< 0){
            throw new RuntimeException("当前元素的位置非法");
        }


    }

    public void insert(int r, T value) {

    }

    public T remove(int r) {
        return null;
    }

    public boolean disordered() {
        return false;
    }

    public void sort() {

    }

    public int find(T t) {
        return 0;
    }

    public int search(T t) {
        return 0;
    }

    public void duplicate() {

    }

    public void uniquify() {

    }

    public void traverse(Function<T> function) {

    }

    /**
     * 将 source中从start开始到end结束的元素复制到  当前数组中去
     * 在copy中设置了容量和数据的多少。
     * @param source 源数组
     * @param start  开始位置
     * @param end    结束位置
     */
    private void copyFrom(Object[] source, int start, int end) {
        //两倍容量
        this.capacity = (end - start)*2;
        //分配新空间
        this.elements = new Object[this.capacity];
        //空间清零
        this.size = 0;
        //copy新的数据容量
        while (start < end){
            this.elements[size++] = source[start++];
        }
    }

}
