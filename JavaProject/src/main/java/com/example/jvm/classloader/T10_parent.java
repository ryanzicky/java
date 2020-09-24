package com.example.jvm.classloader;

/**
 * @Author: zhourui
 * @Date: 2020-09-21 16:55
 **/
public class T10_parent extends ClassLoader {

    public static void main(String[] args) {
        System.out.println(getSystemClassLoader());
        System.out.println(new T10_parent().getParent().getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
