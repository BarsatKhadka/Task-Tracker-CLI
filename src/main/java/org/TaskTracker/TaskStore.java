package org.TaskTracker;

import java.util.ArrayList;
import java.util.List;

public class TaskStore {

    List<TaskClass> allTasks = new ArrayList<TaskClass>();

    public void addTask(TaskClass task){
        allTasks.add(task);
    }


    public List<TaskClass> getAllTasks() {
        return allTasks;
    }




}
