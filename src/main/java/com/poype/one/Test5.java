package com.poype.one;

import java.util.function.BiFunction;

public class Test5 {

    public static void main(String[] args) {

        Button button = new Button();

        // 繁琐的lambda表达式实现加法
        button.listen((Integer x, Integer y) -> {
            return x + y;
        });

        // 简便的lambda表达式实现加法，无需写param类型，且由于只有一行代码，无需“{}”
        button.listen((x, y) -> x + y);

        // method reference实现加法，这种方式最简便。
        button.listen(Integer::sum);

    }
}

class Button {

    // 模拟按钮被点击触发的事件，每次点击按钮总是输入两个5，计算结果由算法决定
    void listen(BiFunction<Integer, Integer, Integer> callback) {
        Integer result = callback.apply(5,5);
        System.out.println(result);
    }
}
