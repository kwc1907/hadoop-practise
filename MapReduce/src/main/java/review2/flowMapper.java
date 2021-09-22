package review2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class flowMapper extends Mapper<LongWritable,Text,flowbeanComparable,Text> {
    private flowbeanComparable k = new flowbeanComparable();
    private Text t = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s= value.toString();
        String[] split = s.split("\t");
        k.setUpflow(Long.parseLong(split[1]));
        k.setDownflow(Long.parseLong(split[2]));
        k.setSumflow();
        t.set(split[0]);
        context.write(k,t);
    }
}
