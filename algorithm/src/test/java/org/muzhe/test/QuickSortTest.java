package org.muzhe.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-7-11 下午3:12.
 */
public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @Test
    public void sort() {

        int[] array = {8, 2, 1, 9, 7, 4, 6, 5, 3};
        quickSort.sort(array, 0, array.length - 1);
        LUtil.print(array);
    }
}