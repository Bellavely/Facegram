package myApp.commands;

import java.util.List;

import myApp.FaceGram;
import myApp.models.Message;

public class TrendMessCommand implements Command {
    private FaceGram app;
    
    public TrendMessCommand(FaceGram app){
        this.app = app;
    }

    @Override
    public void execute(String params) {
        List<Message> trending = app.getTreandingMessages();
        for(Message msg: trending){
            System.out.println(msg);
        }
    }
}
