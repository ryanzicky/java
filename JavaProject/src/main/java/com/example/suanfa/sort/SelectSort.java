package com.example.suanfa.sort;

/**
 * 选择排序
 *
 * @Author zhourui
 * @Date 2019/12/11 19:03
 */
public class SelectSort {

    public static void main(String[] args){
//        int[] arr = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        long l = System.currentTimeMillis();
        selectSort(arr);
        System.out.println("耗时 = " + (System.currentTimeMillis() - l) + "ms");
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // 使用逐步推导方式
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 最小值索引
            int min = arr[i]; // 第一轮最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j]; // 重置最小值
                    minIndex = j; // 重置minIndex索引
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第" + (i + 1) + "轮后");
//            System.out.println(Arrays.toString(arr));
        }
        /*// 第一轮
        int minIndex = 0; // 最小值索引
        int min = arr[0]; // 第一轮最小值
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i]; // 重置最小值
                minIndex = i; // 重置minIndex索引
            }
        }

        arr[minIndex] = arr[0];
        arr[0] = min;

        System.out.println("第一轮后");
        System.out.println(Arrays.toString(arr));

        // 第二轮
        minIndex = 1; // 最小值索引
        min = arr[1]; // 第一轮最小值
        for (int i = 2; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i]; // 重置最小值
                minIndex = i; // 重置minIndex索引
            }
        }

        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮后");
        System.out.println(Arrays.toString(arr));

        // 第三轮
        minIndex = 2; // 最小值索引
        min = arr[2]; // 第一轮最小值
        for (int i = 3; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i]; // 重置最小值
                minIndex = i; // 重置minIndex索引
            }
        }

        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三轮后");
        System.out.println(Arrays.toString(arr));*/
    }
}
