package Outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration=new Configuration();
        Job job=Job.getInstance(configuration);
        job.setJarByClass(Driver .class);
        job.setMapperClass(LogMapper .class);
        job.setReducerClass(Reducer .class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setOutputFormatClass(OutputFormat.class);
        FileInputFormat.setInputPaths(job,new Path("D:\\Hadoop\\资料\\11_input\\inputoutputformat\\log.txt"));
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\lll"));
        boolean b=job.waitForCompletion(true);
        System.exit(b?0:1);
    }

}
