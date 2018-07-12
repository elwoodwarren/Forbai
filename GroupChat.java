import java.util.LinkedList;
import java.util.HashMap;

public class GroupChat {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat (title = null if DM, otherwise title = question uploaded by user who started the group chat)
    private LinkedList<Integer> users;          // users in the chat
    private boolean type;                       // true is mes, false is group chat
    private int admin;                          // user id of creator/admin of chat
    private static final int groupCapacity = 8;


    public class Message {

        private String mes;
        private Audio voice;
        private Picture pic;
        private int owner;                          // who sent this message?

        public Message(String mes, Audio voice, Picture pic, int owner) {
            this.mes = mes;
            this.voice = voice;
            this.pic = pic;
            this.owner = owner;
        }

        // returns visual representation of the message
        public Object toVisual() {
            if (this.mes != null)
            return this.mes;
            if (this.voice != null)
            return this.voice;
            else
            return this.pic;
        }

        // does this message belong to this user?
        public boolean whoseMessage(int accID) {
            return accID == this.owner;
        }

    }

    // initializes an empty chat
    public GroupChat(int id, String title, HashMap<String, GroupChat> titleToChat, HashMap<Integer, Account> idToAcc) {
        queue = new Queue<Message>();
        users = new LinkedList<Integer>();
        this.type = type;
        this.title = title;
        this.admin = id;
        addUser(id, idToAcc);                                                          // add creator of chat to list of chat users

        if (titleToChat.containsKey(title) && !titleToChat.get(title).isFull()) {
            Account.addGroupChat(id, titleToChat.get(title), idToAcc);         // if the exact same question exists & chat is not full, add the user to the existing chat
        }
        else if (titleToChat.containsKey(title) && titleToChat.get(title).isFull()) {
            this.title = title + " ";
            titleToChat.put(this.title, this);                   // if exact same question exists & other chat is full, create a modified title
            Account.addGroupChat(id, this, idToAcc);
        }
        else {                                                 // if question doesn't exist, add it to hashmap with no changes
        titleToChat.put(title, this);
        Account.addGroupChat(id, this, idToAcc);
    }

}

public void addMessage(String m, Audio v, Picture p, int id) {
    if (checkProfanity(m))
    throw new IllegalArgumentException("Profanity is not allowed in group chats.");
    Message newMsg = new Message(m, v, p, id);
    queue.enqueue(newMsg);
}

// returns true if message contains profanity
private boolean checkProfanity(String m) {
    if (m.contains("Fuck") || m.contains("fuck") || m.contains("Shit") || m.contains("shit") || m.contains("Bitch") || m.contains("bitch")
    || m.contains("Cunt") || m.contains("cunt") || m.contains("Nigger") || m.contains("nigger") || m.contains("Ass") || m.contains("ass"))
    return true;
    else
    return false;
}

// delete chat if all users leave it
public static void deleteChat(GroupChat chat) {
    if (chat.users.size() == 0)
    chat = null;
}

// show all user IDs in a chat
public Object[] showUsers() {
    return users.toArray();
}

public String showTitle() {
    return title;
}

public Queue<Message> history() {
    return queue;
}

public void addUser(int id, HashMap<Integer, Account> idToAcc) {
    if (isFull())
    throw new IllegalArgumentException("Chat is full!");
    users.add(id);
    Account.addGroupChat(id, this, idToAcc);
}

// leave chat
public void remove(int id, GroupChat chat, HashMap<Integer, Account> idToAcc) {
    if (isEmpty())
    throw new IllegalArgumentException("Empty chat!");
    users.removeFirstOccurrence(id);
    Account.leaveGroupChat(id, chat, idToAcc);                                                                           // updates chats assoaciated with account that left
}

private boolean isFull() {
    return users.size() == groupCapacity;
}

private boolean isEmpty() {
    return users.size() == 0;
}

}
