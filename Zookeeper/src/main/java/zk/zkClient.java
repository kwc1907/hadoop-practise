package zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class zkClient {
    private String connect = "192.168.10.102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout = 2000;
    ZooKeeper zkClient;
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connect, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/sanguo", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(String i:children)
                {
                    System.out.println(i);
                }
            }
        });
    }
    @Test
    public void create() throws KeeperException, InterruptedException {
        String modeCreate=zkClient.create("/xiyou","xiyouji".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    @Test
    public void getChild() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/sanguo", true);
        for(String i:children)
        {
            System.out.println(i);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat =zkClient.exists("/xiyou",false);
        System.out.println(stat==null? "not exist":"exist");
    }
}

