package hbaseMR;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(Driver.class);
        job.setMapperClass(FruitMapper.class);
        job.setMapOutputValueClass(Text.class);
        job.setMapOutputKeyClass(LongWritable.class);
        TableMapReduceUtil.initTableReducerJob(args[1],FruitReducer.class,job);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0:1);
    }
}
