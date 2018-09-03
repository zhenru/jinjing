package org.muzhe.test.tsinghua.dsa2.sequence;

/**
 * @author muzhe-wang on  18-9-3 下午2:17.
 */
public  interface Sequence<T extends Comparable<T>> {

    /**
     * 对当前向量进行扩容
     */
    void expand();

    /**
     * 缩小容量
     */
    void shrink();

    /**
     * 对low到high空间进行一次　扫描交换
     * @param low
     * @param high
     * @return
     */
    boolean bubble(int low, int high);

    /**
     *冒泡排序
     * @param low
     * @param high
     * @return
     */
    boolean bubbleSort(int low ,int high);

    /**
     * 找出low和high的最大的元素
     * @param low
     * @param high
     * @return
     */
    int max(int low ,int high);

    /**
     * 选择排序
     * @param low
     * @param high
     */
    void selectSort(int low ,int high);

    /**
     * 对有序的[low,mid),[mid,high)的元素进行归并
     * @param low
     * @param mid
     * @param high
     */
    void merge(int low, int mid , int high);

    /**
     * 对  [low,high)进行归并排序
     * @param low
     * @param high
     */
    void mergeSort(int low ,int high);

    /**
     * 轴点构造算法
     * @param low
     * @param high
     * @return
     */
    int partition(int low ,int high);

    /**
     * 快速排序
     * @param low
     * @param high
     */
    void quickSort(int low,int high);

    /**
     * 堆排序
     * @param low
     * @param high
     */
    void heapSort(int low ,int high);


//////////////////////////////////////////只读访问接口//////////////////////////////////////////////////////////

    /**
     *向量的元素
     * @return
     */
    int size();

    /**
     * 当前元素是否是空
     * @return
     */
    boolean empty();

    /**
     * 判断向量是否已经排序
     * @return
     */
    int disOrdered();

    /**
     * 查找元素的位置
     * @param ele
     * @return
     */
    int find(T ele);

    /**
     * 在[low,high)区间中查找ele的位置
     * @param ele
     * @param low
     * @param high
     * @return
     */
    int find(T ele ,int low,int high);

    /**
     * 有序向量中寻找，找出不大于ele最后的位置
     * @param ele
     * @return
     */
    int search(T ele);

    /**
     * 在有序向量[low,high)区间中寻找　ele应该在的位置
     * @param ele
     * @param low
     * @param high
     * @return
     */
    int search(T ele, int low, int high);

    /**
     * 删除　秩为r的元素，并返回对应的元素
     * @param r
     * @return
     */
    T remove(int r);

    /**
     * 删除向量中　[low,high)中的元素
     * @param low
     * @param high
     * @return
     */
    int remove(int low, int high);

    /**
     * 把ele插入到r对应的位置上
     * @param r
     * @param ele
     * @return
     */
    int insert(int r, T ele);

    /**
     * 将当前元素插入到向量末尾
     * @param ele
     * @return
     */
    int insert(T ele);

    /**
     * 对　[low,high)区间的元素进行排序
     * @param low
     * @param high
     */
    void sort(int low, int high);

    /**
     * 对当前向量进行排序
     */
    void sort();

    /**
     * 对　向量　进行乱序
     */
    void unSort();

    /**
     * 对[low,high)进行乱序
     * @param low
     * @param high
     */
    void unSort(int low, int high);

    /**
     * 无序去从
     * @return
     */
    int deduplicate();

    /**
     * 无序去重
     * @return
     */
    int uniquify();

}