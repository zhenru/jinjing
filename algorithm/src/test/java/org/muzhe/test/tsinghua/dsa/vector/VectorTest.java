package org.muzhe.test.tsinghua.dsa.vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
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
}