package org.TaskTracker;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
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

           if (input.equals("--h")) {
               System.out.println("This is the help page");
           }

           if(isCommand) {
               if(input.contains("add")) {
                   String taskToAdd = (input.substring(4, input.length()));
                   addTask(taskStore , taskToAdd);
               }
               else if(input.contains("update")){
                   String taskToUpdate = (input.substring(7, input.length()));
                   taskStore.updateTask();
               }

           }
           else {
               System.out.println("the format is as below: \n task-cli 'command' 'action' \n For more help type '--h'");
           }
        }

    }

    private static void addTask(TaskStore taskStore , String taskToadd) {
        TaskClass taskClass = new TaskClass(taskToadd);
        taskStore.addTask(taskClass);
        System.out.println("Task added successfully ID(" + taskClass.getId() + ")");
    }








    }



