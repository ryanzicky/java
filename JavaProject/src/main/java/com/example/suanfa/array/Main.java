package com.example.suanfa.array;

/**
 * @Author zhourui
 * @Date 2019/10/23 10:00
 */
public class Main {

    public static void main(String[] args){
        Array array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        array.add(1, 100);
        System.out.println(array.toString());
        array.remove(1);
        System.out.println(array.toString());

    }
}
