package com.example.suanfa.sort;

/**
 * 冒泡排序
 *
 * @Author zhourui
 * @Date 2019/12/11 14:54
 */
public class BubbleSort {

    public static void main(String[] args){
        /*int arr[] = {3, 9, -1, 10, -2};
        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(arr));*/

        // 测试冒泡排序速度(O(n^2)),测试80000个数据
        // 创建80000个随机数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long l = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println("耗时 = " + (System.currentTimeMillis() - l) + "ms");
//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(arr));

        /*// 第一趟排序
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第三趟排序
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量,表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第"+ (i + 1) +"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag) { // 在一趟排序中,一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag,进行下次判断
            }
        }
    }
}
