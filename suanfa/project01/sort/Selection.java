package sort;

/**
 * 选择排序
 *
 * @Author zhourui
 * @Date 2020/8/8 15:06
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            // 定义一个变量记录最小元素所在的索引，默认为参与排序的第一个元素所在位置
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                // 需要比较最小索引minIndex处的值和j索引处的值
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }

            // 交换最小元素索引索引minIndex处的值和索引i处的值
            exch(a, i, minIndex);
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
