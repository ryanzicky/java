package com.example.suanfa.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 希尔排序
 *
 * @Author zhourui
 * @Date 2019/12/12 9:08
 */
public class ShellSort {

    public static void main(String[] args){
        System.out.println(BigDecimal.valueOf(111111).negate());
        System.out.println(BigDecimal.valueOf(111221).add(BigDecimal.valueOf(111111).negate()));
        List<BigDecimal> list = new ArrayList<>();
        list.add(BigDecimal.valueOf(1123));
        list.add(BigDecimal.valueOf(1123).negate());
        System.out.println(list.parallelStream().map(x -> x).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    /*public static void main(String[] args){
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        long l = System.currentTimeMillis();
        shellSort2(arr);
        System.out.println("耗时 = " + (System.currentTimeMillis() - l) + "ms");
    }*/

    public static void shellSort2(int[] arr) {
        // 增量n,并逐步缩小增量
        for (int n = arr.length / 2; n > 0; n /= 2) { // 步长
            // 从第n个元素开始,逐个对其所在的组进行直接插入排序
            for (int i = n; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - n]) {
                    while (j - n >= 0 && temp < arr[j - n]) {
                        // 移动
                        arr[j] = arr[j - n];
                        j -= n;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 交换法
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int n = arr.length / 2; n > 0; n /= 2) { // 步长
            for (int i = n; i < arr.length; i++) { // 步长分组
                for (int j = i - n; j >= 0; j -= n) {
                    if (arr[j] > arr[j + n]) { // 步长为5
                        temp = arr[j];
                        arr[j] = arr[j + n];
                        arr[j + n] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + ++count + "轮排序后");
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 逐步推导
     */
    /*public static void shellSort(int[] arr) {
        // 希尔排序第一轮排序
        // 将10个数据分成10/2=5组
        int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) { // 步长为5
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮排序 = " + Arrays.toString(arr));

        // 第二轮排序
        // 分成5/2组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) { // 步长为2
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮排序 = " + Arrays.toString(arr));

        // 第三轮排序
        // 分成2/2组
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) { // 步长为1
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮排序 = " + Arrays.toString(arr));
    }*/
}
