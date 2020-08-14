package main;

/**
 * @Author zhourui
 * @Date 2020/8/8 16:26
 */
public class TestFactorial {

    public static void main(String[] args){
        // 求N的阶乘
        long result = factorial(9);
        System.out.println(result);
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
