package myApp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import myApp.models.Message;
import myApp.models.User;



/**
 * The FaceGram class represents a simple social media platform where users can create accounts,
 * post messages, follow and unfollow other users, and interact with messages such as liking and editing.
 * The platform also provides features to retrieve trending messages and user feeds.
 * 
 * TODO: add observer for feed array
 */

public class FaceGram {
    private static int numMessages; 
    private HashMap<String,User> faceGramUsers;
    private HashMap<Integer,Message> messages;
    private Monitor monitor;

    /**
     * Constructs a new FaceGram instance with the given monitor for displaying messages.
     * 
     * @param monitor the Monitor object used for displaying messages to the user
     */
    public FaceGram(Monitor monitor){
        faceGramUsers = new HashMap<>();
        messages = new HashMap<>();
        this.monitor = monitor;
    }

    /**
     * Creates a new user in the FaceGram platform.
     * 
     * @param name the name of the user to be created
     */
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

    /**
     * Edits the content of an existing message for a specific user.
     * 
     * @param userName the name of the user who owns the message
     * @param messageId the ID of the message to be edited
     * @param content the new content for the message
     */
    public void editMessage(String userName,int messageId , String content) {
        checkIfUserExist(userName);
        faceGramUsers.get(userName).editMyMessage(messageId, content);
    } 

    /**
     * Unfollows another user from the given user's follow list.
     * 
     * @param userNamed the user who will stop following
     * @param followUser the user to be unfollowed
     */
    public void unFollowUser(String userNamed, String followUser) {
        checkIfUserExist(userNamed);
        checkIfUserExist(followUser);
        faceGramUsers.get(userNamed).unfollowUser(followUser);
    }

    /**
     * Deletes a specific message for a user.
     * 
     * @param userName the name of the user who owns the message
     * @param messageId the ID of the message to be deleted
     */
    public void deleteMessage(String userName , int messageId ) {
        checkIfUserExist(userName);
        faceGramUsers.get(userName).deleteMessage(messageId);
    }
    
    /**
     * Adds a follower to the given user.
     * 
     * @param userName the user who will follow another user
     * @param user the user to be followed
     */
    public void addFollower(String userName , String user) {
        checkIfUserExist(userName);
        checkIfUserExist(user);
        User follow = faceGramUsers.get(user);
        faceGramUsers.get(userName).followUser(follow, user);
    }

    /**
     * Posts a new message for a user.
     * 
     * @param user the user posting the message
     * @param content the content of the message
     */
    public void postMessage (String user, String content) {
        checkIfUserExist(user);
        Message newMessage = new Message( user , content , numMessages);
        messages.put(numMessages, newMessage);
        faceGramUsers.get(user).postMessage(newMessage);
        numMessages++;
    }

    /**
     * Displays all messages posted by the user.
     * @param user the user whose messages are to be displayed
     */
    public void myMessages(String user) {
        checkIfUserExist(user);
        faceGramUsers.get(user).printAllMyMessages(); 
    }

    /**
     * Retrieves the feed (messages) of a specific user.
     * 
     * @param userName the name of the user whose feed is to be retrieved
     * @return an ArrayList of Message objects representing the user's feed
     */
    public ArrayList<Message> getUserFeed(String userName) {
        checkIfUserExist(userName);
        return faceGramUsers.get(userName).getFeed();
    }

    /**
     * Adds a like to a message.
     * 
     * @param username the user who is liking the message
     * @param messageId the ID of the message to be liked
     */
    public void likeMessage (String username , int messageId) {
        Message likedMsg = messages.get(messageId);
        likedMsg.addLike(username);
    }

     /**
     * Retrieves a list of trending messages, sorted by the number of likes in descending order.
     * Only messages posted within the last hour with at least one like are considered.
     * @return a list of trending messages
     */
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

    private void checkIfUserExist ( String userName) {
        if (!faceGramUsers.containsKey(userName)){
           monitor.display(userName + " don't exist!");
        }
    }
}
