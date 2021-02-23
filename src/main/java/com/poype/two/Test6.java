package com.poype.two;

import java.util.Optional;
import java.util.stream.Stream;

public class Test6 {

    static Integer[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        testReduce();
    }

    // reduce, v0 op v1 op v2 op ... op vn
    private static void testReduce() {
        Optional<Integer> optional = Stream.of(numArray).reduce(Integer::sum);
        optional.ifPresent(System.out::println);

        // 由于op是符合数学中结合律的，所以可以使用parallel并发执行reduce的op
        // 注意减法是不满足结合律的
        optional = Stream.of(numArray).parallel().reduce(Integer::sum);
        optional.ifPresent(System.out::println);
    }
}
