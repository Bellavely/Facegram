package myApp.commands;

import myApp.FaceGram;

public class CreateUser implements Command {
    private FaceGram app; 

    public CreateUser (FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String command) {
        app.createUser(command); 
    }

    
}