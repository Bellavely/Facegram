package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

/**
 * DeleteMessage
 */
public class DeleteMessage implements Command{
    private FaceGram app; 
    public DeleteMessage(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String params) {
        String [] vals = params.split(" ",2);
        try {
            app.deleteMessage(vals[0], Integer.parseInt(vals[0]));
        } catch (NumberFormatException |FaceGramError e) {
            System.out.println(e.getMessage());
        }
    } 
}