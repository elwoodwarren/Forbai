import java.util.LinkedList;
import java.util.HashMap;

public class GroupChat {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat
    private String topic;                       // topic/category this chat falls under
    private LinkedList<Integer> users;          // users in the chat
    private boolean type;                       // true is mes, false is group chat
    private int admin;                          // user id of creator/admin of chat
    private static final int groupCapacity = 8;
    private int report_Num;                     // number of reports this group chat has

    public class Message {

        private String mes;
        private Audio voice;
        private Picture pic;
        private int likes;                      // number of likes of this message
        private int owner;                      // who sent this message?

        public Message(String mes, Audio voice, Picture pic, int owner) {
            this.mes = mes;
            this.voice = voice;
            this.likes = 0;
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

        // adds like to a message
        public void addLike() {
            this.likes++;
        }

        // returns number of likes on this message
        public int getLikes() {
            return this.likes;
        }

    }

    // initializes an empty chat, id is the account id number of chat creator
    public GroupChat(int id, String topic, String title, HashMap<String, LinkedList<GroupChat>> topicToChats, HashMap<Integer, Account> idToAcc,
    LinkedList<GroupChat> newestGCs, LinkedList<GroupChat> ambassadorGCs) {
        checkLength(title);
        checkProfanity(title);
        if (!topicToChats.containsKey(topic))
            throw new IllegalArgumentException("Invalid topic!");

        this.queue = new Queue<Message>();
        this.users = new LinkedList<Integer>();
        this.type = type;
        this.title = title;
        this.topic = topic;
        this.admin = id;
        this.report_Num = 0;
        addUser(id, idToAcc);                                                          // add creator of chat to list of chat users
        updateChats(id, topic, title, topicToChats, idToAcc, newestGCs, ambassadorGCs);
    }

    private void updateChats(int id, String topic, String title, HashMap<String, LinkedList<GroupChat>> topicToChats, HashMap<Integer, Account> idToAcc,
    LinkedList<GroupChat> newestGCs, LinkedList<GroupChat> ambassadorGCs) {

        LinkedList<GroupChat> chats = topicToChats.get(topic);
        chats.addFirst(this);
        Account.addGroupChat(id, this, idToAcc);
        newestGCs.addFirst(this);
        if (Account.checkAmbassador(id, idToAcc))                        // add to ambassador chat if applicable
        ambassadorGCs.addFirst(this);
}

public void addMessage(String m, Audio v, Picture p, int id, HashMap<Integer, Account> idToAcc) {
    checkProfanity(m);
    checkSuspended(id, idToAcc);
    Message newMsg = new Message(m, v, p, id);
    queue.enqueue(newMsg);
}

// checks if the user is suspended (i.e. if they have 5+ reports). if yes, set report count to 0 and ban them from sending messages for a day. <- how to do this?
private void checkSuspended(int id, HashMap<Integer, Account> idToAcc) {
    if (Account.reportNum(id, idToAcc) >= 5)
    throw new IllegalArgumentException("5+ users have reported you for misconduct. Please wait one day before sending more messages.");
}

private void checkLength(String t) {
    if (t.length() > 50)
    throw new IllegalArgumentException("Please keep titles to under 50 characters!");
}

// returns true if message contains profanity
private void checkProfanity(String m) {
    if (m.contains("Fuck") || m.contains("fuck") || m.contains("Shit") || m.contains("shit") || m.contains("Bitch") || m.contains("bitch")
    || m.contains("Cunt") || m.contains("cunt") || m.contains("Nigger") || m.contains("nigger") || m.contains("Ass") || m.contains("ass"))
    throw new IllegalArgumentException("Please help us keep group discussions a healthy place for discussion by not using profane language :)");
}

// delete chat if all users leave it and update database of group chats, or delete chat if admin deletes it
public static void deleteChat(GroupChat chat, HashMap<String, LinkedList<GroupChat>> topicToChats) {
    LinkedList<GroupChat> chats = topicToChats.get(chat.topic);
    chats.remove(chat);
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

// returns the account ID of the admin of the chat
public int showAdmin() {
    return this.admin;
}

// adds user to group chat
public void addUser(int id, HashMap<Integer, Account> idToAcc) {
    if (isFull())
    throw new IllegalArgumentException("Chat is full!");
    this.users.add(id);
}

// leave chat
public void removeUser(int id, HashMap<Integer, Account> idToAcc, HashMap<String, LinkedList<GroupChat>> topicToChats) {
    if (isEmpty())
    throw new IllegalArgumentException("Empty chat!");

    this.users.removeFirstOccurrence(id);
    Account.leaveGroupChat(id, this, idToAcc);                                                                           // updates chats assoaciated with account that left

    if (this.users.size() == 0)
    deleteChat(this, topicToChats);
}

public void report(HashMap<String, LinkedList<GroupChat>> topicToChats) {
    this.report_Num++;
    if (this.report_Num == 7)
    deleteChat(this, topicToChats);
}

private boolean isFull() {
    return users.size() == groupCapacity;
}

private boolean isEmpty() {
    return users.size() == 0;
}

}
