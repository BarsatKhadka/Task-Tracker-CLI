package org.TaskTracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckTaskName {
    ArrayList<String> allCommands = new ArrayList<>(Arrays.asList("add", "update" , "delete",
            "list", "mark-in-progress", "mark-done" , "list done" , "list in-progress"));




    String user_command = "";


    public CheckTaskName(){

    }

    public CheckTaskName(String user_command) {
        this.user_command = user_command;

    }

    public boolean verifyValid() {
        for (String command : allCommands) {
            if (command.equals("update")) {
                String regex = "^" + "update" + " " + "(\\d+)" + " .+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(user_command);
                if (matcher.matches()) {
                    return true;
                }
            }
            else if(command.equals("delete") || command.equals("mark-in-progress") || command.equals("mark-done")) {
                String regex = "^" + "delete" + " " + "(\\d+)" + "\\s*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(user_command);
                if (matcher.matches()) {
                    return true;
                }
            }
            else if(command.equals("list") || command.equals("list done") || command.equals("list in-progress")) {
                String regex = "^" + command + "\\s*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(user_command);
                if (matcher.matches()) {
                    return true;
                }
            }
            else if(command.equals("add")) {
                String regex = "^" + command + " .+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(user_command);
                if (matcher.matches()) {
                    return true;
                }
            }


        }
        return false;
    }

}
