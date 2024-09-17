package myApp.commands;

import myApp.FaceGram;

public class EditMessage implements Command {
    private FaceGram app;

    public EditMessage(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String params) {
        String[] vals = params.split(" ",3);
        try {
            String value = vals[1].replace(" ", ""); 
            app.editMessage(vals[0] ,Integer.parseInt(value), vals[2]);
        } catch (NumberFormatException e) {
           System.out.println(e.getMessage());
        }
    } 

}
