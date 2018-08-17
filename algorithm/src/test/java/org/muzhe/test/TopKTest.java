package org.muzhe.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-7-11 下午3:42.
 */
public class TopKTest {

    private TopK topK = new TopK();

    @Test
    public void topK() {

        int[] array = {2, 2, 2};
        int i = topK.topK(array, 2);
        System.out.println(i);
    }

    @Test
    public void testTopK() {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = topK.topK(array, 4);
        System.out.println(result);

    }

    @Test
    public void testTop0() {

        int[] array = {1, 2, 3, 4, 5, 6};
        int i = topK.topK(array, 5);
        System.out.println(i);

    }
}