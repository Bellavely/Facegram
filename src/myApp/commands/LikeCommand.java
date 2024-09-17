package myApp.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
            
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());  
      }
    }


}
