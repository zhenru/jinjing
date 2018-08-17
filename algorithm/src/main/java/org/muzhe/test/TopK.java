package org.muzhe.test;

/**
 * @author muzhe-wang on  18-7-11 下午3:31.
 */
public class TopK {

    /**
     * 找出array中第k大的数值;
     * 这里假设　array的长度比　k大。
     *
     * @param array
     * @param k
     * @return
     */
    int topK(int[] array, int k) {

        int begin = 0;
        int end = array.length-1;

        int partition;
        do {
            partition = partition(array, begin, end);
            if (partition == k) {
                return array[k];
            } else if (partition > k) {
                end = partition - 1;
            } else {
                begin = partition + 1;
            }
        } while (partition != k);

        return array[k];

    }

    private int partition(int[] array, int begin, int end) {

        int sentinel = array[end];
        int lowIndex = begin - 1;
        for (int i = begin; i < end; i++) {
            if (array[i] <= sentinel) {
                lowIndex++;
                swap(array, lowIndex, i);
            }
        }
        swap(array, lowIndex + 1, end);
        return lowIndex + 1;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
