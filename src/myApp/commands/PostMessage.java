package myApp.commands;

import myApp.FaceGram;
import myApp.FaceGramError;

public class PostMessage implements Command {
    private FaceGram app; 

    public PostMessage(FaceGram faceGram){
        app = faceGram;
    }

    @Override
    public void execute(String command) {
        String[] vals = command.split(" ");
        try {
            if (vals.length < 2){
                app.postMessage(vals[0], " ");
            }else {
            app.postMessage(vals[0], vals[1]);
            }
        } catch (FaceGramError e) {
            System.out.println(e.getMessage());
        }
    }

}
 