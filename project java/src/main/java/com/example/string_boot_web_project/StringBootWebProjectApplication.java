package com.example.string_boot_web_project;

import classes.*;

import connectDB.FunctionSql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.*;


@SpringBootApplication
@RestController()
@RequestMapping(path="rest")
public class StringBootWebProjectApplication {
FunctionSql sqlDB=new FunctionSql();

    public StringBootWebProjectApplication() throws ParseException {
    }

    public static void main(String[] args) {
        SpringApplication.run(StringBootWebProjectApplication.class, args);
    }

    @GetMapping("/getMemberTasks/{memId}")
    public List<Task> getMemberTasks(@PathVariable( value = "memId") int memId){
        List<Task> tasks=new ArrayList<>() ;
        tasks=sqlDB.getTasksByMembr(memId);
        return tasks;
    }
    @GetMapping("/getMembersSort")
    public List<TeamMember> getTeamMembers(){
        List<TeamMember> memberList=new ArrayList<TeamMember>() ;
//        List<String> membersNameEmail=new ArrayList<String>();
        memberList=sqlDB.getTeamMembers();
//        for(TeamMember member:memberList){
//            membersNameEmail.add(member.toString());
//        }
        Collections.sort(memberList,TeamMember.NameComparator);
        return memberList;
    }


    @GetMapping("/checkMembereExist/{memName}/{memEmail}")
    public String checkMembereExist(@PathVariable( value = "memName") String name,@PathVariable(value = "memEmail")String email) {
        List<TeamMember> memberList = new ArrayList<>();
        Map<String, String> memberMap = new HashMap<>();
        memberList = sqlDB.getTeamMembers();
        for (TeamMember member : memberList) {
            memberMap.put(member.getName(), member.getEmail());
        }
        if (memberMap.containsKey(name))
            if (Objects.equals(memberMap.get(name),email)) {
                return "User "+name+" exist ";
            }
        return "User"+name+" does not exist";
    }

    @GetMapping("/updateStatus/{taskId}/{status}")
    public String updateStatus(@PathVariable( value = "taskId") int id,@PathVariable(value = "status")String statusStr) throws ParseException, InterruptedException {
        List<Task>taskList=new ArrayList<>();
        int a,b;
        taskList = sqlDB.getAllTasks();
        Task task=new Task();
        Status status = Status.valueOf(statusStr);
        for(Task t :taskList) {
            if(t.getId()==id){
                task=t;
            }
        }
        ThreadRating threadRating=new ThreadRating(task,status);
        ThreadStatus threadStatus=new ThreadStatus(id,status);
        threadStatus.start();
        if(task.BelongsTo.getClass()==Implement.class){
             a=((Implement) task.BelongsTo).getRating();
            threadRating.start();
        }
        else{
            return "this member isn't inplement!!";
        }
        threadRating.join();
         b=((Implement) task.BelongsTo).getRating();
        return "befure updating the rating-> rating= "+a+" after updating the rating-> rating= "+b;
    }

}
