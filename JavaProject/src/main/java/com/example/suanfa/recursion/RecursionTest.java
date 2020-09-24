package com.example.suanfa.recursion;

/**
 * @Author zhourui
 * @Date 2019/12/10 15:25
 */
public class RecursionTest {

    public static void main(String[] args){
//        test(5);
        System.out.println(factorial(3));
    }

    // 测试递归
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    // 阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
