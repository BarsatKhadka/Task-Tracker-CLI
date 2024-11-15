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
                   TaskClass taskClass = new TaskClass(taskToAdd);
                   taskStore.addTask(taskClass);
               }

           }
           else {
               System.out.println("the format is as below: \n task-cli 'command' 'action' \n For more help type '--h'");
           }


           











        }

        }

    }


