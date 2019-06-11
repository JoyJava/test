package jvm.gc;

import java.util.Map;
import java.util.Random;

/**
 * -Xmx12m -Xms12m              -->     Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 * -Xmx12m -Xms12m -XX:+UseG1GC -->     Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
 *                              --> 这些真实的案例表明, 在资源受限的情况下, 无法准确预测程序会死于哪种具体的原因。所以在这类错误面前, 不能绑死某种特定的错误处理顺序。
 *
 */
public class TestWrapper {
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}