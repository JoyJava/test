package jvm.gc;

import javassist.ClassPool;

/**
 * java.lang.OutOfMemoryError: Java heap space
 */
public class MicroGeneratorHeapOOM {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            generate("eu.plumbr.demo.Generated" + i);
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}