package connectDB;
import classes.Implement;
import classes.Status;
import classes.Task;
import classes.TeamMember;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunctionSql {
   public FunctionSql() throws ParseException { }


    private static Connect con;
    ListsDB ListDB = new ListsDB();

    public static List<Task> getAllTasks() {
        List<Task> retval = new ArrayList<Task>();
        try {
            TeamMember member;
            con.connection = con.getConnection();
            if (con.connection != null) {
                System.out.println("Connection established!");
                con.rs = con.statement.executeQuery("select t.*, m.* from Task_tbl]t join TeamMember_tbl]m  on t.MemberId=m.id");
                while (con.rs.next()) {
                    int id = con.rs.getInt("TaskId");
                    String title = con.rs.getString("title");
                    String des = con.rs.getString("Description");
                    String statusStr = con.rs.getString("StatusId");
                    int hours = con.rs.getInt("WorkingHours");
                    Date start = con.rs.getDate("StartDate");
                    Date end = con.rs.getDate("EndData");
                    int mId = con.rs.getInt("id");
                    String name = con.rs.getString("Name");
                    String email = con.rs.getString("Email");
                    int rating = con.rs.getInt("Rating");
                    if ((int) rating == rating) {
                        member = new Implement(mId,name,email,rating);
                    } else member = new TeamMember(mId,name,email);
                    Status status = Status.valueOf(statusStr);
                    Task task = new Task(id, title, des, status, member, start, end, hours);
                    retval.add(task);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect faild!!!!!");
            retval = ListsDB.getTasksList();
        }
        return retval;
    }

    public static List<Task> getTasksByMembr(int MemId) {
        List<Task> retval = new ArrayList<Task>();

        try {
            TeamMember member;
            con.connection = Connect.getConnection();
            if (con.connection != null)
                System.out.println("Connection established!");
            con.rs = con.statement.executeQuery("select t.*, m.* from Task_tbl]t join TeamMember_tbl]m  on t.MemberId=m.id where [MemberId]=" + MemId);
            while (con.rs.next()) {
                int id = con.rs.getInt("TaskId");
                String title = con.rs.getString("title");
                String des = con.rs.getString("Description");
                String statusStr = con.rs.getString("StatusId");
                int hours = con.rs.getInt("WorkingHours");
                Date start = con.rs.getDate("StartDate");
                Date end = con.rs.getDate("EndData");
                int mId = con.rs.getInt("id");
                String name = con.rs.getString("Name");
                String email = con.rs.getString("Email");
                int rating = con.rs.getInt("Rating");
                if ((int) rating == rating) {
                    member = new Implement(mId,name,email,rating);
                } else member = new TeamMember(mId,name,email);
                Status status = Status.valueOf(statusStr);
                Task task = new Task(id, title, des, status, member, start, end, hours);
                retval.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect faild!!!!");
            List<Task> tasks = new ArrayList<>();
            tasks = ListsDB.getTasksList();
            for (Task t : tasks) {
                if (t.BelongsTo.getId() == MemId) {
                    retval.add(t);

                }
            }
        }
//        finally {
//           close(con);
//        }
        return retval;
    }

    public static void AddTask(Task task) {
        try {
            con.connection = Connect.getConnection();
            if (con.connection != null)
                System.out.println("Connection established!");
            String sql = "INSERT [dbo].[Task_tbl] ( [Description], [StatusId], [MemberId],[WorkingHours],[StartDate],[title]) \n" +
                    "VALUES (task.description,task.status,task.BelongsTo.getId(),task.workDays,task.startDate,task.title)";
            con.statement.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect faild!!!!!!!!!!!!!!!!!!!!!!!");
            List<Task> tasks = new ArrayList<Task>();
            tasks = ListsDB.getTasksList();
            tasks.add(task);
            ListsDB.setTasksList(tasks);
            System.out.println("Inserted records into the table...");
        }
    }

    public static void UpdateStatus(int taskId, Status status) {
        try {
            con.connection = Connect.getConnection();
            if (con.connection != null)
                System.out.println("Connection established!");
            int statId;
            switch (status){
                case New:statId=1;
                case InProgress:statId=2;
                case Done:statId=3;
            }
            String sql = "UPDATE Task_tbl SET StatusId =statId  WHERE TaskId=taskId ";
            con.statement.executeUpdate(sql);
            System.out.println("Update status succesfully...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect faild!!!!!!!!");
            List<Task> tasks = new ArrayList<Task>();
            tasks = ListsDB.getTasksList();
            for (Task t : tasks) {
                if (t.id == taskId) {
                    System.out.println("before updatind:" + t.getStatus());
                    t.setStatus(status);
                    ListsDB.setTasksList(tasks);
                    System.out.println("After updatind:" + t.getStatus());
                    System.out.println("Update status succesfully...");
                    return;
                }
            }
           System.out.println("oops! error ");
        }
    }

    public static List<TeamMember> getTeamMembers() {
        List<TeamMember> retval = new ArrayList<TeamMember>();
        try {
            con.connection = Connect.getConnection();
            if (con.connection != null) {
                System.out.println("Connection established!");
                con.rs = con.statement.executeQuery("select * from TeamMember_tbl");
                while (con.rs.next()) {
                    int id = con.rs.getInt("id");
                    String name = con.rs.getString("Name");
                    String email = con.rs.getString("Email");
                    int rating = con.rs.getInt("Rating");
                    TeamMember menber;
                    if (rating == 0)
                        menber = new TeamMember(id, name, email);
                    else
                        menber = new Implement(id, name, email, rating);
                    retval.add(menber);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect faild!!!!!!!!!!!!!!!!!!!!!!!");
            retval = ListsDB.getMembersList();
        }
        return retval;
    }

    public static TeamMember findMember(int id) {
        List<TeamMember> members = new ArrayList<TeamMember>();
        members = ListsDB.getMembersList();
        for (TeamMember member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }


    public static void close(Connect con) {
        if (con.rs != null) {
            try {
                con.rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (con.statement != null) {
            try {
                con.statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (con.connection != null) {
            try {
                con.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

