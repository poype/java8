package com.poype.two;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

    static List<String> wordList = new ArrayList<>();
    static {
        wordList.add("BCD");
        wordList.add("ABC");
        wordList.add("ABC");
        wordList.add("A");
        wordList.add("ABC");
        wordList.add("ABC");
        wordList.add("LAST");
        wordList.add("LAST DAY");
    }

    public static void main(String[] args) {
        testDistinct();
        System.out.println("-----------------------");
        testSort1();
        System.out.println("-----------------------");
        testSort2();
    }

    // distinct方法去重
    private static void testDistinct() {
        wordList.stream().distinct().forEach(System.out::println);
    }

    // sorted方法对stream中的元素排序
    private static void testSort1() {
        wordList.stream().sorted().forEach(System.out::println);
    }

    private static void testSort2() {
        // 按字符串长度逆序排列
        wordList.stream()
                .sorted((String str1, String str2) -> str2.length() - str1.length())
                .forEach(System.out::println);
    }
}
