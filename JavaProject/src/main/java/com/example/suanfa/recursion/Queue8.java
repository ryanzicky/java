package com.example.suanfa.recursion;

/**
 * 8皇后问题
 *
 * @Author zhourui
 * @Date 2019/12/11 9:51
 */
public class Queue8 {

    int max = 8; //  定义共有多少个皇后
    int[] array = new int[max]; // 保存皇后位置
    static int count = 0;
    public static void main(String[] args){

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d中解法", count);
    }

    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 放置第n个皇后
     */
    public void check(int n) {
        if (n == max) {
            print();
            return;
        }

        // 一次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把这个皇后n,放到该行的第一列
            array[n] = i;
            // 判断当放置第n个皇后到i列时,是否冲突
            if (judge(n)) { // 不冲突
                // 接着放n + 1个皇后,即开始递归
                check(n + 1);
            }
            // 如果冲突,就继续执行array[n] = i;即将第n个皇后，放置再本行的后一个位置
        }
    }

    /**
     * 查看放置第n个皇后位置是否跟已放置的冲突
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
