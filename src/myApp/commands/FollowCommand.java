package myApp.commands;

import myApp.FaceGram;

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
        app.addFollower(vals[0], vals[1]);
    }

}