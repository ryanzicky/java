package com.example.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: zhourui
 * @Date: 2020-09-21 17:33
 **/
public class T12_ClassReloading2 {

    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            File file = new File("D:/MyProject/Java/JavaProject/" + name.replace(".", "/").concat(".class"));

            if (!file.exists()) {
                return super.loadClass(name);
            }

            try {
                FileInputStream is = new FileInputStream(file);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader myLoader = new MyLoader();
        Class<?> clazz = myLoader.loadClass("com.example.jvm.classloader.Hello");

        myLoader = new MyLoader();
        Class<?> clazz1 = myLoader.loadClass("com.example.jvm.classloader.Hello");
        System.out.println(clazz == clazz1);
    }
}
