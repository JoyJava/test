package jvm;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author fh63045
 *-Xms30M -Xmx30M -Xmn10M  -Xloggc:gc.log -XX:+PrintTenuringDistribution -XX:+UseParallelGC
 *-Xms30M -Xmx30M -Xmn10M  -Xloggc:gc.log -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 *
 */
public class TestGcCollector {

	public static void main(String[] args) throws InterruptedException {
		List<Object> caches = new ArrayList<Object>();
		for (int i = 0; i < 7; i++) {
			caches.add(new byte[1024 * 1024 * 3]);
			Thread.sleep(1000);
		}
		caches.clear();
		for (int i = 0; i < 2; i++) {
			caches.add(new byte[1024 * 1024 * 3]);
			Thread.sleep(1000);
		}
	}
	
	
	public static String getMemUsage() {
		long free = Runtime.getRuntime().freeMemory();
		long total = Runtime.getRuntime().totalMemory();
		StringBuffer buf = new StringBuffer();
		buf.append("[Mem: used ").append((total-free)>>20).append("M free ")
		.append(free>>20).append("M total ")
		.append(total>>20).append("M]");
		return buf.toString();
		}
}