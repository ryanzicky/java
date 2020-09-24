package com.example.suanfa.sort;

/**
 * @Author zhourui
 * @Date 2019/12/12 10:43
 */
public class QuickSort {

    public static void main(String[] args){
//        int[] arr = {-9, 78, 0, 23, -567, 70};
        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        long l = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("耗时 = " + (System.currentTimeMillis() - l) + "ms");
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; // 左下标
        int r = right; // 右下标
        // 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; // 临时变量,交换临时值
        // while循环的目的是跟pivot的值做比较
        while (l < r) {
            // 遍历pivot左边值,找到比pivot大的值
            while (arr[l] < pivot) {
                l += 1;
            }
            // 遍历pivot右边值,找到比pivot小的值
            while (arr[r] > pivot) {
                r -= 1;
            }

            // 如果l >= r 说明已经按照pivot遍历完毕
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }

            if (arr[r] == pivot) {
                l +=1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
