package org.TaskTracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class TaskOrganizer {
    public static void main(String[] args) {

        System.out.println("Welcome to task tracker. For help type '--h'");
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {

            System.out.print("task-cli ");
            input = scanner.nextLine();

            CheckTaskName checkTaskName = new CheckTaskName(input);
            boolean isCommand = checkTaskName.verifyValid();
            System.out.println(isCommand);



           if (input.equals("--h")) {
               System.out.println("This is the help page");
           }









        }
        }


    }



