package com.poype.one;

public class Test2 {

    public static void main(String[] args) {
        repeatMessage("test", 10);
    }

    /**
     * text和count这两个局部变量在lambda中被引用，相当于被一个内部函数所引用
     * 虽然没有显示的将text和count声明为final，但它们本质上就是final的，下面对count修改的代码是错误的
     */
    public static void repeatMessage(String text, int count) {
        // count++; error, Variable used in lambda expression should be final or effectively final

        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
}
