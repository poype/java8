package com.poype.jvm.three;

import java.util.concurrent.TimeUnit;

public class Test {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

        while(true) {
            TimeUnit.MILLISECONDS.sleep(1000);
            allocation4 = null;
            allocation4 = new byte[4 * _1MB];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testAllocation();
    }
}

/*
1. jps: 列出正在运行的JVM进程，并会显示其执行主类(Main Class)

$ jps
47060
54936 Test    这行就是测试类
39004 Jps

两个重要参数：
-l 输出主类的全名   -v 输出虚拟机进程启动时的JVM参数

$ jps -l
47060
53272 jdk.jcmd/sun.tools.jps.Jps
54936 com.poype.jvm.three.Test    这行是测试类

2. jstat: 监视虚拟机各种运行状态信息
$ jstat -gcutil 54532
  S0     S1     E      O      M     CCS    YGC     YGCT     FGC    FGCT     CGC    CGCT       GCT
  0.00   0.10   0.00  89.54  50.09  10.08     64     0.100     0     0.000     0     0.000     0.100

S0 S1 表示 两个Survivor区
E Eden
O Old    占比 89.54%
虽然使用的是G1收集器，但新生代和老年代也都是有的

3. jstack: Java堆栈跟踪，用于生成虚拟机当前时刻的线程快照。也就是threaddump。
           线程快照就是当前虚拟机内每一条线程正在执行的方法堆栈的集合

4. jmap: 生成堆快照 heapdump，用参数-XX:+HeapDumpOnOutOfMemoryError参数可以在JVM发生OOM时自动生成heapdump。

有两种dump文件，一种是heapdump，一种是threaddump

 */