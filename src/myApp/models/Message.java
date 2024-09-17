package myApp.models;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/*A model for storing Messages got the basic info for message*/
public class Message {
    private String userName;
    private int messageId; 
    private String contenx; 
    private LocalDateTime timeStamp;
    private int likes;
    private Set<String> likedBy; 
    
    public Message(String userName , String contex , int messageId){
        this.userName = userName;
        this.messageId = messageId;
        this.contenx = contex;
        timeStamp = LocalDateTime.now();
        likedBy = new HashSet<>();
    }

    public String getContent(){
        return contenx;
    }

    public int getId() {
        return messageId;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setContent(String contex) {
        this.contenx = contex;
        timeStamp = LocalDateTime.now();
    }

    public void addLike(String userName) {
        if (likedBy.contains(userName)){
            --likes;
            likedBy.remove(userName);
        }else{
            ++likes;
            likedBy.add(userName);
        }
    }

    public String toString(){
        return messageId + ". " +
                userName + ": " + contenx
                + " [ " + likes + " likes] " + "[" + timeStamp +"] ";
    }

}
