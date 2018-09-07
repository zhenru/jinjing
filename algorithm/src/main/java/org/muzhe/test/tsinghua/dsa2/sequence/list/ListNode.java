package org.muzhe.test.tsinghua.dsa2.sequence.list;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author muzhe-wang on  18-9-7 下午1:16.
 */
@Getter
@Setter
public class ListNode<T> {

    /**
     * 节点内容
     */
    private T data;

    /**
     * 节点前驱
     */
    private ListNode pred;

    /**
     * 节点后继
     */
    private ListNode succ;

    /**
     * 将data写到　当前节点后面
     *
     * @param data
     */
    public ListNode<T> insertAfter(T data) {

        ListNode<T> node = new ListNode<>();
        node.setData(data);

        ListNode<T> next = this.succ;
        node.pred = this;
        this.succ = node;
        node.succ = next;
        next.pred = node;

        return node;

    }

    /**
     * 将当前节点写到当前　节点前面
     *
     * @param data
     */
    public ListNode<T> insertBefore(T data) {

        ListNode<T> node = new ListNode<>();
        node.setData(data);

        /**
         * 修改相互依赖数据。由于使用了头尾哨兵，所以可以不用考虑null的情况。
         */
        ListNode<T> pre = this.pred;
        node.pred = pre;
        node.succ = this;
        this.pred = node;
        pre.succ = node;

        return node;
    }

}
