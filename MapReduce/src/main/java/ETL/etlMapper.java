package ETL;

import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class etlMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s= value.toString();
        boolean result = parseLog(s,context);
        if(!result)
        {
            return;
        }
        context.write(value, NullWritable.get());
    }
    private boolean parseLog(String s,Context context)
    {
        String[] split = s.split(" ");
        if(split.length>11)
            return true;
        else return false;
    }
}
