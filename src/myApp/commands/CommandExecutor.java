package myApp.commands;

import java.util.HashMap;

import myApp.FaceGram;

public class CommandExecutor {
    private HashMap<String,Command> commands;
    private CommandParser parse; 

    public CommandExecutor(FaceGram app){
        commands = new HashMap<>();
        parse = new CommandParser();
        initializeCommands(app);
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

    private void initializeCommands(FaceGram app){
        commands.put("create_user", new CreateUser(app));
        commands.put("post_message", new PostMessage(app));
        commands.put("edit_message", new EditMessage(app));
        commands.put("view_feed", new ViewFeedCommand(app));
        commands.put("like_message", new LikeCommand(app));
        commands.put("delete_message", new DeleteMessage(app));
        commands.put("follow", new FollowCommand(app));
        commands.put("unfollow", new UnfollowCommand(app));
        commands.put("my_messages", new PostMyMessages(app));
        commands.put("trending_messages", new TrendMessCommand(app));
    }
}
