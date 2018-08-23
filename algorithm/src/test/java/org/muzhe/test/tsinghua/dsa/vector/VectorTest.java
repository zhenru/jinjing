package org.muzhe.test.tsinghua.dsa.vector;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.junit.Assert;
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
    public void testFindRang(){

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0 ; i < 12 ; i++){
            orderVector.add(i);
        }
        int i = orderVector.find(3, 0, 11);
        Assert.assertEquals(2, i);
    }

    @Test
    public void testFindValueInRange(){

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i = 0 ; i < 12;i++ ){
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
    public void testDeDuplicate(){

        OrderVector orderVector = new OrderVector();

        for (int i = 0 ; i< 100;i++){
            orderVector.add(i);
            orderVector.add(i+1);
        }
        int i = orderVector.deDuplicate();
        System.out.println(i);

        System.out.println(orderVector);
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

    @Test
    public void testUniquify(){

        OrderVector<Integer> orderVector = new OrderVector<Integer>();
        for (int i =0 ; i< 10 ; i++){
            orderVector.add(i);
            orderVector.add(i+1);
        }
        System.out.println(orderVector);
        int uniquify = orderVector.uniquify();

        System.out.println(uniquify);
        System.out.println(orderVector);



    }
}