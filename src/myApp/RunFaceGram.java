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
        System.out.println("-create_user <userName> : creates a new user");
        System.out.println("-myMessages <userName>: Display my messages");
        System.out.println("-exit : Exits the application");

        while (flag) {
            String command = in.next();
            if (command.equals("exit")){
                flag = false;
            }
            else {
                execute.executeCommand(command);
            }
        }
    }
}
