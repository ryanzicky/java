package com.example.suanfa.sort;

/**
 * @Author zhourui
 * @Date 2019/12/11 19:26
 */
public class InsertSort {

    public static void main(String[] args){
//        int[] arr = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long l = System.currentTimeMillis();
        insertSort(arr);
        System.out.println("耗时 = " + (System.currentTimeMillis() - l) + "ms");
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1; // arr[i]前面数的下标

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; // arr[insertIndex]
                insertIndex--;
            }
            // 判断是否需要重新赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
//            arr[insertIndex + 1] = insertVal;

//            System.out.println("第" + i + "轮插入");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
