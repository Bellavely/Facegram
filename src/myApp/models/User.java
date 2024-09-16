package myApp.models;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name; 
    //used hashMap for a faster access for the users messages and following
    private HashMap<Integer,Message> myMessages;
    private HashMap<String , User> following;

    public User(String name){
        this.name = name;
        myMessages = new HashMap<>();
        following = new HashMap<>();
    }

    /*  content - users content for the post 
        messageId - unique id for my message
        post a new message 
    */
    public void postMessage(String content , int messageId) {
        Message newMessage = new Message( name , content , messageId);
        myMessages.put(newMessage.getId(), newMessage);
    }

    /* name - unique user name 
     user - all user details 
    follow and unfollow users */
    public void followUser(User user , String name){
        following.put(name,user);
    }


    public void unfollowUser (String name){
        following.remove(name);
    }
    
    /*  messageId - unique id message
        content - the new content for my message / post
        Edit my message by a unique id  and updates it time 
    */
    public void editMyMessage(int messageId , String content){
        Message editedMessage = myMessages.get(messageId);

        if (editedMessage != null){
            editedMessage.setContent(content);
        }
    }

    public void deleteMessage(int messageId){
        myMessages.remove(messageId);
    }

    public ArrayList<Message> getMessages( ){
        ArrayList<Message> messages = new ArrayList<>(myMessages.values());
        return messages;
    }
 
    /*prints all my messages */
    public void printAllMyMessages (){
        for (int id : myMessages.keySet()){
            System.out.println(myMessages.get(id).toString());
        }
    }

    public ArrayList<Message> getFeed(){
        ArrayList<Message> feed = new ArrayList<>();

        /* Think about a design pattern that will help me */
        for(User user : following.values()){
            for (Message message : user.getMessages()){
                feed.add(message);
            }
        }

        return feed;
    }
}