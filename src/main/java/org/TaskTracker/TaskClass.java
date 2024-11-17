package org.TaskTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskClass {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static int idCounter = 1;
    private int id;
    private String description;
    private String status;
    private final String  createdAt;
    private String updatedAt = "None";



    public TaskClass(String description) {
        this.id = idCounter++;
        this.description = description;
        this.status = "todo";
        this.createdAt  = LocalDateTime.now().format(formatter);;
        this.updatedAt = updatedAt;
    }



    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){ return status; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toString(){
        String toString = "{ id:" + id + ", description:" + description + ", status:" + status + "CreatedAt" + createdAt +"}";
        return toString;
    }

}
