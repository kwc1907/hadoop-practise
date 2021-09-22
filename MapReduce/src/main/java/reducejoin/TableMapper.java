package reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text,Text,TableBean> {
    private String filename;
    private Text text =new Text();
    private TableBean tableBean=new TableBean();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit split= (FileSplit) context.getInputSplit();
        filename = split.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s=value.toString();
        String[] split = s.split("\t");
        if(filename.contains("order"))
        {
            text.set(split[1]);
            tableBean.setFlag(filename);
            tableBean.setAmount(Integer.parseInt(split[2]));
            tableBean.setId(split[0]);
            tableBean.setName("");
            tableBean.setPid(split[1]);
        }
        else
        {
            text.set(split[0]);
            tableBean.setId("");
            tableBean.setPid(split[0]);
            tableBean.setFlag(filename);
            tableBean.setName(split[1]);
            tableBean.setAmount(0);
        }
        context.write(text,tableBean);
    }
}
