package sort;

/**
 * @Author zhourui
 * @Date 2020/8/14 9:27
 */
public class Quick {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 安全性校验
        if (hi <= lo) {
            return;
        }

        // 需要对数组中lo索引到hi索引处的元素进行分组(左子组和右子组)
        int partition = partition(a, lo, hi); // 分界值所在的索引(分界值位置变化后的索引)

        // 左子组有序
        sort(a, lo, partition - 1);

        // 右子组有序
        sort(a, partition + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        // 确定分界值
        Comparable key = a[lo];
        // 定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi + 1;

        // 切分
        while (true) {
            // 先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            // 再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            // 判断 left>=right，如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }

        // 交换分界值
        exch(a, lo, right);

        return right;
    }
}
