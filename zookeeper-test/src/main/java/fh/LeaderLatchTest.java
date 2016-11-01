package fh;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * User: fh
 * Date: 16/10/31 上午11:31
 */
public class LeaderLatchTest {


    public static void main(String[] args) {


        List<CuratorFramework> clientList = Lists.newArrayList();

        List<LeaderLatch> leaderLatchList = Lists.newArrayList();
        try {

            int nextInt = RandomUtils.nextInt();

            IntStream.range(0, 1).forEach((it) -> {
                CuratorFramework client = CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                        .namespace("fh")
                        .build();


                clientList.add(client);
                LeaderLatch leaderLatch = new LeaderLatch(client, "/leaderTest", "clinetTest#" + nextInt);
//                LeaderLatch leaderLatch = new LeaderLatch(client, "/leaderTest", "clinetTest #" + it);
                leaderLatchList.add(leaderLatch);

                client.start();
                try {
                    leaderLatch.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //do it
            TimeUnit.SECONDS.sleep(2);

            final LeaderLatch[] currentLeader = {null};

            leaderLatchList.forEach((ll) -> {
                try {
                    System.out.println("~~~~currentId: " + ll.getId() + "  leader: " + ll.getLeader().getId() + " hasLeadership: " + ll.hasLeadership());
                    if (ll.hasLeadership()) currentLeader[0] = ll;

                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            currentLeader[0].close();
            System.out.println("~~~~release the leader " + currentLeader[0].getId());


            leaderLatchList.get(0).await(2, TimeUnit.SECONDS);
            System.out.println("~~~~Client #0 maybe is elected as the leader or not although it want to be");
            System.out.println("~~~~the new leader is " + leaderLatchList.get(0).getLeader().getId());

            System.out.println("~~~~Press enter/return to quit\n");
            new BufferedReader(new InputStreamReader(System.in)).readLine();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("~~~~Shutting down...");

//                leaderLatchList.forEach(CloseableUtils::closeQuietly);
//                clientList.forEach(CloseableUtils::closeQuietly);

//                CloseableUtils.closeQuietly(server);
        }
    }

}
