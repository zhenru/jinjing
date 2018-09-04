package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;

import static org.muzhe.test.tsinghua.dsa2.sequence.Assert.assertTrue;

/**
 * @author muzhe-wang on  18-9-3 下午3:33.
 */
public class VectorTest {

    private Vector<Integer> vector = new Vector<>();

    @Test
    public void copyFrom() {
    }

    @Test
    public void expand() {
    }

    @Test
    public void shrink() {

        Vector<Integer> vector = generateVector(100);
        while (vector.size() > 0) {
            vector.remove(vector.size() - 1);
        }

    }

    @Test
    public void baseBubbleSort() {

        Vector<Integer> vector = generateRandomVector(20);
        System.out.println(vector);
        vector.baseBubbleSort(0, vector.size());
        System.out.println(vector);
    }

    @Test
    public void bubbleSort() {
        Vector<Integer> vector = generateRandomVector(20);
        System.out.println(vector);
        vector.bubbleSort(0, vector.size());
        System.out.println(vector);
    }

    @Test
    public void fastBubbleSort() {

        Vector<Integer> vector = generateRandomVector(20);
        System.out.println(vector);
        vector.fastBubbleSort(0, vector.size());
        System.out.println(vector);
        System.out.println(vector.isAsc(0, vector.size()));

    }

    @Test
    public void fastBubbleSortWithSortedVector() {

        Vector<Integer> vector = generateVector(20);
        System.out.println(vector);
        vector.fastBubbleSort(0, vector.size());
        System.out.println(vector);
    }

    @Test
    public void max() {
        Vector<Integer> vector = generateRandomVector(200);
        int max = vector.max();
        System.out.println(vector);
        System.out.println(vector.get(max));
    }

    @Test
    public void get() {

        Vector<Integer> vector = generateVector(10);
        System.out.println(vector);
        System.out.println(vector.get(2));
        System.out.println(vector.get(7));

    }


    @Test
    public void selectSort() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void mergeSort() {
        Vector<Integer> vector = generateRandomVector(1024);
        System.out.println(vector);
        vector.mergeSort(0, vector.size());
        System.out.println(vector);
        System.out.println(vector.isAsc(0, vector.size()));

    }

    @Test
    public void binarySearchV1() {

        Vector<Integer> vector = generateRandomVector(2048);
        System.out.println(vector);
        vector.mergeSort(0, vector.size());
        System.out.println(vector);
        int i = vector.binarySearchV1(37, 0, vector.size());
        System.out.println(i);
    }

    @Test
    public void binarySearchV2() {

        Vector<Integer> vector = generateRandomVector(10);
        System.out.println(vector);
        vector.mergeSort(0, vector.size());
        System.out.println(vector);
        int i = vector.binarySearchV2(20, 0, vector.size());

        System.out.println(i);
    }

    @Test
    public void testMerge(){


    }

    @Test
    public void partition() {
    }

    @Test
    public void quickSort() {
    }

    @Test
    public void heapSort() {
    }

    @Test
    public void size() {
        Vector<Integer> vector = generateVector(102);
        System.out.println(vector.size());

    }

    @Test
    public void empty() {
        boolean isEmpty = vector.empty();
        System.out.println(isEmpty);
    }

    @Test
    public void disOrdered() {
    }

    @Test
    public void find() {

        Vector<Integer> vector = generateVector();
        System.out.println(vector);
        int i = vector.find(-1);
        System.out.println(i);
    }


    @Test
    public void find1() {
        Vector<Integer> vector = generateVector();
        System.out.println(vector);
        int i = vector.find(12, 24, 112);
        System.out.println(i);
    }

    @Test
    public void search() {
    }

    @Test
    public void search1() {
    }

    @Test
    public void remove() {
        Vector<Integer> vector = generateVector(10);
        System.out.println(vector);
        Integer removeValue = vector.remove(2);
        System.out.println(removeValue);
        System.out.println(vector);


    }

    @Test
    public void remove1() {

        Vector<Integer> vector = generateVector(10);
        System.out.println(vector);
        int removeNum = vector.remove(2, 9);
        System.out.println(removeNum);
        System.out.println(vector);
        System.out.println(vector.size());
    }

    @Test
    public void insert() {
        int insert = vector.insert(12);
        int insertResult1 = vector.insert(12);
        int insertResult2 = vector.insert(12);
        System.out.println(insertResult2);
    }

    @Test
    public void insert1() {

        int insert = vector.insert(0, 12);
        int insert1 = vector.insert(12);
        System.out.println(insert1);

    }

    @Test
    public void sort() {
    }

    @Test
    public void sort1() {
    }

    @Test
    public void unSort() {
    }

    @Test
    public void unSort1() {
    }

    @Test
    public void deduplicate() {

        Vector<Integer> vector = generateDuplicateIntegerVector(20);
        System.out.println(vector);
        System.out.println("init size = " + vector.size());
        int deduplicate = vector.deduplicate();
        System.out.println("duplicate count = " + deduplicate);
        System.out.println(vector);
        System.out.println("after size = " + vector.size());

    }

    @Test
    public void deduplicateV2() {

        Vector<Integer> vector2 = generateDuplicateIntegerVector(200);
        System.out.println(vector2);
        System.out.println("init size = " + vector2.size());
        int deduplicate = vector2.deduplicateV2();
        System.out.println("duplicate count = " + deduplicate);
        System.out.println(vector2);
        System.out.println("after size = " + vector2.size());

        System.out.println(" =============================V0========================================");


        Vector<Integer> vector = generateDuplicateIntegerVector(200);
        System.out.println(vector);
        System.out.println("init size = " + vector.size());
        int deduplicate2 = vector.deduplicate();
        System.out.println("duplicate count = " + deduplicate2);
        System.out.println(vector);
        System.out.println("after size = " + vector.size());
    }


    @Test
    public void uniquify() {
    }

    private Vector<Integer> generateVector() {

        return generateVector(200);

    }

    private Vector<Integer> generateVector(int size) {

        assertTrue(size > 0, () -> "参数不合法");
        Vector<Integer> integerVector = new Vector<>();
        for (int i = 0; i < size; i++) {
            integerVector.insert(2 * i);
        }
        return integerVector;

    }

    /**
     * 生成重复元素的数组
     *
     * @param count
     * @return
     */
    private Vector<Integer> generateDuplicateIntegerVector(int count) {

        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < count; i++) {
            vector.insert(i);
            vector.insert(i + 1);
        }
        return vector;

    }

    /**
     * 生成乱序的向量
     *
     * @param count
     * @return
     */
    private Vector<Integer> generateRandomVector(int count) {

        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                vector.insert(i * 5 + 1);
            } else if (i % 2 == 0) {
                vector.insert(i * 3 + 7);
            } else if (i % 5 == 0) {
                vector.insert(i * 2 + 1);
            } else {
                vector.insert(i);
            }
        }
        return vector;
    }

}