package classes;

import connectDB.FunctionSql;

import java.text.ParseException;

public class ThreadStatus extends Thread {
    FunctionSql sqlDB=new FunctionSql();
    private int id;
    private  Status status;
    public ThreadStatus(int id, Status status) throws ParseException {
        this.id=id;
        this.status=status;
    }
    @Override
    public void run() {
        sqlDB.UpdateStatus(id, status);
    }
}
