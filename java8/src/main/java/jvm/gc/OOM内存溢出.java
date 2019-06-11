package jvm.gc;

/**
 * User: fengHong
 * Date: 2019/4/20 12:36
 *
 * -Xmx12m -Xms12m
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class OOM内存溢出 {
    static  final int size = 20 * 1024 * 1024;

    //java ops: -Xmx12m -Xms12m
    public static void main(String[] args) {
        int[] i = new int[size];
    }
}
