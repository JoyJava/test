package fh;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * User: fh
 * Date: 16/10/31 下午5:14
 */
public class 选举测试 {
//    public static String host = "127.0.0.1:12181,127.0.0.1:12182,127.0.0.1:12183";
    public static String host = "127.0.0.1:2181";

    public static void main(String[] args) throws IOException {
        System.out.println("input sec...");
        int stopTime = NumberUtils.toInt(new BufferedReader(new InputStreamReader(System.in)).readLine(),10) ;

        CuratorFramework zkCli = CuratorFrameworkFactory.builder()
                .connectString(host)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        System.out.println("stopTime 秒 = " + stopTime);
        LeaderSelectorListener leaderSelectorListener = new MyLeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println(" ~~~~~~~ stopTime: " + stopTime + client);
                TimeUnit.SECONDS.sleep(stopTime);
            }

        };

        zkCli.start();
    }
}
