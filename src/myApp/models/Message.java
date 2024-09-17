package myApp.models;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*A model for storing Messages got the basic info for message*/
public class Message {
    private String userName;
    private int messageId; 
    private String content; 
    private Date timeStamp;
    private int likes;
    private Set<String> likedBy; 
    
    public Message(String userName , String contex , int messageId){
        this.userName = userName;
        this.messageId = messageId;
        this.content = contex;
        timeStamp = new Date();
        likedBy = new HashSet<>();
    }

    public String getContent(){
        return content;
    }

    public int getId() {
        return messageId;
    }

    public int getLikes() {
        return likes;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setContent(String contex) {
        this.content = contex;
        timeStamp = new Date();
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
                userName + ": " + content 
                + " [ " + likes + " likes] " + "[" + timeStamp +"] ";
    }

}
