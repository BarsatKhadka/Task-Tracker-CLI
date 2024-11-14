package org.TaskTracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskOrganizer {
    public static void main(String[] args) {

        ArrayList<String> possible_inputs = new ArrayList<>(Arrays.asList("add", "update" , "delete", "list", "mark-in-progress", "mark-done"));


        System.out.println("Welcome to task tracker. For help type '--h'");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("task-cli ");
            input = scanner.next();
            if (possible_inputs.contains("--h")) {
                System.out.println("This is the help message. ");
            } else if (possible_inputs.contains(input)) {
                System.out.println("Command can't be empty. Write " + input + " ");





            } else if (input.equals("update")) {

                
            }else if(input.equals("delete")) {}
            else if(input.equals("list")) {}
            else if(input.equals("mark-in-progress")) {}
            else if(input.equals("mark-done")) {}
        }

    }
}
