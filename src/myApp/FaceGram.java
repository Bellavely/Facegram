package myApp;
import java.util.HashMap;

import myApp.models.User;

public class FaceGram {
    private static int numMessages; 
    private HashMap<String,User> faceGramUsers; 

    public FaceGram(){
        faceGramUsers = new HashMap<>();
    }

    public void createUser(String name) throws FaceGramError{
        if (name.equals("")){
            throw new FaceGramError("please enter a name");
        }
        if (faceGramUsers.containsKey(name)){
            throw new FaceGramError("User Already Exists");
        }
        faceGramUsers.put(name, new User(name));
        System.out.println(name + " created");
    }
    
    public void checkIfUserExist ( String userName) throws FaceGramError{
        if (!faceGramUsers.containsKey(userName)){
            throw new FaceGramError(userName + " don't exist!");
        }
    }

    public void postMessage (String user, String content) throws FaceGramError{
        checkIfUserExist(user);
        faceGramUsers.get(user).postMessage(content, numMessages);
        numMessages++;
    }

    public void myMessages(String user) throws FaceGramError{
        checkIfUserExist(user);
        faceGramUsers.get(user).printAllMyMessages(); 
    }

}
