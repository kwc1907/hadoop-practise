package review2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class flowReducer extends Reducer<flowbeanComparable, Text,Text,flowbeanComparable> {
    @Override
    protected void reduce(flowbeanComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for(Text i:values)
        {
            context.write(i,key);
        }
    }
}
