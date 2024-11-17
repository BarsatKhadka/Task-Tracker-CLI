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
               }
               else if(input.contains("update")){
                   String taskToUpdate = (input.substring(7));
                   updateTask(taskStore , taskToUpdate);
               }
               else if (input.contains("delete")){
                   deleteTask(taskStore , input);
               }
               else if(input.contains("mark-in-progress")){
                   markTask(taskStore , input);

               }
               else if(input.contains("mark-done")){
                   markTask(taskStore , input);
               }
               else if(input.contains("list todo")){
                   ListStatus(taskStore, input);
               }
               else if(input.contains("list done")){
                   ListStatus(taskStore, input);

               }
               else if(input.contains("list in-progress")){
                   ListStatus(taskStore, input);
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
               else if(input.contains("mark-")){
                   System.out.println("the format to "+ input.split(" ")[0]+ " is as below: \n task-cli " + input.split(" ")[0] + " 'ID you want to mark as progress' \n For more help type --h");
               }
               else if(input.contains("list")){
                   System.out.println("To display all contents of list.Type only 'list'.\n To look into tasks that are done 'Type list done'. \n To look into tasks that are in-progress 'Type list in-progress'");
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

    private static void deleteTask(TaskStore taskStore , String input) {
        String taskToDelete = (input.substring(7));
        int idToDelete = Integer.parseInt(taskToDelete.split(" ")[0]);
        taskStore.deleteTask(idToDelete);
    }

    private static void markTask(TaskStore taskStore , String taskToMark) {
        String[] markTypeAndDigit = (taskToMark.split(" "));
        taskStore.markTask(Integer.parseInt(markTypeAndDigit[1]), markTypeAndDigit[0]);

    }

    private static void displayList(TaskStore taskStore) {
        taskStore.showListJson();
    }

    private static void ListStatus(TaskStore taskStore , String listType) {
        String type = listType.substring(5);
        taskStore.listStatus(type);

    }

    }



