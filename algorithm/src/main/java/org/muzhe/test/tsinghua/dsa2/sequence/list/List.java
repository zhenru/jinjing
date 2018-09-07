package org.muzhe.test.tsinghua.dsa2.sequence.list;

/**
 * @author muzhe-wang on  18-9-7 下午1:19.
 */
public interface List<T> {

    /**
     * 初始化
     */
    void init();

    /**
     * 清除所有节点
     *
     * @return
     */
    int clear();

    /**
     * 复制　列表node中的第n项开始的节点
     *
     * @param node
     * @param n
     */
    void copyNodes(ListNode<T> node, int n);

    /**
     * 归并?
     *
     * @param first
     * @param firstCount
     * @param second
     * @param secondCount
     */
    void merge(ListNode<T> first, int firstCount, ListNode<T> second, int secondCount);

    /**
     * 对从head开始的n个元素进行排序
     *
     * @param head
     * @param n
     */
    void mergeSort(ListNode<T> head, int n);

    /**
     * head后n个元素进行选择排序
     *
     * @param head
     * @param n
     */
    void selectSort(ListNode<T> head, int n);

    ////////////////////////////////////////////////只读函数////////////////////////////////////////////////////////

    /**
     * list中包含的元素个数
     *
     * @return
     */
    int size();

    /**
     * 当前list是否为空。
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 第一个元素
     *
     * @return
     */
    ListNode<T> first();

    /**
     * 最后一个元素
     *
     * @return
     */
    ListNode<T> last();

    /**
     * 判断当前元素的是否合法
     *
     * @param node
     * @return
     */
    boolean valid(ListNode<T> node);

    /**
     * 判断列表是否有序
     *
     * @return
     */
    int disordered();

    /**
     * 无序查找
     *
     * @param data
     * @return
     */
    ListNode<T> find(T data);

    /**
     * 无序序列中　p节点开始[0,n）后面的元素中查找　data元素。
     *
     * @param data
     * @param p
     * @param n
     * @return
     */
    ListNode<T> find(T data, ListNode<T> p, int n);

    /**
     * 有序list中查找data对应的列表
     *
     * @param data
     * @return
     */
    ListNode<T> search(T data);

    /**
     * 有序list中　low和　high之间进行查找data/
     *
     * @param data
     * @param low
     * @param high
     * @return
     */
    ListNode<T> search(T data, int low, int high);

    /**
     * @param data
     * @param n
     * @return
     */
    ListNode<T> selectMax(ListNode<T> data, int n);

    /**
     * zhao chu zui da de yuanshu ,zai dangiqan xitong zhong .
     *
     * @return
     */
    ListNode<T> selectMax();

    /**
     * insert data as first ele
     *
     * @param data
     * @return
     */
    ListNode<T> insertAsFirst(T data);

    /**
     * data作爲最後一個元素插入到list
     *
     * @param data
     * @return
     */
    ListNode<T> insertAsLast(T data);

    /**
     * 將data插入到node後面
     *
     * @param node
     * @param data
     * @return
     */
    ListNode<T> insertAfter(ListNode<T> node, T data);

    /**
     * 將data插入到node前面
     *
     * @param node
     * @param data
     * @return
     */
    ListNode<T> insertBefore(ListNode<T> node, T data);

    /**
     * 刪除node節點，返回node對應的data值
     *
     * @param node
     * @return
     */
    T remove(ListNode<T> node);

    /**
     * 將　list歸並到當前數組中來
     *
     * @param list
     */
    void merge(List<T> list);

    /**
     * node開始後面的n個元素進行排序
     *
     * @param node
     * @param n
     */
    void sort(ListNode<T> node, int n);

    /**
     * 對當前list進行排序。
     */
    void sort();

    /**
     * 無序去重
     *
     * @return
     */
    int duplicate();

    /**
     * 有序去重
     *
     * @return
     */
    int uniquify();

    /**
     * 反序
     */
    void reverse();

    /**
     * 遍历
     */
    void traverse();

}
