package algorithm.heap;

/**
 * @Author: zhourui
 * @Date: 2020-10-22 14:14
 **/
public class Heap<T extends Comparable<T>> {

    private T[] items;

    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        // 通过循环不断比较当前节点的值和父节点的值，如果发现父节点的值比当前节点的值小就交换位置
        while (k > 1) {
            // 比较当前节点和其父节点
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }

            k = k / 2;
        }
    }

    public T delMax() {
        T max = items[1];
        // 交换索引1处的元素和最大索引处的元素，让完全二叉树中最右侧的元素变为临时根节点
        exch(1, N);
        // 最大索引处的元素删除掉
        items[N] = null;
        // 元素个数-1
        N--;
        // 通过下沉调整堆，让堆重新有序
        sink(1);
        return max;
    }

    private void sink(int k) {
        // 通过循环不断的对比当前k节点和其左子节点2k以及右子节点的2k+1中较大值的元素大小，如果当前节点小，则需要交换位置
        while (2 * k <= N) {
            // 获取当前节点的子节点中的较大节点
            int max; // 记录较大节点所在的索引
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }

            // 比较当前节点和较大节点的值
            if (!less(k, max)) {
                break;
            }

            exch(k, max);

            k = max;
        }
    }
}
