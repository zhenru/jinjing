package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;
import org.muzhe.test.tsinghua.dsa2.sequence.vector.Search;

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

        int i2 = search.binarySearchV2(elements, 0, elements.length, 3);
        System.out.println(i2);

    }

    @Test
    public void binarySearchV3() {

        int i = search.binarySearchV3(elements, 0, elements.length, 2);
        System.out.println(i);

        int i2 = search.binarySearchV3(elements, 0, elements.length, 3);
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

        int i = search.binarySearchV6(elements, 0, elements.length, 2);
        System.out.println(i);

        int i1 = search.binarySearchV6(elements, 0, elements.length, 3);
        System.out.println(i1);

        int i2 = search.binarySearchV6(elements, 0, elements.length, 43);
        System.out.println(i2);

        int i3 = search.binarySearchV6(elements, 0, elements.length, 5);
        System.out.println(i3);
    }

    private int[] unifiedSequence = {0,1,2,3,4,5,6,7,8};
    private int[] duplicateSequence ={0,1,2,2,2,5,6,7,8};

    @Test
    public void testBinarySearch1(){

        int i = binarySearch1(unifiedSequence, 0, unifiedSequence.length, 3);
        System.out.println(i);

        int i1 = binarySearch1(duplicateSequence, 0, duplicateSequence.length, 3);
        System.out.println(i1);

    }

    @Test
    public void testBinarySearch2(){

        int i = binarySearch2(unifiedSequence, 0, unifiedSequence.length, 3);
        System.out.println(i);

        int i1 = binarySearch2(duplicateSequence, 0, duplicateSequence.length, 3);
        System.out.println(i1);

    }


    /**
     * 使用左侧的数据
     * 返回左边的数据
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    private int binarySearch1(int[] elements, int low, int high, int ele) {

        while (low < high) {

            int mid = (low + high) >> 1;
            if (ele <= elements[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 使用右边的数据，返回右边lef指向比当前元素的大一个的位置
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearch2(int[] elements, int low, int high, int ele) {

        while (low < high) {
            int mid = (low + high) >> 1;
            if (ele < elements[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}