package org.TaskTracker;

import com.google.gson.Gson;
import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {

        Gson gson = new Gson();
        TaskStore taskStore = new TaskStore();

        System.out.println("Welcome to task tracker. For help type '--h'");
        Scanner scanner = new Scanner(System.in);
        String input;



        while (true) {

            System.out.print("task-cli ");
            input = scanner.nextLine();

            CheckTaskName checkTaskName = new CheckTaskName(input);
            boolean isCommand = checkTaskName.verifyValid();

           if (input.equals("--h")) {  System.out.println("This is the help page");  }

           if(isCommand) {
               if(input.contains("add")) {
                   String taskToAdd = (input.substring(4));
                   addTask(taskStore , taskToAdd);
                   System.out.println(gson.toJson(taskStore));
               }
               else if(input.contains("update")){
                   String taskToUpdate = (input.substring(7));
                   updateTask(taskStore , taskToUpdate);
                   System.out.println(gson.toJson(taskStore));
               }
               else if (input.contains("delete")){
                   String taskToDelete = (input.substring(7));
                   deleteTask(taskStore , taskToDelete);
                   System.out.println(gson.toJson(taskStore));

               }

           }
           else {
               if(input.contains("update")){
                   System.out.println("the format for update is as below: \n task-cli 'update' 'ID you want to update' 'description' \n For"+
                           " more help type '--h'");
               }
               else if(input.contains("delete")){
                   System.out.println("the format for delete is as below: \n task-cli 'delete' 'ID you want to delete' \n For"+ " more help type --h");
               }
               else {
                   System.out.println("the format is as below: \n task-cli 'command' 'action' \n For more help type '--h'");
               }
           }
        }

    }


    private static void addTask(TaskStore taskStore , String taskToadd) {
        TaskClass taskClass = new TaskClass(taskToadd);
        taskStore.addTask(taskClass);
    }

    private static void updateTask(TaskStore taskStore , String taskToupdate) {
        int idToUpdate = Integer.parseInt(taskToupdate.split(" ")[0]);
        String descriptionToUpdate = taskToupdate.split(" ")[1];
        taskStore.updateTask(idToUpdate, descriptionToUpdate);
    }

    private static void deleteTask(TaskStore taskStore , String taskTodelete) {
        int idToDelete = Integer.parseInt(taskTodelete.split(" ")[0]);
        taskStore.deleteTask(idToDelete);
    }

    }



