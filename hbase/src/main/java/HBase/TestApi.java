package HBase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class TestApi {
    private static Connection connection=null;
    private static Admin admin=null;
    static {
        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
            connection = ConnectionFactory.createConnection(configuration);
            admin=connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void close() throws IOException {
        if(admin!=null)
        {
            admin.close();
        }
        if(connection!=null)
        {
            connection.close();
        }
    }

    public static boolean isTableExist(String tablename) throws IOException {
        boolean b = admin.tableExists(TableName.valueOf(tablename));
        return b;
    }
    public static void createTable(String tableName,String... liezu) throws IOException {
        if (liezu.length <= 0) {
            System.out.println("请输入列族");
            return;
        }
        if (isTableExist(tableName)) {
            System.out.println("表名已存在");
            return;
        }
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for(String s:liezu)
        {
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(s);
            hColumnDescriptor.setMaxVersions(3);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
    }
    public static void deleteTable(String tablename) throws IOException {
        if (!isTableExist(tablename)) {
            System.out.println("表不存在");
            return;
        }
        admin.disableTable(TableName.valueOf(tablename));
        admin.deleteTable(TableName.valueOf(tablename));
    }
    public static void createNamespace(String namespace)
    {
        NamespaceDescriptor namespaceDescriptor= NamespaceDescriptor.create(namespace).build();
        try {
            admin.createNamespace(namespaceDescriptor);
        }catch (NamespaceExistException n)
        {
            System.out.println("命名空间已存在");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        //System.out.println(isTableExist("person"));
        createTable("staff3","info");
        //deleteTable("lianxi");
        //createNamespace("lianxi");
        close();
    }
}
