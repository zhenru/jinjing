package org.muzhe.test.tsinghua.dsa.vector;

import org.junit.Assert;
import org.junit.Test;

/**
 * todo 这里后面再改一下。
 *
 * @author muzhe-wang on 18/8/23.
 */
public class VectorTest {

    @Test
    public void testNewVector() {

        OrderVector<String> orderVector = new OrderVector<String>();
        System.out.println(orderVector.size());
    }

    @Test
    public void testNewVector2() {

        OrderVector<String> orderVector = new OrderVector<String>(9);
        System.out.println(orderVector.size());

    }

    @Test
    public void testFindRang() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 12; i++) {
            orderVector.add(i);
        }
        int i = orderVector.find(3, 0, 11);
        Assert.assertEquals(2, i);
    }

    @Test
    public void testFindValueInRange() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 12; i++) {
            orderVector.add(i);
        }

        int i = orderVector.find(-1, 0, 11);

        System.out.println(i);
    }

    @Test
    public void size() {
    }

    @Test
    public void get() {
    }

    @Test
    public void put() {
    }

    @Test
    public void insert() {
        OrderVector<Integer> orderVector = new OrderVector<Integer>(12);
    }

    @Test
    public void remove() {
    }

    @Test
    public void disordered() {
    }

    @Test
    public void sort() {
    }

    @Test
    public void find() {
    }

    @Test
    public void search() {
    }

    @Test
    public void duplicate() {
    }

    @Test
    public void uniquify() {
    }

    @Test
    public void traverse() {
    }


    @Test
    public void testBinSearch() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 2000; i++) {
            orderVector.add(i * 2 + 1);
        }

        System.out.println(orderVector);

        int i = orderVector.binSearch(3, 0, orderVector.size());
        System.out.println(i);

    }

    @Test
    public void testBinSearch2() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();

        for (int i = 0; i < 2000; i++) {
            orderVector.add(i * 2 + 1);
        }
        System.out.println(orderVector);

        int i = orderVector.binSearch2(78, 0, orderVector.size());
        System.out.println(i);
    }


    @Test
    public void testBinSearch3() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 2000; i++) {
            orderVector.add(i);
            orderVector.add(i + 1);
        }
        System.out.println(orderVector);
        int i = orderVector.binSearch3(2001, 0, orderVector.size());
        System.out.println(orderVector.get(i));
        System.out.println(i);
    }


    @Test
    public void testDeDuplicate() {

        OrderVector orderVector = new OrderVector();

        for (int i = 0; i < 100; i++) {
            orderVector.add(i);
            orderVector.add(i + 1);
        }
        int i = orderVector.deDuplicate();
        System.out.println(i);

        System.out.println(orderVector);
    }


    @Test
    public void testAdd() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>(12);
        orderVector.add(12);
        orderVector.add(23);
        for (int i = 0; i < 100000; i++) {
            orderVector.add(i);
        }
        System.out.println(orderVector);

    }

    @Test
    public void testUniquify() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 10; i++) {
            orderVector.add(i);
            orderVector.add(i + 1);
        }
        System.out.println(orderVector);
        int uniquify = orderVector.uniquify();

        System.out.println(uniquify);
        System.out.println(orderVector);

    }

    @Test
    public void testBubbleSortBase() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();

        orderVector.add(12);
        orderVector.add(13);
        for (int i = 0; i < 12; i++) {
            orderVector.add(i);
        }

        System.out.println(orderVector);

        orderVector.bubbleSortBase(0, orderVector.size());

        System.out.println(orderVector);
    }

    @Test
    public void testBubbleSortBase2() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        orderVector.add(12);
        orderVector.add(13);
        for (int i = 0; i < 12; i++) {
            orderVector.add(i);
        }

        System.out.println(orderVector);
        orderVector.bubbleSortBase2(0, orderVector.size());
        System.out.println(orderVector);
    }

    @Test
    public void testBubbleSortBase3() {

        OrderVector<Integer> sequeOrderVector = generateSequeOrderVector1();
        OrderVector<Integer> unSequeOrderVector = generateUnSequeOrderVector2();
        OrderVector<Integer> emptyOrderVectory = generateEmptyOrderVector();

        System.out.println(sequeOrderVector);
        sequeOrderVector.bubbleSortBase2(0, sequeOrderVector.size());
        System.out.println(sequeOrderVector);

        System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");

        System.out.println(unSequeOrderVector);
        unSequeOrderVector.bubbleSortBase2(0, unSequeOrderVector.size());
        System.out.println(unSequeOrderVector);
        System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");

        System.out.println(emptyOrderVectory);
        emptyOrderVectory.bubbleSortBase2(0, emptyOrderVectory.size());
        System.out.println(emptyOrderVectory);
    }

    @Test
    public void testBubbleSort3() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 200; i++) {
            if (i % 2 == 0) {
                orderVector.add(i * 2 + 1);
            } else if (i % 3 == 0) {
                orderVector.add(i * 3 + 1);
            } else if (i % 5 == 0) {
                orderVector.add(i * 5 + 1);
            } else {
                orderVector.add(i);
            }
        }

        System.out.println(orderVector);
        orderVector.bubbleSortBase3(0, orderVector.size());
        System.out.println(orderVector);

    }

    /**
     * 构造一个空的元素
     *
     * @return
     */
    private OrderVector<Integer> generateEmptyOrderVector() {

        return new OrderVector<Integer>();

    }

    /**
     * 构造逆序的元素
     *
     * @return 一个逆序的元素
     */
    private OrderVector<Integer> generateUnSequeOrderVector2() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0; i < 100; i++) {

            orderVector.add(100 - i);
        }
        return orderVector;
    }

    /**
     * 构造有序的序列
     *
     * @return
     */
    private OrderVector<Integer> generateSequeOrderVector1() {

        OrderVector<Integer> orderVector = new OrderVector<Integer>();

        for (int i = 0; i < 100; i++) {
            orderVector.add(i);
            orderVector.add(i + 1);
        }

        return orderVector;

    }
}