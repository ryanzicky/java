package main;

import sort.Quick;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/14 11:25
 */
public class QuickTest {

    public static void main(String[] args){
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
