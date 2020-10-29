package algorithm.priority;

/**
 * @Author: zhourui
 * @Date: 2020-10-23 10:37
 **/
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        N = 0;

        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public int minIndex() {
        return pq[1];
    }

    public void insert(int i, T t) {
        if (contains(i)) {
            return;
        }

        N++;

        items[i] = t;
        pq[N] = i;
        qp[i] = N;

        swin(N);
    }

    public int delMin() {
        int minIndex = pq[1];

        exch(1, N);

        qp[pq[N]] = -1;
        pq[N] = -1;
        items[minIndex] = null;

        N--;
        sink(1);

        return minIndex;
    }

    // 删除索引i处关联的元素
    public void delete(int i) {
        // 找到i在qp中的索引
        int k = qp[i];
        // 交换oq中索引k处的值和索引N处的值
        exch(k, N);
        // 删除qp中的内容
        qp[pq[N]] = -1;
        // 删除pq中的内容
        pq[N] = -1;
        // 删除items中的内容
        items[k] = null;
        // 元素的个数-1
        N--;
        // 堆的调整
        sink(k);
        swin(k);
    }

    // 修改i索引处元素为t
    public void changeItem(int i, T t) {
        // 修改items数组中i位置的元素为t
        items[i] = t;
        // 找到i再pq中出现的位置
        int k = qp[i];
        // 堆调整
        sink(k);
        swin(k);
    }

    // 上浮算法，把索引k出的元素能再堆中处于一个正确的位置
    private void swin(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }

            k = k / 2;
        }
    }

    // 下浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        while (2 * k <= N) {
            int min;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }

            if (less(k, min)) {
                break;
            }

            exch(k, min);
            k = min;
        }
    }
}
