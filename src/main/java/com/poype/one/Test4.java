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

// Worker的父类和实现的接口中都提供了相同方法的实现，super class win。interface接口中的默认实现被忽略
class Worker extends Person implements Speak {

}
