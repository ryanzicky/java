package code01;

/**
 * @Author: zhourui
 * @Date: 2020-09-27 17:16
 **/
public class Code2020092701 {

    public static void main(String[] args) {
        System.out.println(bit1Counts(127));
    }

    public static int bit1Counts(int n) {
        int count = 0;

        while (n != 0) {
            int rightOne = n & (~n) + 1;
            count++;
            n ^= rightOne;
        }

        return count;
    }
}
