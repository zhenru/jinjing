package org.muzhe.test.tsinghua.dsa2.sequence;

/**
 * @author muzhe-wang on  18-9-6 下午3:31.
 */
public class SearchTemp2 {

    /**
     * 相同的在左边
     *
     * @param elements
     * @param ele
     * @param low
     * @param high
     * @return
     */
    public int binarySearchV1(int[] elements, int ele, int low, int high) {

        while (low < high) {

            int mid = (low + high) >> 1;
            if (ele <= elements[mid]) {
                //当　mid的值　大于等于　ele的时候，这个时候向左边移动。其中high指向mid.
                //mid元素　大于等于　ele.
                high = mid;
            } else {
                //ele > elements[mid]
                //当mid的值　小于　ele的时候，向右移动.
                //小于ele的元素的下一个。　　第一个大于等于　ele指向。
                low = mid + 1;
            }
        }
        //以上，最终结束的时候，是high = low.
        //如果　是if中结束的时候，可能会出现的情况是　：low指向的数据是第一个　>= ele
        //如果　是else中结束，可能出现的情况是:第一个大于ele的元素。这里可以用范例实现。

        return low;
    }

    /**
     * 相同的在右边
     *
     * @param elements
     * @param ele
     * @param low
     * @param high
     * @return
     */
    public int binarySearchV2(int[] elements, int ele, int low, int high) {

        while (low < high) {
            int mid = (low + high) >> 1;
            //如果ele比中点元素小，这个时候就向左边移动，
            if (ele < elements[mid]) {
                //mid元素比ele大
                high = mid;
            } else {
                //如果ele大于中点元素，这个时候就向右边移动，low一定移动到　ele.因为相等的时候　　low  = mid+1 的大于一个位置
                low = mid + 1;
                //第一个大于　ele　的位置
                //low大于等于的下一个。　　第一个比ele大的元素。
            }
        }

        //所以最后　low一定指向　比ele大一个的位置上第一个。无论是从if中转过去，还是从　ele中转过去的。最后的结果都是　大于ele的第一个元素。
        //额外的情况是　可能会越界。这里有一个约定，在当前元素中最小的一定是

        //第一个大于mid元素的位置。

        return low;

    }
}
