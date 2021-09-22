package review1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class wordcountmapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    private Text t=new Text();
    private IntWritable i=new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String v = value.toString();
        String[] sa = v.split(" ");
        for(String s:sa)
        {
            t.set(s);
            context.write(t,i);
        }
    }
}
