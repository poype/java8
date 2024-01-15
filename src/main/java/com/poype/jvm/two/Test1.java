package com.poype.jvm.two;

/**
 * Serial + Serial old
 * 对象优先在Eden分配
 */
public class Test1 {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}

/*
 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:PrintGCDetails -XX:SurvivorRatio=8
 限制java堆的大小是20MB，不可扩展，10MB分配给新生代
 -XX:SurvivorRatio=8 决定了 Eden区与一个Survivor区的空间比例是8:1

 在Java20，默认的垃圾收集器就已经是G1了，所以下面的启动命令明确指定了UseSerialGC
 java -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 com.poype.jvm.two.Test1
 */

