import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * User: fh
 * Date: 16/9/2 10:52
 */
public class ZKClientTest {

    public static String host = "127.0.0.1:12181,127.0.0.1:12182,127.0.0.1:12183";

    public static void main(String[] args) throws Exception {
        CuratorFramework zkCli = CuratorFrameworkFactory.builder()
                .connectString(host)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        zkCli.start();
        String s = zkCli.create().forPath("/fh2");

        System.out.println("s = " + s);

//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
//        client.start();
//
//        String forPath = client.create().forPath("/dubbo");
//        System.out.println("forPath = " + forPath);
    }

}
