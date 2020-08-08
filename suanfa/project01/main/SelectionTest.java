package main;

import sort.Selection;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/8 15:10
 */
public class SelectionTest {

    public static void main(String[] args){
        Integer[] arr = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
