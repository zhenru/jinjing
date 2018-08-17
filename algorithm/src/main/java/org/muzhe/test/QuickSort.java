package org.muzhe.test;

/**
 * @author muzhe-wang on  18-7-11 下午2:56.
 */
public class QuickSort implements Sort {

    /**
     * 快速排序
     *
     * @param array
     * @param start
     * @param end
     */
    public void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(array, start, end);
        sort(array, start, partition - 1);
        sort(array, partition + 1, end);

    }

    /**
     * 以array[end]为sentinel将数组分为两部分，然后返回sentinel最终的位置
     *
     * @param array 当前数组
     * @param start 开始位置
     * @param end   结束的位置
     * @return sentinel的位置
     */
    private int partition(int[] array, int start, int end) {

        int sentinel = array[end];//使用　sentinel将这个数组分为两个不同部分
        int lowStartIndex = start - 1; //这个是表示当前数组中比sentinel小的数所处的位置
        for (int j = start; j < end; j++) {//表示当前数组中的所有的数
            if (array[j] <= sentinel) { //如果当前这个数比哨兵小，那么就将这个数和一个已经检验过位置上的比这个数小的数交换位置
                lowStartIndex++;
                swap(array, j, lowStartIndex);
            }
        }
        swap(array, end, lowStartIndex + 1);
        return lowStartIndex + 1;

    }

    /**
     * 交换两个数
     * @param array
     * @param num1
     * @param num2
     */
    private void swap(int[] array, int num1, int num2) {

        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;

    }
}
