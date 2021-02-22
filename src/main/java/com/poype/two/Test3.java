package com.poype.two;

import java.util.ArrayList;
import java.util.List;

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
}
