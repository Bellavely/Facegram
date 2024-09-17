package myApp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import myApp.models.Message;
import myApp.models.User;


/*TODO: add observer for feed */

public class FaceGram {
    private static int numMessages; 
    private HashMap<String,User> faceGramUsers;
    private HashMap<Integer,Message> messages;
    private Monitor monitor;

    public FaceGram(Monitor monitor){
        faceGramUsers = new HashMap<>();
        messages = new HashMap<>();
        this.monitor = monitor;
    }

    public void createUser(String name) {
        if (name.equals(" ") || name.equals("")){
            monitor.display("please enter a name");
        }
        else if (faceGramUsers.containsKey(name)){
            monitor.display("User Already Exists");
        }else{
            faceGramUsers.put(name, new User(name));
            monitor.display(name + " created");
        }
    }

    public void editMessage(String userName,int messageId , String content) {
        checkIfUserExist(userName);
        faceGramUsers.get(userName).editMyMessage(messageId, content);
    } 

    public void unFollowUser(String userNamed, String followUser) {
        checkIfUserExist(userNamed);
        checkIfUserExist(followUser);
        faceGramUsers.get(userNamed).unfollowUser(followUser);
    }

    public void deleteMessage(String userName , int messageId ) {
        checkIfUserExist(userName);
        faceGramUsers.get(userName).deleteMessage(messageId);
    }
    
    public void checkIfUserExist ( String userName) {
        if (!faceGramUsers.containsKey(userName)){
           monitor.display(userName + " don't exist!");
        }
    }

    public void addFollower(String userName , String user) {
        checkIfUserExist(userName);
        checkIfUserExist(user);
        User follow = faceGramUsers.get(user);
        faceGramUsers.get(userName).followUser(follow, user);
    }

    public void postMessage (String user, String content) {
        checkIfUserExist(user);
        Message newMessage = new Message( user , content , numMessages);
        messages.put(numMessages, newMessage);
        faceGramUsers.get(user).postMessage(newMessage);
        numMessages++;
    }

    public void myMessages(String user) {
        checkIfUserExist(user);
        faceGramUsers.get(user).printAllMyMessages(); 
    }

    public ArrayList<Message> getUserFeed(String userName) {
        checkIfUserExist(userName);
        return faceGramUsers.get(userName).getFeed();
    }

    public void likeMessage (String username , int messageId) {
        Message likedMsg = messages.get(messageId);
        likedMsg.addLike(username);
    }

    public List<Message> getTreandingMessages(){
        List<Message> trending = messages.values().stream()
                                .filter(message -> message.getLikes() >= 1 )
                                .collect(Collectors.toList());
        //sort by num of likes
        trending.sort(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });

        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        return trending.stream().filter(message -> message.getTimeStamp().isAfter(oneHourAgo))
        .collect(Collectors.toList());
    }

}
