package writableComparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class flowMapper extends Mapper<LongWritable, Text,FlowBean,Text> {
    private Text text = new Text();
    private FlowBean flowBean=new FlowBean();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        String phone = split[0];
        String up=split[1];
        String down = split[2];
        text.set(phone);
        flowBean.setUpflow(Long.parseLong(up));
        flowBean.setDownflow(Long.parseLong(down));
        flowBean.setSumflow();
        context.write(flowBean,text);
    }
}
