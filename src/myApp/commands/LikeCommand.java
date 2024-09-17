package myApp.commands;

import myApp.FaceGram;

public class LikeCommand implements Command {
    private FaceGram faceGram;

    public LikeCommand(FaceGram app) {
        faceGram = app; 
    }

    @Override
    public void execute(String params) {
        String []vals = params.split(" ",2);
        if (vals[1].equals(" ") || vals[1].equals("")){
            System.out.println("Please enter message id");
        }else {
            String value = vals[1].replace(" ", ""); 
            faceGram.likeMessage(vals[0],Integer.parseInt(value));
        }  
    }
}
