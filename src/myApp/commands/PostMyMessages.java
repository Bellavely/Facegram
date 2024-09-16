package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

public class PostMyMessages implements Command {
    private FaceGram app; 

    public PostMyMessages(FaceGram faceGram){
        app = faceGram; 
    }

    @Override
    public void execute(String command) {
        try {
            app.myMessages(command);
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }

}
