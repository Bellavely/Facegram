package myApp.commands;

import myApp.FaceGram;

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
            String value = vals[1].replace(" ", ""); 
            app.deleteMessage(vals[0], Integer.parseInt(value));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    } 
}