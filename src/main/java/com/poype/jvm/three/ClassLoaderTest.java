package com.poype.jvm.three;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    // 加载与自己在同一路径下的Class文件
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    // com.poype.jvm.three.ClassLoaderTest
                    // java.lang.Object
                    // java.lang.ClassLoader
                    // com.poype.jvm.three.ClassLoaderTest$1    会连续打印这个4行
                    System.out.println(name);
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);

                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Object obj = myLoader.loadClass("com.poype.jvm.three.ClassLoaderTest").newInstance();
        System.out.println(obj instanceof ClassLoaderTest);  // false
        // obj是来自自定义的类加载器，而类ClassLoaderTest默认由应用默认加载器加载，所以是false
    }
}
