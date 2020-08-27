package connectDB;


import classes.Implement;
import classes.Status;
import classes.Task;
import classes.TeamMember;

import javax.lang.model.type.NullType;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        FunctionSql functionSql = new FunctionSql();
        List<Task> taskList = new ArrayList<Task>();
        List<TeamMember> memberList =new ArrayList<TeamMember>();
/*************Get All Tasks****************/
//        taskList = functionSql.getAllTasks();
//        for (Task t : taskList) {
//            System.out.println(t.toString());
//        }
/*************Get Task By Member Id****************/
//System.out.println("enter member id to get his tasks:");
//String memId=scan.next();
//        taskList = functionSql.getTasksByMembr(Integer.parseInt(memId));
//        for (Task t : taskList) {
//            System.out.println(t.toString());
//        }
/*************Add New Task****************/

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        System.out.println("enter task id");
//        String id = scan.nextLine();
//        System.out.println("enter task title");
//        String title = scan.nextLine();
//        System.out.println("enter task description");
//        String description = scan.nextLine();
//        System.out.println("enter task memberId:");
//        String memberId = scan.nextLine();
//        System.out.println("enter task start date in format: dd-MM-yyyy:");
//        String startDate = scan.nextLine();
//        System.out.println("enter task end date  in format: dd-MM-yyyy:");
//        String endDate = scan.nextLine();
//        System.out.println("enter task work Days:");
//        String workDays = scan.nextLine();
//        TeamMember member = functionSql.findMember(Integer.parseInt(memberId));
//        try{
//            Date sdate=dateFormat.parse(startDate);
//            Date edate=dateFormat.parse(endDate);
//            if (member != null){
//                Task newTask = new Task(Integer.parseInt(id), title, description, Status.New, member, sdate, edate, Integer.parseInt(workDays));
//                functionSql.AddTask(newTask);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        taskList = functionSql.getTasksByMembr(Integer.parseInt(memberId));
//        for (Task t : taskList) {
//            System.out.println(t.toString());
//        }
/*************Update Task's Status ****************/
//System.out.println("enter task id to update the status:");
//int taskId=Integer.parseInt(scan.next());
//        System.out.println("enter the new status- InProgress or Done:");
//        String statusStr=scan.next();
//        Status status = Status.valueOf(statusStr);
//        System.out.println(status);
//        functionSql.UpdateStatus(taskId,status);
///*************Get All Members ****************/
        memberList = functionSql.getTeamMembers();
        for (TeamMember m : memberList) {
            System.out.println(m.toString());
        }

  }
}

