package com.poype.two;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {

    private static List<String> strList = new ArrayList<>();
    static {
        strList.add("today");
        strList.add("yesterday");
        strList.add("tomorrow");
        strList.add("last day");
        strList.add("everyday");
        strList.add("after tomorrow");
        strList.add("last yesterday");
    }

    public static void main(String[] args) {
        count();
        System.out.println("------------------------------");
        iterateElem();
        System.out.println("------------------------------");
        forEachElem();
        System.out.println("------------------------------");
        forEachElemWithMethodReference();
        System.out.println("------------------------------");
        testParallelStream();
    }

    // 通过stream对集合进行统计
    private static void count() {
        long count = strList.stream().filter((word)->word.length() > 8).count();
        System.out.println(count);
    }

    // 通过iterator遍历集合元素
    private static void iterateElem() {
        Iterator iterator =
                strList.stream().filter((word)->word.length() > 8).iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // 通过forEach遍历集合中的元素对象，使用lambda表达式
    private static void forEachElem() {
        strList.stream().
                filter((work) -> work.length() > 8).
                forEach((word) -> System.out.println(word));
    }

    // 通过forEach遍历集合中的元素对象，使用method reference
    private static void forEachElemWithMethodReference() {
        strList.stream().
                filter((word) -> word.length() > 8).
                forEach(System.out::println);
    }

    // 多线程stream
    private static void testParallelStream() {
        long count = strList.parallelStream().filter((word) -> {
            System.out.println(word + "----" + Thread.currentThread());
            return word.length() > 8;
        }).count();
        System.out.println(count);
    }
}
