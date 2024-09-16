package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

public class CreateUser implements Command {
    private FaceGram app; 

    public CreateUser (FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String command) {
        try {
            app.createUser(command);
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }

    
}