package writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class flowReducer extends Reducer<Text,FlowBean,Text,FlowBean> {
    private FlowBean flowBean = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        Long up=0l,down=0l;
        for(FlowBean f:values)
        {
            up+=f.getUpflow();
            down+=f.getDownflow();
        }
        flowBean.setUpflow(up);
        flowBean.setDownflow(down);
        flowBean.setSumflow();
        context.write(key,flowBean);
    }
}
