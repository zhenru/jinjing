package org.muzhe.test.tsinghua.dsa2.sequence;

/**
 * @author muzhe-wang on  18-9-5 下午2:08.
 */
public class Search {

    /**
     * 从　elements中　[low,high)区间中查找　最后一个　小于　ele 的元素的位置。
     * <p>
     * 在这里　low表示最小的元素，high是比当前数组中最大的元素大一个。
     * 当到最后的时候，low = high。是low越界限了。所以应该返回的是low-1
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV1(int[] elements, int low, int high, int ele) {


        while (low < high) {

            int mid = (low + high) >> 1;
            if (ele <= elements[mid]) {
                //向左边逼近
                high = mid;
            } else {
                //向右边逼近
                low = mid + 1;
            }

        }

        System.out.println("low = " + low + " high = " + high);
        return -1;

    }

    /**
     * 使用二分查找算法在有序数组　elements 的[low,high)区间中查找　第一个 大于等于　ele的元素的下标
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV2(int[] elements, int low, int high, int ele) {

        return -1;
    }

    /**
     * 使用二分查找算法在有序数组　elements 的　[low,high)区间中查找　最后一个　小于等于　ele的元素的下标
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV3(int[] elements, int low, int high, int ele) {

        return -1;
    }

    /**
     * @param elements 使用二分查找算法在有序数组　elements　的　[low,high) 区间查找　第一个大于　ele的元素
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV4(int[] elements, int low, int high, int ele) {

        return -1;
    }

    /**
     * 使用二分查找算法在有序数组　elements　的　[low,high)区间查找　第一个与key相等的元素。
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV5(int[] elements, int low, int high, int ele) {

        return -1;
    }

    /**
     * 使用二分查找算法在有序数组　elements 的　[low,high)区间查找　最后一个和key相等的元素。
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV6(int[] elements, int low, int high, int ele) {

        return -1;
    }
}
