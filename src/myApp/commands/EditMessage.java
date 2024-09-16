package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

public class EditMessage implements Command {
    private FaceGram app;

    public EditMessage(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String params) {
        String[] vals = params.split(" ",3);
        try {
            app.editMessage(vals[0] ,Integer.parseInt(vals[1]), vals[2]);
        } catch (FaceGramError e) {
           System.out.println(e.getMessage());
        }
    } 

}
