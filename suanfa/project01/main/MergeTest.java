package main;

import sort.Merge;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/14 9:01
 */
public class MergeTest {

    public static void main(String[] args){
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
