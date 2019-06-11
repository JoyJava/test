package jvm.gc;

/**
 * -XX:MaxMetaspaceSize=64m --> Caused by: java.lang.OutOfMemoryError: Metaspace
 */
public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("jvm.gc.MicroGeneratorHeapOOM" + i).toClass();
        }
    }
}