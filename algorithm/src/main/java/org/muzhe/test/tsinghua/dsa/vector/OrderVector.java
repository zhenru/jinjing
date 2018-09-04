package org.muzhe.test.tsinghua.dsa.vector;

/**
 * 有序向量
 *
 * @author muzhe-wang on 18/8/21.
 */
public class OrderVector<T extends Comparable> implements Vector<T> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 存储数据的容器
     */
    private Object[] elements;

    /**
     * 当前向量的容量
     */
    private int capacity;

    /**
     * 当前容器中数据个数
     */
    private int size = 0;

    public OrderVector() {
        elements = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;

    }

    public OrderVector(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("数组的长度不能小于0");
        }
        elements = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public OrderVector(OrderVector orderVector) {
        copyFrom(orderVector.elements, 0, orderVector.size);
    }

    public OrderVector(OrderVector orderVector, int start, int end) {
        copyFrom(orderVector.elements, start, end);
    }

    public int size() {
        return this.size;
    }

    public T get(int r) {

        checkRank(r);
        return (T) elements[r];

    }

    /**
     * 将第r个位置上的值设置为value
     *
     * @param r
     * @param value
     */
    public void put(int r, T value) {

        checkRank(r);
        this.elements[r] = value;
    }


    public void insert(int r, T value) {

        //校验rank
        checkRank(r);
        //判断是否需要扩容
        expand();
        //将r到最后的元素依次往后移动一个位置.边界上 第r的元素被移动到了r+1
        for (int i = this.size; i > r; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[r] = value;
        //当前容器中元素数量+1
        size++;
    }

    private void checkRank(int r) {
        if (r < 0 || r > this.size) {
            throw new RuntimeException("当前元素的位置非法");
        }
    }

    /**
     * 删除第r个元素，可以特殊区间删除 remove(r ,r+1);
     *
     * @param r
     * @return
     */
    public T remove(int r) {
        checkRank(r);
        Object returnObj = this.elements[r];
        remove(r, r + 1);
        return (T) returnObj;
    }

    /**
     * 删除当前[low,high) 区间的元素
     *
     * @param low  左区间
     * @param high 右区间
     * @return
     */
    public int remove(int low, int high) {

        if (low < 0 || low > high || high >= size) {
            throw new RuntimeException("rank不合法");
        }

        //如果相等，单独处理。
        if (low == high) {
            return 0;
        }
        //移动当前元素的位置，只要将 [high,size)之间的元素移动到[low , low+size-high)后面就好
        while (high < size) {
            this.elements[low++] = this.elements[high++];
        }
        //对当前空间进行缩容
        shrunk();
        this.size = low;
        return high - low;

    }


    public boolean disordered() {
        return false;
    }

    public void sort() {

    }

    public int find(T t) {
        return 0;
    }

    public int find(T t, int low, int high) {

        if (low < 0 || low > high || high >= size) {
            throw new RuntimeException("秩的位置不合法");
        }

        while ((low <= high) && (!t.equals(this.elements[high--]))) {

        }
        return high;
    }

    public int search(T t) {
        return 0;
    }

    public int deDuplicate() {

        //记录原来的向量的长度
        int oldSize = this.size;
        //秩从第一个开始，原因是之前的元素一定是单调唯一的。
        int i = 1;
        //从第i个元素开始
        while (i < this.size) {
            //找出在i之前的区间中，当前第i的元素是否存在，如果存在就删除，如果不存在就去看下一个。
            if (find((T) elements[i], 0, i - 1) < 0) {
                i++;
            } else {
                remove(i);
            }
        }

        return oldSize - size;
    }

    /**
     * 将有序数组中相同的元素给去掉。
     */
    public int uniquify() {

        int i = 0, j = 0;

        //j负责遍历当前元素
        while (++j < this.size) {
            if (elements[i] != elements[j]) {
                elements[++i] = elements[j];
            }
        }
        //i指向了当前元素的位置。所以在设置size的时候需要移动到下一个元素的位置
        this.size = ++i;
        shrunk();
        //这个时候i和j指向了新旧两个size的位置，这两个就是当前的差值就是数组中相同的元素个数
        return j - i;
    }

    @Override
    public void traverse(Function<T> function) {

    }

    @Override
    public void add(T value) {
        expand();
        this.elements[size++] = value;
    }

    /**
     * 在区间 [low,high)的有序区间中查找 t的元素，如果查找失败就返回-1
     * 升序
     *
     * @param t
     * @param low
     * @param high
     * @return
     */
    public int binSearch(T t, int low, int high) {


        //由于区间是 做闭右开的，所以这里用小于号，因为最后都不会被访问到
        while (low < high) {

            //通过 这个二分 将当前数组 分为两个小数组。
            int middle = (low + high) >> 1;

            //element[middle] 比 t 小
            if (((T) this.elements[middle]).compareTo(t) < 0) {
                //为什么这里用mid会出现死循环
                low = middle + 1;
            } else if (((T) this.elements[middle]).compareTo(t) > 0) {
                high = middle;
            } else {
                return middle;
            }
        }

        return -1;
    }


    /**
     * todo 在快排中，选择哪一个中间点的性能最优  在二分的时候选择不同的点 比较的次数是不同的。
     * 斐波那契查找，主要解决普通二分查找中，左右两部分不相等的问题。
     *
     * @param t
     * @param low
     * @param high
     * @return
     */
    public int fibSearch(T t, int low, int high) {

        //todo fib 函数如何实现。这是一个问题。
        return -1;
    }


    /**
     * 使用二分查找 [low , high) 其中的区间是左闭右开的
     * 使用mid将当前的位置分为两部分，左面为 [low , mind) 右边为[mid , high)
     * 一直查找，一直到 low和mid相等时候，这个时候low就是我们想要的结果了
     *
     * @param t    待查找的数
     * @param low  左区间
     * @param high 右区间。
     * @return t出现的位置，如果不存在就返回 -1
     */
    public int binSearch2(T t, int low, int high) {
        //在所有的查找中，high都是当前区间最后一个的下一位，low是当前位置的最低位。
        //当high和low之间的值差1的时候，这个时候就可以判断这个值是否是我们想要的哪个值了。 两个位置。
        while (high - low > 1) {
            //以中点为轴，不断向下深入，直到长度为1.
            int mid = (high + low) >> 1;
            if (t.compareTo(this.elements[mid]) < 0) {
                //小于，说明在左侧 [low, mid)
                high = mid;
            } else {
                //大于，说明在右侧。[mid, high)
                low = mid;
            }
        }
        //一直定位，最终只会有一个值的时候，这个时候就进行判断。
        return t.compareTo(this.elements[low]) == 0 ? low : -1;
    }

    /**
     * 从有序列表区间中，[low,high)查找元素 t。返回不大于t的最大元素的位置。
     * 就是如果有多个相同的t就返回最后一个t的位置，如果不存在，就返回最接近t的元素的位置。
     * <p>
     * [low , mid) [mid+1,high)
     *
     * @param t    待查找的元素
     * @param low
     * @param high
     * @return
     */
    public int binSearch3(T t, int low, int high) {
        //不变性  elements[0,low) < e < elements[high , n)
        while (low < high) { // low = high

            int mid = (low + high) >> 1;
            if (t.compareTo(this.elements[mid]) < 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        //在跳出循环的时候，处于的状态是 elements[low = high = mid] > t
        return --low;

    }

    /**
     * 对序列 [low, high)之间的元素进行排序
     *
     * @param low
     * @param high
     */
    public void sort(int low, int high) {
        int sortCheck = ((int) (Math.random() * 10)) % 5;

        switch (sortCheck) {
            case 5:
                bubbleSort(low, high);
                break;
            case 6:
                selectionSort(low, high);
                break;
            case 7:
                mergeSort(low, high);
                break;
            case 8:
                heapSort(low, high);
                break;
            default:
                quickSort(low, high);
                break;
        }

    }

    /**
     * 快速排序
     *
     * @param low
     * @param high
     */
    private void quickSort(int low, int high) {

    }

    /**
     * 堆排序
     *
     * @param low
     * @param high
     */
    private void heapSort(int low, int high) {

    }

    /**
     * 对　elements[low,high)进行归并排序
     *
     * @param low  当前元素的下限
     * @param high 元素的上限
     */
    public void mergeSort(int low, int high) {

        //由于我们使用的是elements[low,high),所以当　high比low大一个的时候就结束了。
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) >> 1;

        //对　[low, mid)进行合并排序
        mergeSort(low, mid);
        //对　[mid, high) 进行合并排序
        mergeSort(mid, high);
        //将　[low,mid) 和　[mid,high)　这两个局部有序的序列进行合并。
        merge(low, mid, high);

    }

    /**
     * 将　[low,mid) 和　[mid,high)这两个有序的序列进行合并。
     *
     * @param low
     * @param mid
     * @param high 合并排序
     */
    private void merge(int low, int mid, int high) {

        Object[] leftElements = new Object[mid - low];

        //将元素copy从　elements中copy到　leftElements中去，这个过程主要是给后面的merge挪位置
        for (int i = low, leftElementIndex = 0; i < mid; leftElements[leftElementIndex++] = this.elements[i++]) {
        }

        //left数组是左边的数组，right在elements上，从　mid开始。最终的结果放在low上。其中启动的条件是　左边数组有元素，右边的数组有元素。
        for (int leftIndex = 0, rightIndex = mid, elementsIndex = low; leftIndex < leftElements.length || rightIndex < high; ) {
            //左边的数组有元素，[右边的的数组没有元素 || 左边元素比右边元素小]　　就把左边的元素写到　elements中去。
            if (leftIndex < leftElements.length && ((rightIndex >= high) || ((T) this.elements[rightIndex]).compareTo(leftElements[leftIndex]) >= 0)) {
                this.elements[elementsIndex++] = leftElements[leftIndex++];
            }
            //右边的数组有元素，[左边的数没有元素||右边的元素比左边的小]　　　　　就把右边的元素写到　elements 中去。

            if (rightIndex < high && ((leftIndex >= leftElements.length) || ((T) this.elements[rightIndex]).compareTo(leftElements[leftIndex]) < 0)) {
                this.elements[elementsIndex++] = this.elements[rightIndex++];
            }
        }
    }

    /**
     * 选择排序
     *
     * @param low
     * @param high
     */
    private void selectionSort(int low, int high) {

    }


    /**
     * 对elements[low,high)中的元素进行排序、
     * 之前的优化能够很大程度上减少冒泡次数。
     * 但是如果前半部分无序，后半部有序的这种序列，我们是否可以减小对应的范围？
     * 对于后半部分有序，前面无序的情况，我们能否迅速的
     *
     * @param low
     * @param high
     */
    public void bubbleSortBase3(int low, int high) {
        //这里我来实现一下　最优秀的版本的冒泡排序

        while (low < (high = bubble3(low, high))) {
        }

    }

    /**
     * 对elements[low,high)进行一次冒泡，将其中最小的元素移动到high-1的位置上。
     *
     * @param low  elements的下限
     * @param high 区间的上限
     * @return 当前有序序列开始的位置
     */
    private int bubble3(int low, int high) {

        int firstOrderIndex = low;
        while (++low < high) {
            if (((T) this.elements[low - 1]).compareTo(this.elements[low]) > 0) {
                swap(low - 1, low);
                firstOrderIndex = low;
            }
        }
        return firstOrderIndex;
    }


    /**
     * 对elements 中的　[low,high)之间的元素进行排序
     * <p>
     * 这个是　冒泡排序的优化
     * <p>
     * 相对于基础bubble排序，将会有大量的无效的比较，即使当前数组中的元素已经有序了，依然进行后面的排序。这里我们可以进行优化有一下，
     * 使用一个状态位表示一下当前数组中是否已经有序
     * 通过一轮bubble以后，发现压根就没有需要冒泡(逆序)，这个时候就可以结束当前的运算了。
     * 这里可以做一个代码的优化
     * <p>
     * 这种算法比较好的优化，前面是有序的，后面是无序的这种情况。
     *
     * @param low
     * @param high
     */
    public void bubbleSortBase2(int low, int high) {
        while (!(bubble2(low, high--))) {
        }
    }

    /**
     * 对　elements[low,high)之间的元素进行一次bubble将最大的元素移动到high-1的位置。
     *
     * @param low  下限
     * @param high 　上限
     * @return 返回当前一次冒泡中是否有逆序
     */
    private boolean bubble2(int low, int high) {
        //一次bubble将所有的元素一次进行比较，将最大的那个元素移动到high下的那个位置上无。i表示移动的目标地址。
        //这里使用low+1表示会更好一些。使用标识的位置操作数据，走位
        boolean sorted = true;
        for (int i = low + 1; i < high; i++) {
            if (((T) this.elements[i - 1]).compareTo(this.elements[i]) > 0) {
                swap(i - 1, i);
                sorted = false;
            }
        }
        return sorted;
    }

    /**
     * 对elements[low,high)之间的元素进行冒泡排序
     *
     * @param low
     * @param high
     */
    public void bubbleSortBase(int low, int high) {
        int num = 0;

        //依次将最大的元素移动到high-1的位置上去。使用　i指向　high对象。
        for (int i = high; i > low; i--) {
            //从low开始到high结束，依次将交换逆序的两个元素。
            for (int j = low + 1; j < i; j++) {
                num++;
                if (((T) this.elements[j - 1]).compareTo(this.elements[j]) > 0) {
                    swap(j - 1, j);
                }
            }
        }

        System.out.println(num);
        //这个算法中会有大量的冗余，如果元素已经有序了，还需要进行比较。 这里将会比较满所有的比较 size(size+1) / 2 .
        // 将会得到当前元素的个数。
        // 这里可以使用一个状态来记录当前的冒泡的过程是否有序，如果已经有序了，就可以直接结束了。
//        这里可以做一个优化，使用一个状态位置来记录当前冒泡的过程中是否有序，如果已经有序了，这个过程就可以结束了。
    }

    /**
     * 将[low,high) 区间的元素移动到最后的位置。
     * 逐趟做扫描交换，将元素移动到最后的位置上去。
     * 冒泡排序 ，
     *
     * @param low
     * @param high
     */
    protected void bubbleSort(int low, int high) {

        while (!bubble(low, high--)) {

        }
    }

    /**
     * 将[low , high)序列中最大的元素移动到 high-1的位置上去。
     *
     * @param low  区间　low
     * @param high
     * @return
     */
    private boolean bubble(int low, int high) {

        if (low >= high) {


        }

        return false;
    }


    /**
     * 一般的二分使用mid来不短将当前的元素进行收敛，但是可以做一个假设，当前序列中元素是单调递增的，这样能够迅速的收敛。
     *
     * @param t
     * @param low
     * @param high
     * @return
     */
    public int binSearch4(T t, int low, int high) {
        return -1;
    }

    /**
     * 将 source中从start开始到end结束的元素复制到  当前数组中去
     * 在copy中设置了容量和数据的多少。
     *
     * @param source 源数组
     * @param start  开始位置
     * @param end    结束位置
     */
    private void copyFrom(Object[] source, int start, int end) {
        //两倍容量
        this.capacity = (end - start) * 2;
        //分配新空间
        this.elements = new Object[this.capacity];
        //空间清零
        this.size = 0;
        //copy新的数据容量
        while (start < end) {
            this.elements[size++] = source[start++];
        }
    }

    /**
     * 溢出的情况有两种，一种是上溢，一种是下溢出。主要表示当前容器中的元素寥寥无几。
     * 可以使用一个装载因子表示当前系统中元素的个数。
     * 对当前向量的空间进行扩容。
     * todo 为什么这里使用了加倍，这样有哪些好处。这里需要研究一下。是一定要加倍还是可以使用只要是按照倍数放大而不是加上固定大小的实现。
     */
    private void expand() {

        //如果容量没有满，无需扩容
        if (this.size < this.capacity) {
            return;
        }
        //扩容的大小必须比默认空间要大,可能会开始创建的时候，空间比默认空间要小的情况
        this.capacity = Math.max(this.capacity, DEFAULT_CAPACITY);
        //开始扩容，大小编程原来的两倍
        Object[] oldElements = this.elements;
        this.elements = new Object[this.capacity <<= 1];
        //开始copy原有的元素
        for (int i = 0; i < size; i++) {
            this.elements[i] = oldElements[i];
        }
        //释放旧的元素
        oldElements = null;
    }


    private void shrunk() {


    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]).append(" ");
        }
        return sb.toString();
    }


    /**
     * 交换当前数组中first和second两个位置上的元素
     *
     * @param first  第一个元素的位置
     * @param second 第二个元素的位置
     */
    private void swap(int first, int second) {

        Object temp = this.elements[first];
        this.elements[first] = this.elements[second];
        this.elements[second] = temp;
    }


}
