package org.muzhe.test.tsinghua.dsa2.sequence;

/**
 * @author muzhe-wang on  18-9-5 下午2:08.
 */
public class Search {

    /**
     * 从　elements中　[low,high)区间中查找　最后一个　小于　ele 的元素的位置。
     *
     * @param elements
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV1(int[] elements, int low, int high, int ele) {

        /**
         * 在结束的时候　low = high
         */
        while (low < high) {

            int mid = (low + high) >> 1;

            if (ele <= elements[mid]) {
                //mid向左边定位。在最终结束的时候
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return --low;

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

        //需要将对应的元素向左边移动

        while (low < high) {
            int mid = (low + high) >> 1;

            if (ele <= elements[mid]) {
                //　<--
                high = mid;
            } else {
                //-->
                low = mid + 1;
            }
        }

        return low;
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

        //最后一个小于等于ele的元素下标，将元素不断的往右边移动，知道最后一个位置上不大于ele的位置
        while (low < high) {
            int mid = (low + high) >> 1;
            if (ele < elements[mid]) {
                //元素往左边
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return --low;
    }

    /**
     * @param elements 使用二分查找算法在有序数组　elements　的　[low,high) 区间查找　第一个大于　ele的元素
     * @param low
     * @param high
     * @param ele
     * @return
     */
    public int binarySearchV4(int[] elements, int low, int high, int ele) {

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

        //找出第一个大于等于ele的元素的位置，然后返回是否相等，如果相等就返回，否则就返回-1
        while (low < high) {
            int mid = (low + high) >> 1;

            if (ele <= elements[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low >= elements.length ? -1 : ele == elements[low] ? low : -1;
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

        while (low < high) {
            int mid = (low + high) >> 1;

            if (ele < elements[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        --low;
        return low >= elements.length ? -1 : ele == elements[low] ? low : -1;
    }
}
