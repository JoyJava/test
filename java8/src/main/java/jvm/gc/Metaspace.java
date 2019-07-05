package jvm.gc;

import javassist.CannotCompileException;
import scala.math.Ordering.String;

/**
 * -XX:MaxMetaspaceSize=64m --> Caused by: java.lang.OutOfMemoryError: Metaspace
 */
public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws CannotCompileException {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("jvm.gc.MicroGeneratorHeapOOM" + i).toClass();
        }
    }
}