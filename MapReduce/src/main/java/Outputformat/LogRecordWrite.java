package Outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class LogRecordWrite extends RecordWriter<Text, NullWritable> {

    private  FSDataOutputStream fsDataOutputStream1;
    private FSDataOutputStream fsDataOutputStream;

    public LogRecordWrite(TaskAttemptContext job){
        try {
            FileSystem fileSystem = FileSystem.get(job.getConfiguration());
            fsDataOutputStream1 = fileSystem.create(new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\l"));
            fsDataOutputStream = fileSystem.create(new Path("C:\\Users\\若久\\Desktop\\随缘记事本\\inputword\\ll"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
        String s=text.toString();
        if(s.contains("atguigu"))
        {
            fsDataOutputStream1.writeBytes(s+"\n");
        }
        else fsDataOutputStream.writeBytes(s+"\n");
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(fsDataOutputStream);
        IOUtils.closeStream(fsDataOutputStream1);
    }
}
