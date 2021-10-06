package case1;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    private String connectString="hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private ZooKeeper zk;
    private int sessionTimeout=2000;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server=new DistributeServer();
        server.connect();
        server.regist(args[0]);
        server.business();
    }
    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
    private void connect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
    private void regist(String name) throws KeeperException, InterruptedException {
        String s=zk.create("/servers/"+name,name.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(name+"已上线");
    }
}
