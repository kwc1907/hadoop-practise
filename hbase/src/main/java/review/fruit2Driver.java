package review;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class fruit2Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(fruit2Driver.class);
        TableMapReduceUtil.initTableMapperJob(args[0],new Scan(),fruit2Mapper.class, ImmutableBytesWritable.class,
                Put.class,job);
        TableMapReduceUtil.initTableReducerJob(args[1],fruit2Reducer.class,job);
        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
