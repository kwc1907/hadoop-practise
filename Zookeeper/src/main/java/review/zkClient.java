package review;

import org.apache.zookeeper.*;

import java.io.IOException;

public class zkClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("hadoop102:2181,hadoop103:2181,hadoop104:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        String s = zk.create("/fuxi", "复习".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        byte[] data = zk.getData("/fuxi", false,null);
        System.out.println(new String(data));

    }
}
