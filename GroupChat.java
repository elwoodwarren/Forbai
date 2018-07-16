import java.util.LinkedList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class GroupChat {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat (title = null if DM, otherwise title = question uploaded by user who started the group chat)
    private LinkedList<Integer> users;          // users in the chat
    private boolean type;                       // true is mes, false is group chat
    private int admin;                          // user id of creator/admin of chat
    private static final int groupCapacity = 8;
    private int report_Num;                     // number of reports this group chat has
    private Timer timer;                        // time since the most recent message was sent

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
        this.report_Num = 0;
        this.timer = new Timer();
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
    throw new IllegalArgumentException("Please help us keep group discussions a healthy place for discussion by not using profane language :)");
    Message newMsg = new Message(m, v, p, id);
    queue.enqueue(newMsg);
    this.timer = new Timer();
}

// returns true if message contains profanity
private boolean checkProfanity(String m) {
    if (m.contains("Fuck") || m.contains("fuck") || m.contains("Shit") || m.contains("shit") || m.contains("Bitch") || m.contains("bitch")
    || m.contains("Cunt") || m.contains("cunt") || m.contains("Nigger") || m.contains("nigger") || m.contains("Ass") || m.contains("ass"))
    return true;
    else
    return false;
}

// delete chat if all users leave it and update database of group chats
public static void deleteChat(GroupChat chat, HashMap<String, GroupChat> titleToChat) {
    titleToChat.remove(chat.title);
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
public void removeUser(int id, HashMap<Integer, Account> idToAcc, HashMap<String, GroupChat> titleToChat) {
    if (isEmpty())
    throw new IllegalArgumentException("Empty chat!");

    this.users.removeFirstOccurrence(id);
    Account.leaveGroupChat(id, this, idToAcc);                                                                           // updates chats assoaciated with account that left

    if (this.users.size() == 0)
    deleteChat(this, titleToChat);
}

public void report(HashMap<String, GroupChat> titleToChat) {
    this.report_Num++;
    if (this.report_Num == 7)
    deleteChat(this, titleToChat);
}

private boolean isFull() {
    return users.size() == groupCapacity;
}

private boolean isEmpty() {
    return users.size() == 0;
}

}
