package partitioner;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements Writable {
    private long upflow;
    private long downflow;
    private long sumflow;
    //空参构造
    public FlowBean() {
    }
    public long getUpflow() {
        return upflow;
    }

    public void setUpflow(long upflow) {
        this.upflow = upflow;
    }

    public long getDownflow() {
        return downflow;
    }

    public void setDownflow(long downflow) {
        this.downflow = downflow;
    }

    public long getSumflow() {
        return sumflow;
    }

    public void setSumflow() {
        this.sumflow = downflow+upflow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upflow);
        dataOutput.writeLong(downflow);
        dataOutput.writeLong(sumflow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upflow = dataInput.readLong();
        this.downflow = dataInput.readLong();
        this.sumflow = dataInput.readLong();
    }

    @Override
    public String toString() {
        return upflow+"\t"+downflow+"\t"+sumflow;
    }
}
