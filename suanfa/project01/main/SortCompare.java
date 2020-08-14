package main;

import sort.Insertion;
import sort.Merge;
import sort.Quick;
import sort.Shell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author zhourui
 * @Date 2020/8/8 16:00
 */
public class SortCompare {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            list.add(new Random().nextInt(100000));
        }

        /*for (int i = 100000; i > 0; i--) {
            list.add(i);
        }*/

        Integer[] a = new Integer[list.size()];
//        testShell(list.toArray(a));
//        testInsertion(list.toArray(a));
//        testMerge(list.toArray(a));
        testQuick(list.toArray(a));
    }

    // 测试希尔排序
    public static void testShell(Integer[] a) {
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("执行希尔排序,耗时: " + (end - start) + "毫秒");
    }

    // 测试插入排序
    public static void testInsertion(Integer[] a) {
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("执行插入排序,耗时: " + (end - start) + "毫秒");
    }

    // 测试归并排序
    public static void testMerge(Integer[] a) {
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("执行归并排序,耗时: " + (end - start) + "毫秒");
    }

    // 测试快速排序
    public static void testQuick(Integer[] a) {
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("执行快速排序,耗时: " + (end - start) + "毫秒");
    }
}
