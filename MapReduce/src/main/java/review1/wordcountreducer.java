package review1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class wordcountreducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    private IntWritable out =new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for(IntWritable i:values)
        {
            sum+= i.get();
        }
        out.set(sum);
        context.write(key,out);
    }
}
