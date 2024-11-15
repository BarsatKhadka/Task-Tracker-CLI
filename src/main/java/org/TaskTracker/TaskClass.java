package org.TaskTracker;

import java.time.LocalDateTime;

public class TaskClass {
    public static int idCounter = 1;
    private int id;
    private String description;
    private String status;

    public TaskClass(String description) {
        this.id = idCounter++;
        this.description = description;
        this.status = "todo";
    }

    public int getId() {
        return id;
    }

    public void setStatus(int id, String status) {
        this.status = status;
    }

    public String toString(){
        String toString = "{ id:" + id + ", description:" + description + ", status:" + status + " }";
        return toString;
    }

}
