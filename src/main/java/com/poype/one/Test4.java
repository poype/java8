package com.poype.one;

public class Test4 {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.getDescription();
    }
}

class Person {

    public void getDescription() {
        System.out.println("The person is also animal");
    }
}

interface Speak {

    default void getDescription() {
        System.out.println("speak is a ability of person");
    }
}

interface Run {

    default void getDescription() {
        System.out.println("run run run run !!!");
    }
}

// Worker的父类和实现的接口中都提供了相同方法的实现，super class win。interface接口中的默认实现被忽略
class Worker implements Speak, Run {

    /**
     * Speak和Run两个接口中的getDescription方法都有默认实现，Worker类不知道该使用哪个实现
     * 为了解决冲突，只能自己提供一个精确的实现
     */
    @Override
    public void getDescription() {
        System.out.println("Worker类自己的getDescription方法");
    }
}
