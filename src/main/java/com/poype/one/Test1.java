package com.poype.one;

/**
 * lambda 就是 a block of code，代表一个代码片段
 * 下面分别是4种实现“代码片段”的方式
 */
public class Test1 {

    public static void main(String[] args) {
//        startThread1();
//        startThread2();
//        startThread3();
        startThread4();
    }

    // java 6的方式，目的是要在新的线程中执行一段代码逻辑(方法)，但却需要提供一个完成的class
    private static void startThread1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new Thread1");
            }
        });
        t.start();
    }

    // lambda模式，比提供一个完整的class简单了很多
    private static void startThread2() {
        Thread t = new Thread(
                () -> System.out.println("start new Thread2"));
        t.start();
    }

    // method reference模式，可以这样理解：启动一个线程，在线程中执行静态方法printForThread3的逻辑
    // Test1::printForThread3 等价与 ()->printForThread3
    private static void startThread3() {
        Thread t = new Thread(Test1::printForThread3);
        t.start();
    }

    // method reference的另外一种模式，上面调用的是静态方法，这次调用的是实例方法
    private static void startThread4() {
        Test1 test = new Test1();
        Thread t = new Thread(test::printForThread4);
        t.start();
    }

    private static void printForThread3() {
        System.out.println("start enw Thread3");
    }

    public void printForThread4() {
        System.out.println("start new Thread4");
    }
}


