package Mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
        Configuration configuration=new Configuration();
        Job job=Job.getInstance(configuration);
        job.setJarByClass(Driver .class);
        job.setMapperClass(MapjoinMapper.class);
        job.setMapOutputKeyClass(Text .class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text .class);
        job.setOutputValueClass(NullWritable.class);
        job.setNumReduceTasks(0);
        job.addCacheFile(new URI("file:///C:/Users/若久/Desktop/随缘记事本/inputword/inputtable/pd.txt"));
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\inputtable\\order.txt"));
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\inputtable\\ll"));
        boolean b=job.waitForCompletion(true);
        System.exit(b?0:1);
    }

}
