package org.TaskTracker;

import java.time.LocalDateTime;

public class TaskClass {
    private int id;
    private String description;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskClass(int id, String description, boolean status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
}
