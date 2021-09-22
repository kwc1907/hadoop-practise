package Outputformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, NullWritable,Text,NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for(NullWritable n:values)
        context.write(key,NullWritable.get());
    }
}
