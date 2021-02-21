package com.poype.one;

public class Test2 {

    public static void main(String[] args) {
//        repeatMessage("test", 10);

        Test2 test = new Test2();
//        test.startThread1();
        test.startThread2();
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

    @Override
    public String toString() {
        return "Test2(nested class) to String";
    }

    /**
     * 下面的startThread1和startThread2两个方法都是在线程里面打印this指针，第一个用内部类实现，第二个用lambda实现
     * 内部类也是一个真实的class，所以第一个在线程中打印的this指向内部类的实例
     * 而lambda只是“a block of code”，没有类的概念，所以第二个在线程中的this指针指向的还是Test2类的实例
     *
     * lambda代码快中的作用域与包裹它的代码块共享作用域：
     * 之所以这样设计是为了凸显lambda是"a block of code"，并不是java6中的类。但猜测其实现原理也是通过内部类的形式，
     * 只是在用内部类实现lambda的时候，将外部类的this指针copy给了实现lambda的内部类，以此来达到"lambda代码快中的作用域
     * 与包裹它的代码块作用域完全相同"的目的
     */
    public void startThread1() {
        // 这里的this指针指向外部类的对象
        System.out.println(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 这里的this指针指向内部类的对象
                System.out.println(this + "--->" + this.getClass());
            }

            @Override
            public String toString() {
                return "Runnable toString";
            }
        }).start();
    }

    // lambda代码快中的作用域与包裹它的代码块作用域完全相同
    public void startThread2() {
        System.out.println(this);

        new Thread(()->{
            // 这里的this指针跟外部函数的指针相同，也指向Test2类
            System.out.println(this + "--->" + this.getClass());
        }).start();
    }
}
