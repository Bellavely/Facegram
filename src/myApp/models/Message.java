package myApp.models;
import java.util.Date;
/*A model for storing Messages got the basic info for message*/
public class Message {
    private String userName;
    private int messageId; 
    private String content; 
    private Date timeStamp;
    private int likes;
    
    public Message(String userName , String contex , int messageId){
        this.userName = userName;
        this.messageId = messageId;
        this.content = contex;
        timeStamp = new Date();
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

    public void setContent(String contex) {
        this.content = contex;
        timeStamp = new Date();
    }

    public void addLike() {
        ++likes;
    }

    public String toString(){
        return messageId + ". " +
                userName + ": " + content 
                + " [ " + likes + "likes] " + "[" + timeStamp +"] ";
    }

}
