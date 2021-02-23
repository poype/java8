package com.poype.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class Test7 {

    static List<String> strList = new ArrayList<>();
    static {
        strList.add("ABC");
        strList.add("SKY");
        strList.add("SUN");
        strList.add("CHINA");
        strList.add("CAR");
        strList.add("ISLAND");
    }

    public static void main(String[] args) {
        testCollect2();
    }

    // 通过collect方法将stream中的元素转换成集合
    private static void testCollect() {
        // 其实就是把stream中的元素加到结合中，但由于parallelStream会使用多线程，而ArrayList不是线程安全的
        // collect方法接收三个参数，第一个参数会为stream中的每个元素分别构造一个ArrayList，
        // 第二个参数会将元素add到对应的ArrayList中，第三个参数会把所有的ArrayList合并成一个
        List<String> newList =
                strList.parallelStream().
                        map(String::toLowerCase).
                        collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        newList.forEach(System.out::println);
    }

    // 通过Collectors接口的工具方法提供collect方法的三个参数
    private static void testCollect2() {
        List<String> newList =
                strList.parallelStream().
                        map(String::toLowerCase).
                        collect(Collectors.toList());
        newList.forEach(System.out::println);

        Set<String> newSet =
                strList.parallelStream().
                        map(String::toLowerCase).
                        collect(Collectors.toSet());
        newSet.forEach(System.out::println);
    }
}
