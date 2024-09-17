package myApp.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import myApp.models.*;
import myApp.FaceGram;

public class ViewFeedCommand implements Command {
    private FaceGram faceGram;

    public ViewFeedCommand(FaceGram app) {
        faceGram = app;
    }

    @Override
    public void execute(String params) {
        ArrayList<Message> feed = faceGram.getUserFeed(params);
        Collections.sort(feed,new TimestampComparator());
            
        for(Message message : feed){
            System.out.println(message);
        }      
    }

    private class TimestampComparator implements Comparator<Message>{
        @Override
        public int compare(Message m1, Message m2) {
            return m2.getTimeStamp().compareTo(m1.getTimeStamp());
        }  
    }
}
