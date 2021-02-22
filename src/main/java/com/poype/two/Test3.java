package com.poype.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test3 {

    static List<String> wordList = new ArrayList<>();
    static {
        wordList.add("ABC");
        wordList.add("SKY");
        wordList.add("COLOR");
        wordList.add("RED");
        wordList.add("CAT");
    }

    public static void main(String[] args) {
        transform();
        System.out.println("---------------------");
        limitN();
        System.out.println("---------------------");
        skipN();
        System.out.println("---------------------");
        concat();
    }

    // map方法的interface function接收一个参数，生成一个结果
    // When you use map, a function is applied to each element,
    // and the return values are collected in a new stream.
    private static void transform() {
        // String::toLowerCase就是Class::instanceMethod的形式
        wordList.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        wordList.stream()
                .map((str) -> str.charAt(0))
                .forEach(System.out::println);
    }

    private static void limitN() {
        // The call stream.limit(n) returns a new stream that ends after n elements
        // (or when the original stream ends if it is shorter).
        wordList.stream().limit(3).forEach(System.out::println);
    }

    private static void skipN() {
        // 跳过前3给元素
        wordList.stream().skip(3).forEach(System.out::println);
    }

    // Stream.concat静态方法拼接两个stream
    private static void concat() {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> secondStream = Stream.of(5, 6, 7, 8);
        Stream.concat(firstStream, secondStream).forEach(System.out::println);
    }
}
