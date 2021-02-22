package com.poype.two;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * An Optional<T> object is either a wrapper for an object of type T or for no object. It
 * is intended as a safer alternative than a reference of type T that refers to an object
 * or null. But it is only safer if you use it right.
 */
public class Test5 {

    public static void main(String[] args) {

    }

    private static void badCase() {
        Optional<Object> optional = Stream.empty().findFirst();
        // 不要这样使用Optional，这样使用并不比直接使用对象的reference简单
        if (optional.isPresent()) {
            optional.get().toString();
        }
    }
}
