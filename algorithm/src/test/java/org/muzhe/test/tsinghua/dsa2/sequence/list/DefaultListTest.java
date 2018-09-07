package org.muzhe.test.tsinghua.dsa2.sequence.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-9-7 下午2:19.
 */
public class DefaultListTest {

    private DefaultList<Integer> defaultList = new DefaultList<>();

    {
        defaultList.init();
    }

    @Test
    public void init() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void copyNodes() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void mergeSort() {
    }

    @Test
    public void selectSort() {
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void first() {
    }

    @Test
    public void last() {
    }

    @Test
    public void valid() {
    }

    @Test
    public void disordered() {
    }

    @Test
    public void find() {

        for (int i = 0 ; i<=20 ; i++){
            defaultList.insertAsLast(i);
        }

        ListNode<Integer> integerListNode = defaultList.find(12);
        System.out.println(integerListNode.getData());

        ListNode<Integer> integerListNode1 = integerListNode.insertAfter(13);
        integerListNode.insertBefore(11);

        System.out.println(defaultList);

        ListNode<Integer> integerListNode2 = defaultList.find(24, integerListNode, 29);
        System.out.println(integerListNode2);

    }

    @Test
    public void find1() {
    }

    @Test
    public void search() {
    }

    @Test
    public void search1() {
    }

    @Test
    public void selectMax() {
    }

    @Test
    public void selectMax1() {
    }

    @Test
    public void insertAsFirst() {

        //不断的不数据写到　第一个元素，这样得到的list是一个倒序的队列
        for (int i = 0; i < 20; i++) {
            defaultList.insertAsFirst(i + 1);
        }
        System.out.println(defaultList);

    }

    @Test
    public void insertAsLast() {

        for(int i = 0 ; i < 20 ;i++){
            defaultList.insertAsLast(i+1);
        }
        System.out.println(defaultList);
    }

    @Test
    public void insertAfter() {

    }

    @Test
    public void insertBefore() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void merge1() {
    }

    @Test
    public void sort() {
    }

    @Test
    public void sort1() {
    }

    @Test
    public void duplicate() {
    }

    @Test
    public void uniquify() {
    }

    @Test
    public void reverse() {
    }

    @Test
    public void traverse() {
    }
}