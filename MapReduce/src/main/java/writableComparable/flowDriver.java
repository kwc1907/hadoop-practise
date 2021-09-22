package writableComparable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class flowDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration=new Configuration();
        Job job=Job.getInstance(configuration);
        job.setJarByClass(flowDriver.class);
        job.setMapperClass(flowMapper.class);
        job.setReducerClass(flowReducer.class);
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\lll\\part-r-00000"));
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\llll"));
        boolean b=job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
