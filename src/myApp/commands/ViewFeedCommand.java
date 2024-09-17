package myApp.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import myApp.models.*;
import myApp.FaceGram;
import myApp.FaceGramError;

public class ViewFeedCommand implements Command {
    private FaceGram faceGram;

    public ViewFeedCommand(FaceGram app) {
        faceGram = app;
    }

    @Override
    public void execute(String params) {
      try {
            ArrayList<Message> feed = faceGram.getUserFeed(params);
            Collections.sort(feed,new TimestampComparator());
            
            for(Message message : feed){
                System.out.println(message);
            }   
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }    
    }

    private class TimestampComparator implements Comparator<Message>{
        @Override
        public int compare(Message m1, Message m2) {
            return m1.getTimeStamp().compareTo(m2.getTimeStamp());
        }  
    }
}
