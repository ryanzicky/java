package com.example.jvm.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zhourui
 * @Date: 2020-09-28 09:10
 **/
public class HelloGC {

    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for (;;) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
