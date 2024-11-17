package org.TaskTracker;

import com.google.gson.Gson;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskStore {

    public List<TaskClass> allTasks = new ArrayList<TaskClass>();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addTask(TaskClass task){
        allTasks.add(task);
        task.setUpdatedAt(LocalDateTime.now().format(formatter));
        System.out.println("Task added successfully ID(" + task.getId() + ")");
    }

    public void updateTask(int id , String description){
        boolean updatedTask = false;
        if(allTasks.isEmpty()){
            System.out.println("No tasks to update");
        }
        for(TaskClass taskClass : allTasks){
            if(taskClass.getId() == id){
                taskClass.setDescription(description);
                taskClass.setUpdatedAt(LocalDateTime.now().format(formatter));
                System.out.println("Task updated successfully ID(" + id + ")");
                updatedTask = true;
                break;
            }

        }
        if(!updatedTask ){
            System.out.println("Task with ID( " + id + ") not found." + " If you want too look up your tasks use 'list' command");
        }


    }

    public void deleteTask(int id){
        if(allTasks.isEmpty()){
            System.out.println("No tasks to delete");
            return;
        }
        boolean deletedTask = allTasks.removeIf(taskClass -> taskClass.getId() == id);

        if(!deletedTask){
            System.out.println("Task with ID( " + id + ") not found.");
        }

    }

    public void markTask(int id , String markType){
        boolean markedTask = false;
        if(allTasks.isEmpty()){
            System.out.println("No tasks to "+ markType);
        }
        for(TaskClass taskClass : allTasks){
            if(taskClass.getId() == id){
                taskClass.setStatus(markType.substring(5));
                taskClass.setUpdatedAt(LocalDateTime.now().format(formatter));
                markedTask = true;
                break;
            }
        }
        if(!markedTask){
            System.out.println("Task with ID( " + id + ") not found.");
        }
    }

    public void showListJson(){
        Gson gson = GsonProvider.getGson();
        String allTasksJson = gson.toJson(allTasks);
        System.out.println(allTasksJson);

    }

    public void listStatus(String listType){
        if (allTasks.isEmpty()){
            System.out.println("No tasks to list");
        }
            for(TaskClass taskClass : allTasks) {
                if (taskClass.getStatus().equals("done") & listType.contains("done")) {
                    List<TaskClass> doneTasks = allTasks.stream().filter(taskClass1 -> taskClass.getStatus().equals("done")).collect(Collectors.toList());
                    Gson gson = GsonProvider.getGson();
                    String doneTasksJson = gson.toJson(doneTasks);
                    System.out.println(doneTasksJson);

                } else if (taskClass.getStatus().equals("in-progress") & listType.contains("in-progress")) {
                    if (taskClass.getStatus().equals("in-progress")) {
                        List<TaskClass> inProgressTasks = allTasks.stream().filter(taskClass1 -> taskClass.getStatus().equals("in-progress")).collect(Collectors.toList());
                        Gson gson = GsonProvider.getGson();
                        String inProgressTasksJson = gson.toJson(inProgressTasks);
                        System.out.println(inProgressTasksJson);

                    }
                }
                else if (taskClass.getStatus().equals("todo") & listType.contains("todo")) {
                    if (taskClass.getStatus().equals("todo")) {
                        List<TaskClass> inProgressTasks = allTasks.stream().filter(taskClass1 -> taskClass.getStatus().equals("in-progress")).collect(Collectors.toList());
                        Gson gson = GsonProvider.getGson();
                        String inProgressTasksJson = gson.toJson(inProgressTasks);
                        System.out.println(inProgressTasksJson);

                    }
                }
            }
    }

}
