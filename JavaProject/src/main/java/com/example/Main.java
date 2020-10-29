package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhourui
 * @Date 2020/3/23 17:03
 */
public class Main {

    public static void main(String[] args){
        String source = "2135\n" +
                "2136\n" +
                "2137\n" +
                "2138\n" +
                "2139\n" +
                "2140\n" +
                "2141\n" +
                "2142\n" +
                "2143\n" +
                "2144\n" +
                "2145\n" +
                "2146\n" +
                "2147\n" +
                "2148\n" +
                "2149\n" +
                "2150\n" +
                "2151\n" +
                "2152\n" +
                "2153\n" +
                "2154";
        System.out.println(convertSourceToStr(source));
        System.out.println(convertSourceToList(source));
        System.out.println(convertSourceToStr1(source));
        System.out.println(convertSourceToInt(source));
    }

    private static String convertSourceToInt(String source) {
        return source.replace("\n",",");
    }

    private static String convertSourceToStr(String source) {
        return "'" + source.replace("\n","','") + "'";
    }

    private static String convertSourceToList(String sourc) {
        List<String> list = Arrays.asList(sourc.split("\n"));
        System.out.println(list.size());
        return list.stream().map(x -> "\"" + x + "\"").collect(Collectors.joining(","));
    }

    private static String convertSourceToStr1(String source) {
        return "'" + source.replace("\n",",") + "'";
    }
}
