package org.muzhe.test.tsinghua.dsa2.sequence;

import com.sun.org.glassfish.gmbal.ManagedObject;
import lombok.ToString;

import static org.muzhe.test.tsinghua.dsa2.sequence.Assert.assertTrue;

/**
 * 向量
 *
 * @author muzhe-wang on  18-9-3 下午2:46.
 */
public class Vector<T extends Comparable<T>> implements Sequence<T> {

    private static int DEFAULT_CAPACITY = 10;

    /**
     * 向量长度
     */
    private int size;

    /**
     * 存放元素元素的数组
     */
    private Object[] elements;

    /**
     * 容量
     */
    private int capacity;

    /**
     * @param c
     */
    public Vector(int c) {
        assertTrue(c > 0, () -> "c不能小于０");
        this.elements = new Object[c];
        this.size = 0;
        this.capacity = c;
    }

    public Vector() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public Vector(Vector vector) {
        copyFrom(vector, 0, vector.size);
        this.capacity = vector.capacity;
        this.size = vector.size;
    }

    /**
     * 使用copy的方式来初始化系统
     *
     * @param vector
     * @param low
     * @param high
     */
    public Vector(Vector vector, int low, int high) {

        this.elements = new Object[(high - low) * 2];
        copyFrom(vector, low, high);

    }

    /**
     * 将　[low,high)中的元素copy到当前的元素中
     *
     * @param vector
     * @param low
     * @param high
     */
    public void copyFrom(Vector vector, int low, int high) {
        assertTrue(vector != null && low >= 0 && high < vector.size, () -> "非法参数");

        while (low < high) {
            this.elements[size++] = vector.elements[low++];
        }
    }

    @Override
    public void expand() {

        //向量空间不足的时候需要对数组进行扩容
        //这个是在插入每一元素的时候需要对当前的数组进行扩容
        if (this.size < this.capacity) {
            return;
        }

        //不低于默认元素，主要是开始的时候可能会创建出比默认元素小的数组
        if (this.capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }

        Object[] oldElements = this.elements;
        this.elements = new Object[this.capacity <<= 1];
        for (int i = 0; i < size; i++) {
            this.elements[i] = oldElements[i];
        }
        oldElements = null;
    }

