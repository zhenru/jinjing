package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-9-5 下午2:33.
 */
public class SearchTest {

    private Search search = new Search();

    private int[] elements = {0, 1, 2, 2, 2, 5, 6};

    private int existEle = 5;

    private int noExistEle = 3;

    @Test
    public void binarySearchV1() {

        int i = search.binarySearchV1(elements, 0, elements.length, existEle);
        System.out.println(i);

        int i1 = search.binarySearchV1(elements, 0, elements.length, noExistEle);
        System.out.println(i1);
    }

    @Test
    public void binarySearchV2() {

        int i = search.binarySearchV2(elements, 0, elements.length, existEle);
        System.out.println(i);

        int i1 = search.binarySearchV2(elements, 0, elements.length, noExistEle);
        System.out.println(i1);
    }

    @Test
    public void binarySearchV3() {
    }

    @Test
    public void binarySearchV4() {
    }

    @Test
    public void binarySearchV5() {
    }

    @Test
    public void binarySearchV6() {
    }
}