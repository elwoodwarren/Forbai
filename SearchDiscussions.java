import java.util.HashMap;
import java.util.LinkedList;

public class SearchDiscussions {

    private static Queue<GroupChat> matches;

    // returns up to 50 matches of most recent chats posted in this category. To access queue contents from frontend, call dequeue() in Queue.java
    public static Queue<GroupChat> search(String category, HashMap<String, LinkedList<GroupChat>> topicToChats) {
        matches = new Queue<GroupChat>();
        LinkedList<GroupChat> chats = topicToChats.get(category);
        for (int i = 0; i < chats.size(); i++) {
            matches.enqueue(chats.get(i));
        }
        return matches;
    }
}
