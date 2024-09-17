package myApp.commands;

import myApp.FaceGram;

public class LikeCommand implements Command {
    private FaceGram faceGram;

    public LikeCommand(FaceGram app) {
        faceGram = app; 
    }

    @Override
    public void execute(String params) {
        String []vals = params.split(" ",2);
        faceGram.likeMessage(vals[0],Integer.parseInt(vals[1]));  
    }
}
