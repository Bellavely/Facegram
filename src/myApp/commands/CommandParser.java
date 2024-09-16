package myApp.commands;

/**
 * CommandParser
 */
public class CommandParser {
    private String [] commandValues;

    public void parse (String command){
        commandValues = command.split(" ", 2);
    }

    public String getCommand (){
        return commandValues[0];
    }

    public String getVals(){
        return commandValues[1];
    }
}