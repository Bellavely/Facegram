package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

/**
 * FollowCommand
 */
public class FollowCommand implements Command {
    private FaceGram app; 
    public FollowCommand(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String params) {
        String []vals = params.split(" ",2);
        try {
            app.addFollower(vals[0], vals[1]);
            System.out.println(vals[0] + " follows "+ vals[1]);
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }

}