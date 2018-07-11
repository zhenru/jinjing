package org.muzhe.test;

/**
 * 堆排序
 *
 * @author muzhe-wang on  18-7-11 下午4:31.
 */
public class HeapSort {

    /**
     * 对array进行排序
     *
     * @param array 数组序列
     */
    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }
       buildHeap(array);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustDown(array , 0 , i-1);
        }

    }

    /**
     * 建堆
     * @param array
     */
    private void buildHeap(int[] array) {

    }

    /**
     * 交换　数组array中i和j两个位置上的数
     *
     * @param array 数组
     * @param i     i
     * @param j     j
     */
    private void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    /**
     * 将数组array中start到end中的数据建堆
     * 建一个大根堆
     *
     * @param array 数组
     * @param end   堆结束的位置
     */
    private void generateHeap(int[] array, int end) {

        //找到最后一个非叶子节点
        int lastNoLeafNode = (end - 1) / 2;
        for (int i = lastNoLeafNode; i >= 0; i++) {
            adjustDown(array, i, end);
        }

    }

    /**
     * 将array数组中第 i为根节点的树构建为一个堆
     * @param array         数组
     * @param i             树根的位置
     * @param end           根的位置
     */
    private void adjustDown(int[] array, int i, int end) {

        int child = i;
        while (2*child+1 <= end){


        }

    }
}
