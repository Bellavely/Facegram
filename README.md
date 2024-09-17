**FaceGram**
This Project was an assiment that i got in an intreview.
The system allows users to share messages, follow and unfollow other users, and view a personalized feed showing messages from users they follow.

## Core Features

1. **User Management**:

   - Each user has a unique ID (username) and a list of messages they have posted.
   - Users can create accounts, but usernames must be unique.

2. **Posting Messages**:

   - Users can post messages.
   - Each message has a unique ID, timestamp, and content string.

3. **Follow/Unfollow**:

   - Users can follow or unfollow other users.
   - The feed updates accordingly to show or hide posts from users they follow.

4. **Feed**:

   - Users can display a feed showing all the messages from the users they follow, sorted by time.
   - The most recent message appears first.

5. **My Messages**:

   - Users can view their own list of messages.

6. **Delete Message**:

   - Users can delete messages they have posted.

7. **Edit Message**:

   - Users can edit the content of their previously posted messages.

8. **Like Message**:

   - Users can like a message.
   - The feed displays the number of likes each message has.

9. **Trending Messages**:
   - Based on the number of likes received within the last hour, the system identifies and displays trending messages.

**An example for running the program:**
< create_user Alice
< create_user Bob
< post_message Alice "Hello World!"
< like_message Alice 1
< follow Bob Alice
< view_feed Bob
Feed for Bob:
.1 Alice: Hello World! [1 like] [timestamp] [message_id]

- The system uses core Java features without external libraries
- The design patterns that i used in my project are :
  *Command - for creating the command inputs inn my project
  *Factory - for deciding which command to use.
- Data structures like **HashMaps** are used for efficient retrieval of users and messages.
