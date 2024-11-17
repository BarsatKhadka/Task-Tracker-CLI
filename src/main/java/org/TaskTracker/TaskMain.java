package org.TaskTracker;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskMain {
    public static void main(String[] args) {

        Gson gson = GsonProvider.getGson();
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
               else if(input.contains("mark-in-progress")){
                   String tasktoMark = input;
                   markTask(taskStore , tasktoMark);
                   System.out.println(gson.toJson(taskStore));

               }
               else if(input.contains("mark-done")){
                   String tasktoMark = input;
                   markTask(taskStore , tasktoMark);
                   System.out.println(gson.toJson(taskStore));
               }
               else if(input.contains("list")){
                   displayList(taskStore);
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
               else if(input.contains("mark-in-progress")){
                   System.out.println("the format to mark-in-progress is as below: \n task-cli 'mark-in-progress' 'ID you want to mark as progress' \n For more help type --h");
               }
               else if(input.contains("list")){
                   System.out.println("No other arguments with list. Only 'list'.");
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
        List<String> taskToupdateArray = Arrays.asList(taskToupdate.split(" "));
        int idToUpdate = Integer.parseInt(taskToupdateArray.get(0));
        String descriptionToUpdate = taskToupdateArray.stream().skip(1).collect(Collectors.joining(" "));
        taskStore.updateTask(idToUpdate, descriptionToUpdate);

    }

    private static void deleteTask(TaskStore taskStore , String taskTodelete) {
        int idToDelete = Integer.parseInt(taskTodelete.split(" ")[0]);
        taskStore.deleteTask(idToDelete);
    }

    private static void markTask(TaskStore taskStore , String taskToMark) {
        String[] markTypeAndDigit = (taskToMark.split(" "));
        taskStore.markTask(Integer.parseInt(markTypeAndDigit[1]), markTypeAndDigit[0]);

    }

    private static void displayList(TaskStore taskStore) {
        taskStore.showListJson();
    }

    }



