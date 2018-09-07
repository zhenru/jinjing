package org.muzhe.test.tsinghua.dsa2.sequence.list;

/**
 * @author muzhe-wang on  18-9-7 下午1:58.
 */
public class DefaultList<T> implements List<T> {

    /**
     * 头节点
     */
    private ListNode<T> head;

    /**
     * 尾节点
     */
    private ListNode<T> tail;

    /**
     * 节点数量
     */
    private int size;

    @Override
    public void init() {

        head = new ListNode<>();
        tail = new ListNode<>();
        this.size = 0;

        //将头节点和尾节点关联起来
        head.setPred(null);
        head.setSucc(tail);
        tail.setPred(head);
        tail.setSucc(null);

    }

    @Override
    public int clear() {
        if (size == 0) {
            return 0;
        }
        head.setSucc(tail);
        tail.setPred(head);
        return size;
    }

    @Override
    public void copyNodes(ListNode<T> node, int n) {

    }

    @Override
    public void merge(ListNode<T> first, int firstCount, ListNode<T> second, int secondCount) {

    }

    @Override
    public void mergeSort(ListNode<T> head, int n) {

    }

    @Override
    public void selectSort(ListNode<T> head, int n) {

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public ListNode<T> first() {

        return size > 0 ? head.getSucc() : null;

    }

    @Override
    public ListNode<T> last() {

        return size > 0 ? tail.getPred() : null;
    }

    @Override
    public boolean valid(ListNode<T> node) {
        return false;
    }

    @Override
    public int disordered() {
        return 0;
    }

    @Override
    public ListNode<T> find(T data) {
        for (ListNode node = head.getSucc(); node != tail; node = node.getSucc()) {
            if (data.equals(node.getData())) {
                return node;
            }
        }
        return null;
    }

    @Override
    public ListNode<T> find(T data, ListNode<T> p, int n) {

        for (int i = 0; i < n && p != tail; i++, p = p.getSucc()) {
            if (p.getData().equals(data)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public ListNode<T> search(T data) {
        return null;
    }

    @Override
    public ListNode<T> search(T data, int low, int high) {
        return null;
    }

    @Override
    public ListNode<T> selectMax(ListNode<T> data, int n) {
        return null;
    }

    @Override
    public ListNode<T> selectMax() {
        return null;
    }

    @Override
    public ListNode<T> insertAsFirst(T data) {
        size++;
        return head.insertAfter(data);
    }

    @Override
    public ListNode<T> insertAsLast(T data) {
        size++;
        return tail.insertBefore(data);
    }

    @Override
    public ListNode<T> insertAfter(ListNode<T> node, T data) {
        size++;
        return node.insertAfter(data);
    }

    @Override
    public ListNode<T> insertBefore(ListNode<T> node, T data) {
        size++;
        return node.insertBefore(data);
    }

    @Override
    public T remove(ListNode<T> node) {

        T data = node.getData();
        ListNode<T> pre = node.getPred();
        ListNode<T> succ = node.getSucc();
        pre.setSucc(succ);
        succ.setPred(pre);
        this.size--;
        node = null;
        return data;
    }

    @Override
    public void merge(List<T> list) {

    }

    @Override
    public void sort(ListNode<T> node, int n) {

    }

    @Override
    public void sort() {

    }

    @Override
    public int duplicate() {

        //无序list中删除相同的元素。
        //从第一个元素开始和后面的元素依次进行比较，如果相同，就删除后面相同的那个元素。
        int oldSize = this.size;
        for (ListNode<T> p = head.getSucc(); p != tail; p = p.getSucc()) {
            for (ListNode<T> q = p; q.getSucc() != tail; q = q.getSucc()) {
                if (q.getSucc().getData().equals(p.getData())) {
                    remove(q.getSucc());
                }
            }
        }
        //todo 这里有问题需要重新实现一下 muzhe
        return oldSize - size;

    }

    @Override
    public int uniquify() {
        return 0;
    }

    @Override
    public void reverse() {

    }

    @Override
    public void traverse() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode node = head.getSucc(); node != tail; node = node.getSucc()) {
            sb.append(node.getData()).append("  ");
        }
        return sb.toString();
    }
}
