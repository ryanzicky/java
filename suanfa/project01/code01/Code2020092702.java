package code01;

/**
 * @Author: zhourui
 * @Date: 2020-09-27 17:25
 **/
public class Code2020092702 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 12, 4, 4, 12, 6, 6, 10, 9, 10, 9};
//        test(arr);

        int[] arr1 = new int[]{4, 12, 4, 4, 12, 6, 6, 10, 9, 10, 9, 9};
        test1(arr1);
    }

    public static void test(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }

    public static void test1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        int rightOne = eor & ((~eor) + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
