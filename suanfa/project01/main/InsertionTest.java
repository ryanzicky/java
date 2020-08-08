package main;

import sort.Insertion;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/8 15:18
 */
public class InsertionTest {

    public static void main(String[] args){
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
