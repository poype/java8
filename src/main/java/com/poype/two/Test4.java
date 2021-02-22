package com.poype.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        System.out.println("-----------------------");
        testCount();
        System.out.println("-----------------------");
        testMax();
        System.out.println("-----------------------");
        testFindFirst();
        System.out.println("-----------------------");
        testFindAny();
        System.out.println("-----------------------");
        testAnyMatch();
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

    // count of stream
    private static void testCount() {
        long count = wordList.stream().count();
        System.out.println(count);
    }

    private static void testMax() {
        Optional<String> maxOptional =
                wordList.stream().max(String::compareToIgnoreCase);
        maxOptional.ifPresent((max) -> System.out.println("max: " + max));
    }

    private static void testFindFirst() {
        Optional<String> firstOptional = wordList.stream().findFirst();
        firstOptional.ifPresent((firstStr) -> System.out.println("first string: " + firstStr));
    }

    private static void testFindAny() {
        // 如果不是parallelStream，findAny和findFirst的效果一样
        Optional<String> anyOptional = wordList.parallelStream().findAny();
        anyOptional.ifPresent((firstStr) -> System.out.println("first string: " + firstStr));
    }

    // anyMatch方法应该更实用，就是用于检测stream中是否存在一个符合条件的元素
    private static void testAnyMatch() {
        boolean result = wordList.parallelStream().anyMatch((str) -> str.startsWith("A"));
        System.out.println(result);
    }
}
