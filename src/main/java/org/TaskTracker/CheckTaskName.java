package org.TaskTracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckTaskName {
    ArrayList<String> allCommands = new ArrayList<>(Arrays.asList("add", "update" , "delete",
            "list", "mark-in-progress", "mark-done"));

    String user_command = "";


    public CheckTaskName(){

    }

    public CheckTaskName(String user_command) {
        this.user_command = user_command;

    }

    public boolean verifyValid() {
        for (String command : allCommands) {
            String regex = "^" + command + " .+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(user_command);
            if (matcher.matches() == true){
                return true;
            }
        }
        return false;
    }

}
