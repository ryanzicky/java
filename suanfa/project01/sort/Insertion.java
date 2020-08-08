package sort;

/**
 * @Author zhourui
 * @Date 2020/8/8 15:17
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                // 比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大，则交换数据，如果不打，那么就找到合适的位置了，退出循环即可
                if (greater(a[j-1], a[j])) {
                    exch(a, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 比较两位元素
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换位置
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
