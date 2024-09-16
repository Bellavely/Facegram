package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

public class UnfollowCommand implements Command{
    private FaceGram app;

    public UnfollowCommand(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String params) {
        String [] vals = params.split(" ",2);
        try {
            app.unFollowUser(vals[0], vals[1]);
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }
    
}
