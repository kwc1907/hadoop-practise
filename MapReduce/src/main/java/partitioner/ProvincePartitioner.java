package partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner extends Partitioner<Text,FlowBean> {

    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        String phone= text.toString();
        String str=phone.substring(0,3);
        int partition;
        if ("136".equals(str))
        {
            partition =0;
        }
        else if("137".equals(str))
        {
            partition=1;
        }
        else if("138".equals(str))
        {
            partition=2;
        }
        else if("139".equals(str))
        {
            partition=3;
        }
        else
            partition=4;
        return partition;
    }
}
