package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-9-6 下午3:35.
 */
public class SearchTemp2Test {

    private SearchTemp2 search = new SearchTemp2();

    int[] elements = {1,3,4,5,6,7,9,10,13};

    int[] elements2 ={1,3,3,3,6,7,9,10,13};

    int[] elements3 = {3,3,3,3,3,3,3,3};


    @Test
    public void binarySearchV1() {

        int i = search.binarySearchV1(elements, 22, 0, elements.length);
        System.out.println(i);

        int i2 = search.binarySearchV1(elements2, 23, 0, elements2.length);
        System.out.println(elements2[i2]);
    }

    @Test
    public void binarySearchV2() {
        int i = search.binarySearchV2(elements, -1, 0, elements.length);
        System.out.println(i);

        int i2 = search.binarySearchV2(elements2, -1, 0, elements2.length);
        System.out.println(i2);
    }

    @Test
    public void binarySearchV3(){

        int i = search.binarySearchV1(elements3 , 3 , 0 , elements3.length);
        assertEquals(i, 0);

        int i1 = search.binarySearchV2(elements3, 3, 0 ,elements3.length);
        assertEquals(i1 , elements3.length);
    }
}