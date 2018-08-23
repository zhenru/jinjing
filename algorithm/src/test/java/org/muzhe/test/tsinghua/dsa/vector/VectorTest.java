package org.muzhe.test.tsinghua.dsa.vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * todo 这里后面再改一下。
 * @author muzhe-wang on 18/8/23.
 */
public class VectorTest {

    @Test
    public void testNewVector(){

        OrderVector<String> orderVector = new OrderVector<String>();
        System.out.println(orderVector.size());
    }

    @Test
    public void testNewVector2(){

        OrderVector<String> orderVector = new OrderVector<String>(9);
        System.out.println(orderVector.size());

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
    public void testAdd(){

        OrderVector<Integer> orderVector = new OrderVector<Integer>(12);
        orderVector.add(12);
        orderVector.add(23);
        for (int i =  0  ; i< 100000; i++){
            orderVector.add(i);
        }
        System.out.println(orderVector);

    }
}