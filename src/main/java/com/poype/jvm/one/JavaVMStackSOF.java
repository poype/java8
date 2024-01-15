package com.poype.jvm.one;

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

// 执行命令：java -Xss128k com.poype.jvm.one.JavaVMStackSOF

/*
stack length:828
Exception in thread "main" java.lang.StackOverflowError
        at com.poype.jvm.one.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:8)
        at com.poype.jvm.one.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
        at com.poype.jvm.one.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
 */

// java -Xss256k com.poype.jvm.one.JavaVMStackSOF  栈的深度能达到 2193
// java -Xss128k com.poype.jvm.one.JavaVMStackSOF  栈的深度能达到 832

// 栈的容量无法容纳新的栈帧会导致StackOverflowError异常