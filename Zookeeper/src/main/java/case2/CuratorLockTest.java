package case2;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLockTest {
    public static void main(String[] args) {
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(), "/locks");
        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(), "/locks");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.acquire();
                    System.out.println("线程一获取到锁");
                    lock1.acquire();
                    System.out.println("线程一再次获取到锁");
                    Thread.sleep(5*1000);
                    lock1.release();
                    System.out.println("线程一 释放锁");
                    lock1.release();
                    System.out.println("线程一 再次释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.acquire();
                    System.out.println("线程2获取到锁");
                    lock2.acquire();
                    System.out.println("线程2再次获取到锁");
                    Thread.sleep(5*1000);
                    lock2.release();
                    System.out.println("线程2 释放锁");
                    lock2.release();
                    System.out.println("线程2 再次释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private static CuratorFramework getCuratorFramework()
    {
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("hadoop102:2181,hadoop103:2181,hadoop104:2181")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(2000)
                .retryPolicy(exponentialBackoffRetry).build();
        client.start();
        System.out.println("zookeeper 启动成功");
        return client;
    }
}
