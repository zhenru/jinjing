package org.muzhe.test.tsinghua.dsa2.sequence;

import org.junit.Test;

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
    }

    @Test
    public void bubble() {
    }

    @Test
    public void bubbleSort() {
    }

    @Test
    public void max() {
    }

    @Test
    public void selectSort() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void mergeSort() {
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
    }

    @Test
    public void empty() {
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
    }

    @Test
    public void remove1() {
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
    }

    @Test
    public void uniquify() {
    }

    private Vector<Integer> generateVector() {

        Vector<Integer> integerVector = new Vector<>();
        for (int i = 0; i < 200; i++) {
            integerVector.insert(2 * i);
        }
        return integerVector;
    }

}