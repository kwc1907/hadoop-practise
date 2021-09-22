package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

/**
 * 客户端代码常用套路
 * 1、获取一个客户端对象
 * 2、执行相关的操作命令
 * 3、关闭资源
 * HDFS  zookeeper
 */
public class hdfsclient {
    private URI uri;
    private Configuration configuration;
    private String user;
    private FileSystem fs;
    @Before
    public void init() throws Exception
    {
        uri=new URI("hdfs://hadoop102:8020");
        configuration=new Configuration();
        configuration.set("dfs.replication","2");
        user="kwc";
        fs=FileSystem.get(uri,configuration,user);
    }
    @Test
    public void mkdir() throws Exception
    {
        fs.mkdirs(new Path("/first/lianxi"));

    }
    @Test
    /**
     * 参数优先级
     * hdfs-default.xml => hdfs-site.xml=> 在项目资源目录下的配置文件 =>代码里面的配置
     *
     * @throws IOException
     */
    public void put() throws IOException {
        fs.copyFromLocalFile(new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\python.txt"),new Path("/first/lianxi"));
    }
    @Test
    public void get() throws IOException {
        fs.copyToLocalFile(new Path("/sanguo/zhongguo.txt"),new Path("C:\\Users\\若久\\Desktop\\随缘记事本"));
    }
    @Test
    public void rm() throws IOException
    {
        fs.delete(new Path("/xiyou"),true);  //true代表递归删除
    }
    @Test
    public void mv() throws IOException
    {
        fs.rename(new Path("/Java"),new Path("/Java.txt"));
    }
    @Test
    public void ls() throws IOException
    {
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/first"), true);
        while(listFiles.hasNext()){
            LocatedFileStatus file = listFiles.next();
            System.out.println(file.getPath());//获取文件路径
            System.out.println(file.getPath().getName());
            System.out.println(file.getPermission());
            System.out.println(file.getOwner());
            System.out.println(file.getGroup());
            System.out.println(file.getLen());
            System.out.println(file.getModificationTime());
            System.out.println(file.getReplication());
            System.out.println(file.getBlockSize());
            //获取块信息
            BlockLocation[] blockLocations = file.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }
    @Test
    public void isFile() throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus file:fileStatuses)
        {
            if(file.isFile())
            {
                System.out.println(file.getPath().getName()+"是文件");
            }
            else
            {
                System.out.println(file.getPath().getName()+"是目录");
            }
        }

    }
    @After
    public void close() throws Exception
    {
        fs.close();
    }
}
