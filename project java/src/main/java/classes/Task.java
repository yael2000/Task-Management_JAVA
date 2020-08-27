package classes;

import java.util.Date;

public class Task {
    public int id;
    public String title;
    public String description;
    public Status status;
    public TeamMember BelongsTo;
    public Date startDate;
    public Date endDate;
    public int workDays;

    public Task(int id, String title, String description, Status status, TeamMember belongsTo, Date startDate, Date endDate, int workDays) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        BelongsTo = belongsTo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workDays = workDays;
    }

    public Task() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TeamMember getBelongsTo() {
        return BelongsTo;
    }

    public void setBelongsTo(TeamMember belongsTo) {
        BelongsTo = belongsTo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workHours) {
        this.workDays = workDays;
    }

@Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", BelongsTo=" + BelongsTo +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", workDays=" + workDays +
                '}';
    }
}
