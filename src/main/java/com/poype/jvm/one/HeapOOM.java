package com.poype.jvm.one;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while(true) {
            list.add(new OOMObject());
        }
    }
}

// 执行命令：java -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com.poype.jvm.one.HeapOOM


/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid46980.hprof ...
Heap dump file created [29835934 bytes in 0.136 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */

// -Xms20m -Xmx20m 限制堆的大小为20MB，不可扩展
// -XX:+HeapDumpOnOutOfMemoryError  让 JVM 在出现 OOM 错误时 Dump 出当前的内存堆快照以便进行事后分析