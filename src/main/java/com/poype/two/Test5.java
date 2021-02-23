package com.poype.two;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * An Optional<T> object is either a wrapper for an object of type T or for no object. It
 * is intended as a safer alternative than a reference of type T that refers to an object
 * or null. But it is only safer if you use it right.
 */
public class Test5 {

    static Set<String> strSet = new HashSet<>();
    static {
//        strSet.add("one");
//        strSet.add("two");
    }

    public static void main(String[] args) {
        goodWay1();
        goodWay2();
    }

    private static void badCase() {
        Optional<Object> optional = Stream.empty().findFirst();
        // 不要这样使用Optional，这样使用并不比直接使用对象的reference简单
        if (optional.isPresent()) {
            optional.get().toString();
        }
    }

    // 使用Optional的正确方式
    private static void goodWay1() {
        Optional<String> optional = strSet.stream().findFirst();
        // 如果optional中有值，对应的函数才会执行，否则什么都不会发生
        optional.ifPresent(System.out::println);
    }

    private static void goodWay2() {
        Optional<String> optional = strSet.stream().findFirst();
        // 如果optional中有值，就返回对应的值，否则返回默认值
        String str = optional.orElse("empty");
        System.out.println(str);
    }
}
