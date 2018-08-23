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

        checkRank(r);
        return (T)elements[r];

    }

    /**
     * 将第r个位置上的值设置为value
     * @param r
     * @param value
     */
    public void put(int r, T value) {

        checkRank(r);
        this.elements[r] = value;
    }


    public void insert(int r, T value) {

        //校验rank
        checkRank(r);
        //判断是否需要扩容
        expand();
        //将r到最后的元素依次往后移动一个位置.边界上 第r的元素被移动到了r+1
        for (int i = this.size ; i> r ; i--){
            this.elements[i] = this.elements[i-1];
        }
        this.elements[r] = value;
        //当前容器中元素数量+1
        size++;
    }

    private void checkRank(int r) {
        if (r<0 || r> this.size) {
            throw new RuntimeException("当前元素的位置非法");
        }
    }

    /**
     * 删除第r个元素，可以特殊区间删除 remove(r ,r+1);
     * @param r
     * @return
     */
    public T remove(int r) {
        checkRank(r);
        Object returnObj = this.elements[r];
        remove(r,r+1);
        return (T)returnObj;
    }

    /**
     * 删除当前[low,high) 区间的元素
     * @param low       左区间
     * @param high      右区间
     * @return
     */
    public int remove(int low, int high){

        if (low<0 || low> high||high>size){
            throw new RuntimeException("rank不合法");
        }

        //如果相等，单独处理。
        if (low == high){
            return 0;
        }
        //移动当前元素的位置，只要将 [high,size)之间的元素移动到[low , low+size-high)后面就好
        while (high < size){
            this.elements[low++] =this.elements[high++];
        }
        //对当前空间进行缩容
        shrunk();
        this.size = low;
        return high-low;

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

    public void add(T value) {
        expand();
        this.elements[size++]=value;
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

    /**
     *溢出的情况有两种，一种是上溢，一种是下溢出。主要表示当前容器中的元素寥寥无几。
     * 可以使用一个装载因子表示当前系统中元素的个数。
     * 对当前向量的空间进行扩容。
     * todo 为什么这里使用了加倍，这样有哪些好处。这里需要研究一下。是一定要加倍还是可以使用只要是按照倍数放大而不是加上固定大小的实现。
     */
    private void expand(){

        //如果容量没有满，无需扩容
        if (this.size < this.capacity){
            return;
        }
        //扩容的大小必须比默认空间要大,可能会开始创建的时候，空间比默认空间要小的情况
        this.capacity = Math.max(this.capacity , DEFAULT_CAPACITY);
        //开始扩容，大小编程原来的两倍
        Object[] oldElements = this.elements;
        this.elements = new Object[this.capacity<<=1];
        //开始copy原有的元素
        for (int i = 0 ; i < size ; i++){
            this.elements[i] = oldElements[i];
        }
        //释放旧的元素
        oldElements = null;
    }



    private void shrunk() {


    }



    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        for (Object v : this.elements){
            sb.append(v);
        }
        return sb.toString();
    }

}
