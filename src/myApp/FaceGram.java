package myApp;
import java.util.ArrayList;
import java.util.HashMap;

import myApp.models.Message;
import myApp.models.User;

public class FaceGram {
    private static int numMessages; 
    private HashMap<String,User> faceGramUsers;
    private HashMap<Integer,Message> messages;

    public FaceGram(){
        faceGramUsers = new HashMap<>();
        messages = new HashMap<>();
    }

    public void createUser(String name) throws FaceGramError{
        if (name.equals(" ") || name.equals("")){
            throw new FaceGramError("please enter a name");
        }
        if (faceGramUsers.containsKey(name)){
            throw new FaceGramError("User Already Exists");
        }
        faceGramUsers.put(name, new User(name));
        System.out.println(name + " created");
    }

    public void editMessage(String userName,int messageId , String content) throws FaceGramError{
        checkIfUserExist(userName);
        faceGramUsers.get(userName).editMyMessage(messageId, content);
    } 

    public void unFollowUser(String userNamed, String followUser) throws FaceGramError{
        checkIfUserExist(userNamed);
        checkIfUserExist(followUser);
        faceGramUsers.get(userNamed).unfollowUser(userNamed);
    }

    public void deleteMessage(String userName , int messageId ) throws FaceGramError{
        checkIfUserExist(userName);
        faceGramUsers.get(userName).deleteMessage(messageId);
    }
    
    public void checkIfUserExist ( String userName) throws FaceGramError{
        if (!faceGramUsers.containsKey(userName)){
            throw new FaceGramError(userName + " don't exist!");
        }
    }

    public void addFollower(String userName , String user) throws FaceGramError{
        checkIfUserExist(userName);
        checkIfUserExist(user);
        User follow = faceGramUsers.get(user);
        faceGramUsers.get(userName).followUser(follow, user);
    }

    public void postMessage (String user, String content) throws FaceGramError{
        checkIfUserExist(user);
        Message newMessage = new Message( user , content , numMessages);
        messages.put(numMessages, newMessage);
        faceGramUsers.get(user).postMessage(newMessage);
        numMessages++;
    }

    public void myMessages(String user) throws FaceGramError{
        checkIfUserExist(user);
        faceGramUsers.get(user).printAllMyMessages(); 
    }

    public ArrayList<Message> getUserFeed(String userName) throws FaceGramError{
        checkIfUserExist(userName);
        return faceGramUsers.get(userName).getFeed();
    }

    public void likeMessage (int messageId) {
        Message likedMsg = messages.get(messageId);
        likedMsg.addLike();
    }

}
