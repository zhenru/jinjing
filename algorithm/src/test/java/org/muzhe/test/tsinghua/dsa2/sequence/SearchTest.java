package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-9-5 下午2:33.
 */
public class SearchTest {

    private Search search = new Search();

    private int[] elements = {0, 1, 2, 2, 2, 5, 6};


    @Test
    public void binarySearchV1() {

        int i = search.binarySearchV1(elements, 0, elements.length, 54);
        System.out.println(i);

        int i1 = search.binarySearchV1(elements, 0, elements.length, 2);
        System.out.println(i1);

    }

    @Test
    public void binarySearchV2() {

        int i = search.binarySearchV2(elements, 0, elements.length, 54);
        System.out.println(i);

        int i1 = search.binarySearchV2(elements, 0, elements.length, 2);
        System.out.println(i1);

        int i2 = search.binarySearchV2(elements, 0 , elements.length , 3);
        System.out.println(i2);

    }

    @Test
    public void binarySearchV3() {

        int i = search.binarySearchV3(elements, 0, elements.length, 2);
        System.out.println(i);

        int i2 = search.binarySearchV3(elements, 0 ,elements.length , 3);
        System.out.println(i2);

        int i3 = search.binarySearchV3(elements, 0, elements.length, 63);
        System.out.println(i3);

    }

    @Test
    public void binarySearchV4() {

        int i = search.binarySearchV4(elements, 0, elements.length, 2);
        System.out.println(i);

        int i1 = search.binarySearchV4(elements, 0, elements.length, 3);
        System.out.println(i1);

        int i2 = search.binarySearchV4(elements, 0, elements.length, 63);
        System.out.println(i2);

    }

    @Test
    public void binarySearchV5() {

        int i = search.binarySearchV5(elements, 0, elements.length, 2);
        System.out.println(i);

        int i1 = search.binarySearchV5(elements, 0, elements.length, 3);
        System.out.println(i1);

        int i2 = search.binarySearchV5(elements, 0, elements.length, 43);
        System.out.println(i2);

    }

    @Test
    public void binarySearchV6() {

        int i = search.binarySearchV6(elements , 0, elements.length , 2);
        System.out.println(i);

        int i1 = search.binarySearchV6(elements, 0, elements.length, 3);
        System.out.println(i1);

        int i2 = search.binarySearchV6(elements, 0, elements.length, 43);
        System.out.println(i2);

        int i3 = search.binarySearchV6(elements, 0, elements.length, 5);
        System.out.println(i3);
    }
}