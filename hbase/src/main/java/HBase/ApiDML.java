package HBase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ApiDML {
    private static Connection connection=null;
    static{
        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");
            connection=ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void close() throws IOException {
        if(connection!=null)
        {
            connection.close();
        }
    }
    public static void putData(String tablename,String row,String liezu,String lieming,String value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Put put = new Put(Bytes.toBytes(row));
        put.addColumn(Bytes.toBytes(liezu), Bytes.toBytes(lieming), Bytes.toBytes(value));
        table.put(put);
        table.close();
    }
    public static void getData(String tablename,String row,String liezu,String lieming) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Get get = new Get(Bytes.toBytes(row));
       // get.addFamily(Bytes.toBytes(liezu));  //列族
        get.addColumn(Bytes.toBytes(liezu),Bytes.toBytes(lieming));  //列组加列名
        Result result = table.get(get);
        for (Cell cell : result.rawCells()) {
            System.out.println(Bytes.toString(CellUtil.cloneFamily(cell))
            +"  "+Bytes.toString(CellUtil.cloneQualifier(cell))
            +"  "+Bytes.toString(CellUtil.cloneValue(cell)));
        }
        table.close();
    }
    public static void scanData(String tablename) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Scan scan = new Scan();
        scan.setMaxVersions(3);
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneRow(cell))+Bytes.toString(CellUtil.cloneFamily(cell))+"  "
                +Bytes.toString(CellUtil.cloneQualifier(cell))+"  "+Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
        table.close();
    }
    public static void deleteData(String tablename,String row,String liezu,String lieming) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tablename));
        Delete delete = new Delete(Bytes.toBytes(row));  //只设置列便删除一行，与deleteall相同
        delete.addColumn(Bytes.toBytes(liezu),Bytes.toBytes(lieming));   //删除最新的一个版本,下一个版本便会顶上 有问题慎用
       // delete.addColumns(Bytes.toBytes(liezu),Bytes.toBytes(lieming));     //删除所有版本与命令端delete作用一样
        table.delete(delete);
        table.close();
    }
    public static void main(String[] args) throws IOException {
        //putData("lianxi","01","info","name","xiaohong");
        //getData("student","01","info","name");
        //getData("student","02","info","name");
        //getData("student","03","info","name");
        //scanData("lianxi");
        deleteData("lianxi","01","info","name");
        close();
    }
}
