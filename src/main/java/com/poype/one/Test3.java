package com.poype.one;

public class Test3 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();
        dog.breath();

        Cat cat = new Cat();
        cat.run();
        cat.breath();
    }
}


interface Animal {

    // 不同动物跑的实现不一样，由各个具体的动物实现类决定
    void run();

    // 注意这里的default关键字
    default void breath() {
        System.out.println("所有动物呼吸的动作都差不多，提供默认实现");
    }
}

class Dog implements Animal {

    @Override
    public void run() {
        System.out.println("A dog is running");
    }
}

class Cat implements Animal {

    @Override
    public void run() {
        System.out.println("猫在跑");
    }

    // 虽然在interface中给breath方法提供了默认实现，但在类中可以override它
    @Override
    public void breath() {
        System.out.println("猫的呼吸就是和其它动物不一样");
    }
}

/*
    在interface中提供方法的默认实现也为扩展历史接口提供了便利，例如要在Collection接口中新增一个forEach方法
    如果interface不支持方法的默认实现，那么在Collection接口中新增一个方法后，所有已经实现了该接口的类都会crash
 */