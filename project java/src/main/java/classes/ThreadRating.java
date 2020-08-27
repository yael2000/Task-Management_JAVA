package classes;

import connectDB.FunctionSql;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadRating extends Thread{
    private Task task;
    private Status newStatus;
    FunctionSql sqlDB=new FunctionSql();
    public ThreadRating(Task task,Status newStatus) throws ParseException {
        this.task = task;
        this.newStatus=newStatus;
    }

    public void run(){
        if(newStatus==Status.Done) {
            Date start = task.getStartDate();
            Date end = task.getEndDate();
            long diffInMillies = Math.abs(end.getTime() - start.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);//כמה ימים בפועל
            int deviation = (int) (task.getWorkDays() - diff);
            System.out.println("befure updating the rating-> rating= "+((Implement) task.BelongsTo).getRating());
            int a=((Implement) task.BelongsTo).getRating();
            ((Implement) task.BelongsTo).setRating((int) (((Implement) task.BelongsTo).getRating()+deviation));
            System.out.println("after updating the rating-> rating= "+((Implement) task.BelongsTo).getRating());
            int b=((Implement) task.BelongsTo).getRating();
//            return "befure updating the rating-> rating= "+a+" after updating the rating-> rating= "+b;
        }

    }
    }

