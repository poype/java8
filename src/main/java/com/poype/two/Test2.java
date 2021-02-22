package com.poype.two;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 除了调用Collection的stream方法创建Stream对象外，其它创建Stream的方式
 */
public class Test2 {

    public static void main(String[] args) {
        createStreamFromArray();
        System.out.println("-------------------");
        testStreamOf();
        System.out.println("-------------------");
        createStreamFromArray2();
        System.out.println("-------------------");
        testEmptyStream();
        System.out.println("-------------------");
        testGenerate();
        System.out.println("-------------------");
        testIterate();
    }

    // 通过Stream.of创造Stream实例，Stream.of可以接收一个数组参数，也可以接收任意多个参数
    private static void createStreamFromArray() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 数组作为参数，单线程
        Stream.of(array).forEach(System.out::println);

        // 数组作为参数，多线程
        Stream.of(array).parallel().forEach(
                (elem) -> System.out.println(elem + "----" + Thread.currentThread()));
    }

    // Stream.of可以接收任意个参数构造Stream
    private static void testStreamOf() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
    }

    // Arrays.stream将一个数组转成stream
    private static void createStreamFromArray2() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(array, 2, 5).forEach(System.out::println);
    }

    // 构造一个empty stream
    private static void testEmptyStream() {
        Stream.empty().forEach(System.out::println);
    }

    // generate会利用传入的interface function生成一个无限大的stream
    private static void testGenerate() {
        Stream<Double> randStream = Stream.generate(Math::random);
        randStream.forEach(System.out::println);
    }

    // 利用iterate静态方法生成一个拥有连续值的stream，也是无限大的stream
    private static void testIterate() {
        // producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
        Stream<Integer> intStream = Stream.iterate(0, (num) -> num + 1);
        intStream.forEach(System.out::println);
    }
}
