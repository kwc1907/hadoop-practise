package reducejoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class TableReducer extends Reducer<Text,TableBean, TableBean,NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Context context) throws IOException, InterruptedException {
        ArrayList<TableBean> order = new ArrayList<TableBean>();
        ArrayList<TableBean> pd = new ArrayList<TableBean>();
        for (TableBean i : values)
        {
            TableBean t =new TableBean();
            try {
                BeanUtils.copyProperties(t,i);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if(i.getFlag().contains("order"))
                order.add(t);
            else pd.add(t);
        }
        for(TableBean i:order)
        {
            i.setName(pd.get(0).getName());
            context.write(i,NullWritable.get());
        }
    }
}
