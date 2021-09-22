package reducejoin;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TableBean implements Writable {
    public TableBean(){

    }
    private String id;
    private String pid;
    private int amount;
    private String name;
    private String flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(id);
        dataOutput.writeUTF(pid);
        dataOutput.writeUTF(flag);
        dataOutput.writeUTF(name);
        dataOutput.writeInt(amount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
            id = dataInput.readUTF();
            pid = dataInput.readUTF();
            flag = dataInput.readUTF();
            name = dataInput.readUTF();
            amount = dataInput.readInt();
    }

    @Override
    public String toString() {
        return id+"\t"+name+"\t"+amount;
    }
}
