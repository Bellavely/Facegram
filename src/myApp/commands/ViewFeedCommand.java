package myApp.commands;

import java.util.ArrayList;
import java.util.List;

import myApp.models.*;
import myApp.FaceGram;

public class ViewFeedCommand implements Command {
    private FaceGram faceGram;

    public ViewFeedCommand(FaceGram app) {
        faceGram = app;
    }

    @Override
    public void execute(String params) {
        List<Message> feedMessages = new ArrayList<>();
    }
}
