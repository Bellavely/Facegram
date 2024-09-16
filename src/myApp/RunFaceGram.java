package myApp;
import java.util.Scanner;

import myApp.commands.CommandExecutor;

public class RunFaceGram {
    public static void main(String[] args) throws Exception {
        boolean flag = true; 
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\n");
        FaceGram faceTimeApp = new FaceGram();
        CommandExecutor execute = new CommandExecutor(faceTimeApp);

        System.out.println("Hi :)"); 
        System.out.println("FaceGram menu : ");
        System.out.println("create_user <userName> : creates a new user");
        System.out.println("post_message ‹user_id> ‹message>: Posts a new message for the user.");
        System.out.println("delete_message ‹user_id> <message_id>: Deletes a message by ID.");
        System.out.println("my_messages <userName>: Display my messages");
        System.out.println("edit_message ‹user_id› ‹message_id> <new_content>: Edits the content of a message.");
        System.out.println("like_message ‹user_id> ‹message_id>: Likes a message.");
        System.out.println("follow <user_id> <follow_user_id›: User starts following another user.");
        System.out.println("unfollow ‹user_id> «unfollow_user_id>: User stops following another user.");
       /* System.out.println("view_feed <user_id>: Displays the feed for a user.");
        System.out.println("trending_messages: Displays trending messages based on likes within the last hour.");*/
        System.out.println("exit : Exits the application");

        while (flag) {
            String command = in.next();
            if (command.equals("exit")){
                flag = false;
                System.out.println("Exiting ..");
            }
            else {
                execute.executeCommand(command);
            }
        }
    }
}
