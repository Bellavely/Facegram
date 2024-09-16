package myApp.commands;

import java.util.HashMap;

import myApp.FaceGram;

public class CommandExecutor {
    private HashMap<String,Command> commands;
    private CommandParser parse; 

    public CommandExecutor(FaceGram app){
        commands = new HashMap<>();
        parse = new CommandParser();
        commands.put("create_user", new CreateUser(app));
        commands.put("post_message", new PostMessage(app));
        commands.put("my_messages", new PostMyMessages(app));
    }

    public void executeCommand(String commandcli){
        parse.parse(commandcli);
        Command command  = commands.get(parse.getCommand());
        if (command == null){
            System.out.println("cant find this command");
        }else {
            command.execute(parse.getVals());
        }
    }

}
