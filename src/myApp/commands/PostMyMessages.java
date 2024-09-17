package myApp.commands;

import myApp.FaceGram;

public class PostMyMessages implements Command {
    private FaceGram app; 

    public PostMyMessages(FaceGram faceGram){
        app = faceGram; 
    }

    @Override
    public void execute(String command) {
        app.myMessages(command);
    }

}
