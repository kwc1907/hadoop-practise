package review2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class flowbeanComparable implements WritableComparable<flowbeanComparable> {

    private long upflow;
    private long downflow;
    private long sumflow;

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
        this.sumflow = this.downflow+this.upflow;
    }


    public flowbeanComparable() {
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upflow);
        dataOutput.writeLong(downflow);
        dataOutput.writeLong(sumflow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
                this.upflow=dataInput.readLong();
                this.downflow=dataInput.readLong();
                this.sumflow=dataInput.readLong();
    }

    @Override
    public String toString() {
        return upflow+"\t"+downflow+"\t"+sumflow;
    }

    @Override
    public int compareTo(flowbeanComparable o) {
        if(this.sumflow>o.sumflow)
            return -1;
        else if(this.sumflow<o.sumflow)
            return 1;
        else
        {
            if (this.upflow < o.upflow)
                return 1;
            else if (this.upflow > o.upflow)
                return -1;
            else
            {
                if(this.downflow>o.downflow)
                    return -1;
                else if(this.downflow<o.downflow)
                    return 1;
                else return 0;
            }
        }
    }
}