    /**
     * 对当前元素进行缩容
     */
    @Override
    public void shrink() {

        if (this.size < DEFAULT_CAPACITY << 1) {
            //如果容量小于默认大小的两倍，不需要缩小
            return;
        }
        if (this.size << 2 > this.capacity) {
            //如果size超过了容量的　25％　,比修阿婆缩容
            return;
        }
        //这个时候缩小容量为原来的半
        Object[] oldElements = this.elements;
        this.elements = new Object[this.capacity >>= 1];
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = oldElements[i];
        }
        oldElements = null;
    }

    @Override
    public T get(int r) {

        assertTrue(r >= 0 && r < this.size, () -> "非法参数");
        return (T) this.elements[r];

    }

    @Override
    public void baseBubble(int low, int high) {

        checkSection(low, high);
        while (low < high - 1) {
            if (((T) this.elements[low]).compareTo((T) this.elements[low + 1]) > 0) {
                swap(low, low + 1);
            }
            low++;
        }

    }

    /**
     * 通过一次交换，将[low,high)中最大的元素写到high-1的位置上
     *
     * @param low
     * @param high
     * @return
     */
    @Override
    public boolean bubble(int low, int high) {

        checkSection(low, high);
        boolean isSort = true;
        while (low < high - 1) {
            if (((T) this.elements[low]).compareTo((T) this.elements[low + 1]) > 0) {
                isSort = false;
                swap(low, low + 1);
            }
            low++;
        }

        return isSort;
    }

    /**
     * bubble中每一次交换都是解决逆序，如果没有交换，就没有逆序。证明后面的都是有序的。
     * 那么最后一次交换的后面一个位置[low+1,high)都是有序的。这个时候我们可以做的是交换当亲啊的元素
     *
     * @param low
     * @param high
     * @return
     */
    @Override
    public int bubbleFast(int low, int high) {

        checkSection(low, high);
        int startSorted = low;
        while (low < high - 1) {
            if (((T) this.elements[low]).compareTo((T) this.elements[low + 1]) > 0) {
                swap(low, low + 1);
                startSorted = low + 1;
            }
            low++;
        }
        return startSorted;
    }

    @Override
    public void bubbleSort(int low, int high) {
        checkSection(low, high);
        while (!bubble(low, high--)) {
        }
    }

    @Override
    public void baseBubbleSort(int low, int high) {
        checkSection(low, high);
        while (low < high) {
            baseBubble(low, high--);
        }
    }

    @Override
    public void fastBubbleSort(int low, int high) {

        checkSection(low, high);
        while (low < bubbleFast(low, high--)) {
        }
    }

    @Override
    public int max() {

        return max(0, this.size);
    }

    @Override
    public int max(int low, int high) {

        //找出向量中最大元素的位置
        checkSection(low, high);
        int maxRank = low;
        while (++low < high) {
            if (((T) this.elements[maxRank]).compareTo((T) this.elements[low]) < 0) {
                maxRank = low;
            }
        }
        return maxRank;
    }

    @Override
    public void selectSort(int low, int high) {

    }

    /**
     * 将当前数组中有有序的[low,mid)和[mid,high)进行合并
     * 这里需要额外的一半空间来存放前半部分的数据
     *
     * @param low
     * @param mid
     * @param high
     */
    @Override
    public void merge(int low, int mid, int high) {
        assertTrue(0 <= low && low <= mid && mid <= high && high <= this.size, () -> "非法参数");

        Object[] leftElements = new Object[mid - low];
        for (int i = 0, j = low; j < mid; j++) {
            leftElements[i++] = this.elements[j];
        }

        //如果a和b两个数组中都有元素，这个循环都需要走下去
        for (int la = 0, lb = mid, lc = low; la < leftElements.length || lb < high; ) {
            //将a数组中的元素写到c中去。
            //a不为空，ｂ为空。 或者ａ，ｂ都不为空，a的元素小于b的元素。

            if ((la< leftElements.length)&&((lb<high &&((T) leftElements[la]).compareTo((T) this.elements[lb]) < 0))||!(lb< high)) {
                this.elements[lc++] = leftElements[la++];
            }
            //将b数组中的元素写到c中去
            //a为空b不为空。或者　a,b都不为空，a的元素不小于b的元素。
            if (lb < high &&(la < leftElements.length &&  !(((T) leftElements[la]).compareTo((T) this.elements[lb]) < 0)) || (la >= leftElements.length)) {
                this.elements[lc++] = this.elements[lb++];
            }
        }
        leftElements = null;

    }

    @Override
    public void mergeSort(int low, int high) {

        //如果元素个数只有一个则这个数组是有序的。
        if (high - low < 2) {
            return;
        }
        //选择中点将数组一分为二
        int mid = (high + low) / 2;
        //对左边进行排序
        mergeSort(low, mid);
        //对右边进行merge排序
        mergeSort(mid, high);
        //将两边排好序的数组进行merge起来
        merge(low, mid, high);

    }

    @Override
    public int partition(int low, int high) {
        return 0;
    }

    @Override
    public void quickSort(int low, int high) {

    }

    @Override
    public void heapSort(int low, int high) {

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean empty() {
        return this.size <= 0;
    }

    @Override
    public int disOrdered() {
        return 0;
    }

    @Override
    public int find(T ele) {
        return find(ele, 0, size);
    }

    @Override
    public int find(T ele, int low, int high) {
        checkSection(low, high);
        //从最后开始比较。这里的一个在第一个逻辑表达式里使用了high--来移动元素这里使用的挺巧妙的。
        //我一般习惯性的从low->high进行比较，这个过程不太方便处理，如果元素不存在返回　low-1的位置
        while (low < high-- && this.elements[high] != ele) {
        }
        return high;
    }

    @Override
    public int search(T ele) {
        return 0;
    }

    @Override
    public int search(T ele, int low, int high) {
        return 0;
    }

    /**
     * 删除第r的元素，表示删除[r,r+1)的元素
     *
     * @param r
     * @return
     */
    @Override
    public T remove(int r) {
        assertTrue(r >= 0 && r < this.size, () -> "元素非法");
        T returnValue = (T) this.elements[r];
        remove(r, r + 1);
        return returnValue;
    }

    /**
     * 删除[low,high)区间的元素，主要是把 [0,size) ->[0,low)+[high,size) 的元素
     *
     * @param low
     * @param high
     * @return
     */
    @Override
    public int remove(int low, int high) {
        checkSection(low, high);
        this.size = this.size + low - high;
        for (int i = high; i < size; i++) {
            this.elements[low++] = this.elements[i];
        }
        shrink();
        return (high - low);
    }


    /**
     * 将ele元素写到[0,size)元素的第r个元素的位置上去
     *
     * @param r
     * @param ele
     * @return
     */
    @Override
    public int insert(int r, T ele) {
        assertTrue(r <= size, () -> "参数非法");
        //1.扩容
        expand();
        //2.移动数据，腾位置
        for (int i = size; i > r; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[r] = ele;
        this.size++;
        return r;
    }

    /**
     * 默认将元素插入到当前元素的最后的地方
     *
     * @param ele
     * @return
     */
    @Override
    public int insert(T ele) {
        return insert(this.size, ele);
    }

    @Override
    public void sort(int low, int high) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void unSort() {

    }

    @Override
    public void unSort(int low, int high) {

    }

    /**
     * 将一个无序向量中相同的元素给去掉。
     * 不排序。这种时间消耗是　n^2
     * <p>
     * 从后向前进行去重
     *
     * @return
     */
    @Override
    public int deduplicate() {
        //从[0,size)开始依次判断元素是否在之前的位置上出现过。

        if (size <= 1) {
            return 0;
        }
        int i = 1;

        int iniSize = this.size;
        //从[1,size)每个元素和前面的元素序列里查找，如果不存在。就ｉ++,否则就使用当前元素继续执行。
        //这里查找是从元素的high开始查找，依次向低方向查找，直到返回最低的元素。

        while (i < size) {
            if ((find((T) this.elements[i], 0, i) < 0)) {
                i++;
            } else {
                remove(i);
            }
        }
        return iniSize - this.size;
    }

    /**
     * 以从第一个元素开始，依次和后面的元素进行比较，如果后面有和这个元素相同的，就删除后面的元素。
     * 这种实现方式是以第０个元素依次和后面的元素进行匹配
     * 从前向后去重
     *
     * @return
     */
    public int deduplicateV2() {

        int oldSize = this.size;
        int i = -1;
        //因为最后一个元素一定是　不重复的，所以最后一个元素不用和后面的进行比较
        while (++i < this.size - 1) {

            int j = i + 1;
            while (j < size) {
                if (this.elements[i] == this.elements[j]) {
                    remove(j);
                } else {
                    j++;
                }
            }
        }
        return oldSize - this.size;
    }

    @Override
    public int uniquify() {
        return 0;
    }

    /**
     * 判断当前序列是否升序
     *
     * @return
     */
    @Override
    public boolean isAsc(int low, int high) {

        while (low < high - 1) {
            if (((T) this.elements[low]).compareTo((T) this.elements[low + 1]) > 0) {
                return false;
            }
            low++;
        }

        return true;
    }

    /**
     * 判断当前向量是否降序
     *
     * @return
     */
    @Override
    public boolean isDesc(int low, int high) {

        while (low < high - 1) {
            if (((T) this.elements[low]).compareTo((T) this.elements[low + 1]) < 0) {
                return false;
            }
            low++;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]).append(" ");
        }
        return sb.toString();
    }


    private void checkSection(int low, int high) {
        assertTrue(low >= 0 && low < high && high <= size, () -> "参数不合法");
    }


    /**
     * 交换　firstRank和secondRank上的数值
     *
     * @param firstRank  第一个数的rank
     * @param secondRank 第二个数的rank
     */
    private void swap(int firstRank, int secondRank) {

        Object temp = this.elements[firstRank];
        this.elements[firstRank] = this.elements[secondRank];
        this.elements[secondRank] = temp;

    }


}
