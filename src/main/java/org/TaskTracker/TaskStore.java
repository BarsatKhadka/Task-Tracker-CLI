package org.TaskTracker;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TaskStore {

    public List<TaskClass> allTasks = new ArrayList<TaskClass>();



    public void addTask(TaskClass task){
        allTasks.add(task);
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
                markedTask = true;
                break;
            }
        }
        if(!markedTask){
            System.out.println("Task with ID( " + id + ") not found.");
        }
    }

    public void showListJson(){
        System.out.println("all tasks");
    }












}
