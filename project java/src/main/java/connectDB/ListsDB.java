package connectDB;

import classes.Implement;
import classes.Status;
import classes.Task;
import classes.TeamMember;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ListsDB {
    public static List<Task> tasksList = new ArrayList<Task>();
    public static List<TeamMember> membersList = new ArrayList<TeamMember>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public ListsDB() throws ParseException {
        TeamMember m1 = new TeamMember(100, "     Yael   ", "yael@gmail.com");
        TeamMember m2 = new TeamMember(101, "Sara", "sara@gmail.com");
        TeamMember m3 = new Implement(102, "Eli", "eli@gmail.com",5);
        TeamMember m4 = new TeamMember(103, "Beni", "beni@gmail.com");
        TeamMember m5 = new Implement(104, "Dani", "dani@gmail.com",3);
        membersList.add(m1);
        membersList.add(m2);
        membersList.add(m3);
        membersList.add(m4);
        membersList.add(m5);
        Task t1 = new Task(1, "title1", "it's description of the task1", Status.New, m1, dateFormat.parse("01-08-2020"), dateFormat.parse("12-08-2020"), 10);
        Task t2 = new Task(2, "title2", "it's description of the task2", Status.New, m3, dateFormat.parse("15-07-2020"),dateFormat.parse("12-08-2020"), 25);
        Task t3 = new Task(3, "title3", "it's description of the task3", Status.Done, m4,dateFormat.parse("01-05-2020"), dateFormat.parse("08-05-2020"), 8);
        Task t4 = new Task(4, "title4", "it's description of the task4", Status.New, m2, dateFormat.parse("10-08-2020"),dateFormat.parse("10-09-2020"), 30);
        Task t5 = new Task(5, "title5", "it's description of the task5", Status.InProgress, m1, dateFormat.parse("01-08-2020"),dateFormat.parse("12-08-2020"), 17);
        Task t6 = new Task(6, "title6", "it's description of the task6", Status.Done, m5,dateFormat.parse("30-04-2020"),dateFormat.parse("05-06-2020"), 36);
        Task t7 = new Task(7, "title7", "it's description of the task7", Status.InProgress, m3, dateFormat.parse("05-08-2020"), dateFormat.parse("25-08-2020"), 15);
        Task t8 = new Task(8, "title8", "it's description of the task8", Status.InProgress, m3,dateFormat.parse("03-08-2020"), dateFormat.parse("12-08-2020"), 10);
        tasksList.add(t1);
        tasksList.add(t2);
        tasksList.add(t3);
        tasksList.add(t4);
        tasksList.add(t5);
        tasksList.add(t6);
        tasksList.add(t7);
        tasksList.add(t8);
    }

    public static List<Task> getTasksList() {
        return tasksList;
    }

    public static void setTasksList(List<Task> tasksList) {
        ListsDB.tasksList = tasksList;
    }

    public static List<TeamMember> getMembersList() {
        return membersList;
    }

    public static void setMembersList(List<TeamMember> membersList) {
        ListsDB.membersList = membersList;
    }
}
