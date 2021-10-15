package review;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBaseAPI {
    private static Connection connection=null;
    private static Admin admin=null;
    static{
        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
            connection=ConnectionFactory.createConnection(configuration);
            admin= connection.getAdmin();
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
    public static boolean istableexist(String tablename) throws IOException {
        return admin.tableExists(TableName.valueOf(tablename));
    }
    public static void createtable(String tablename,String ...liezu) throws IOException {
        if(liezu.length<=0){
            System.out.println("列族为空");
            return;
        }
        if(istableexist(tablename))
        {
            System.out.println("表名已存在");
            return;
        }
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tablename));
        for (String s : liezu) {
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(s);
            //hColumnDescriptor.setMaxVersions(3);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
    }
    public static void listtablename(String namespace) throws IOException {
        TableName[] defaults = admin.listTableNamesByNamespace(namespace);
        for (TableName aDefault : defaults) {
            System.out.println(aDefault.toString());
        }
    }
    public static void deletetable(String tablename) throws IOException {
        admin.disableTable(TableName.valueOf(tablename));
        admin.deleteTable(TableName.valueOf(tablename));
    }
    public static void putData(String tablename,String row,String liezu,String lieming,String value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Put put = new Put(Bytes.toBytes(row));
        put.addColumn(Bytes.toBytes(liezu),Bytes.toBytes(lieming),Bytes.toBytes(value));
        table.put(put);
        table.close();
    }
    public static void getData(String tablename,String row,String liezu,String lieming) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Get get = new Get(Bytes.toBytes(row));
        //get.addFamily(Bytes.toBytes(liezu));
        get.addColumn(Bytes.toBytes(liezu),Bytes.toBytes(lieming));
        Result result = table.get(get);
        for (Cell cell : result.rawCells()) {
            System.out.println(Bytes.toString(CellUtil.cloneQualifier(cell))+":"+Bytes.toString(CellUtil.cloneValue(cell)));
        }
        table.close();
    }
    public static void scanData(String tablename) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneQualifier(cell))+":"+Bytes.toString(CellUtil.cloneValue(cell)));
            }

        }
        table.close();
    }
    public static void deleteData(String tablename,String row,String liezu,String lieming) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Delete delete = new Delete(Bytes.toBytes(row));
        //delete.addColumns(Bytes.toBytes(liezu),Bytes.toBytes(lieming));
        table.delete(delete);
        table.close();
    }
    public static void main(String[] args) throws IOException {
        //createtable("asd","info","info2");
        //listtablename("default");
        //deletetable("asd");
        /*putData("asd","01","info","name","kwc");
        putData("asd","01","info","age","18");
        putData("asd","01","info2","zhiye","student");
        putData("asd","01","info2","salar","23000");*/
        //getData("asd","01","info","name");
        //scanData("asd");
        //deleteData("asd","01","info","age");
        close();
    }
}
