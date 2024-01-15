package com.poype.jvm.one;

import java.util.HashSet;
import java.util.Set;

/**
 * 想测试 方法区 的OOM异常，但只能在JDK6上看到效果。
 * JDK8之后已经将字符串常量池从方法区挪到了堆中
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        long i = 0;

        while(true) {
            // intern方法：如果字符串常量池包含该字符串，则返回常量池中该字符串的引用，否则将该字符串添加到常量池中。
            set.add(String.valueOf(i++).intern());
        }
    }
}

// 执行命令：java -XX:PermSize=6m -XX:MaxPermSize=6m com.poype.jvm.one.RuntimeConstantPoolOOM
// 上面这个命令只能在JDK 6上执行， JDK8之后已经不认识PermSize这个参数。
// 而且字符串常量池也从方法区被挪到了堆中，所以上面的代码会报如下异常：
/*
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.HashMap.newNode(HashMap.java:1909)
	at java.base/java.util.HashMap.putVal(HashMap.java:648)
	at java.base/java.util.HashMap.put(HashMap.java:618)
	at java.base/java.util.HashSet.add(HashSet.java:229)
	at com.poype.jvm.one.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:14)
 */
