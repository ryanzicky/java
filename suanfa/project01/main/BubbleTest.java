package main;

import sort.Bubble;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2020/8/8 14:52
 */
public class BubbleTest {

    public static void main(String[] args){
        Integer[] arr = {4, 2, 3, 6, 5, 1};
        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
