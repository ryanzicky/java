package com.example.jvm.classloader;

/**
 * @Author: zhourui
 * @Date: 2020-09-21 17:29
 **/
public class T11_ClassReloading1 {

    public static void main(String[] args) throws ClassNotFoundException {
        T10_parent t10_parent = new T10_parent();
        Class<?> clazz = t10_parent.loadClass("com.example.jvm.classloader.Hello");

        t10_parent = null;
        System.out.println(clazz.hashCode());

        t10_parent = null;

        t10_parent = new T10_parent();
        Class<?> clazz1 = t10_parent.loadClass("com.example.jvm.classloader.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
