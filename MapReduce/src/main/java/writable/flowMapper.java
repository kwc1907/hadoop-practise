package writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class flowMapper extends Mapper<LongWritable, Text,Text,FlowBean> {
    private Text text = new Text();
    private FlowBean flowBean=new FlowBean();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        String phone = split[1];
        String up=split[split.length-3];
        String down = split[split.length-2];
        text.set(phone);
        flowBean.setUpflow(Long.parseLong(up));
        flowBean.setDownflow(Long.parseLong(down));
        flowBean.setSumflow();
        context.write(text,flowBean);
    }
}
