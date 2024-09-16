package myApp.commands;

import java.util.ArrayList;
import java.util.Collection;

import myApp.FaceGram;
import myApp.FaceGramError;
import myApp.models.Message;

public class LikeCommand implements Command {
    private FaceGram faceGram;

    public LikeCommand(FaceGram app) {
        faceGram = app; 
    }

    @Override
    public void execute(String params) {
        try {
            ArrayList<Message> feed = faceGram.getUserFeed(params);
            for(Message message : feed){
                System.out.println(message);
            }
            
            
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }

    

}
