package fh.lock;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;


import static fh.选举测试.host;

/**
 * User: fh
 * Date: 16/10/31 下午6:55
 */
public class 分布式锁 {
//    private InterProcessMutex lock;

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory
                .builder()
                .connectString(host)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        client.start();
        InterProcessLock lock = new InterProcessMutex(client, "/fh/lock");


        try {
            System.out.println("run ..." + lock.isAcquiredInThisProcess());
//            if (lock.acquire(100, TimeUnit.SECONDS)) {

            lock.acquire();
            int i = RandomUtils.nextInt(10);
            System.out.println(" has the lock  & sleep" + i + "  "+lock.isAcquiredInThisProcess());
            TimeUnit.SECONDS.sleep(i);

            System.out.println(" over...");

        } finally {
            System.out.println(" releasing the lock");
            lock.release(); // always release the lock in a finally block
        }

    }

}
