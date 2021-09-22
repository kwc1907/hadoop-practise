package review2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Propartitioner extends Partitioner<flowbeanComparable, Text> {

    @Override
    public int getPartition(flowbeanComparable flowbeanComparable, Text text, int i) {
        String s=text.toString();
        String str = s.substring(0, 3);
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
