package main;

import sort.Shell;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/8 15:47
 */
public class ShellTest {

    public static void main(String[] args){
        Integer[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        Shell.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
