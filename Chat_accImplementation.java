import java.util.LinkedList;
import java.util.HashMap;

public class Chat_accImplementation {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat (title = null if DM, otherwise title = question uploaded by user who started the group chat)
    private LinkedList<Integer> users;          // users in the chat
    private boolean type;                       // true is mes, false is group chat
    private Account admin;                          // creator/admin of chat
    private static final int indCapacity = 2;
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

        public Object toVisual(Message m) {
            if (m.mes != null)
            return m.mes;
            if (m.voice != null)
            return m.voice;
            else
            return m.pic;
        }
    }

    // initializes an empty chat
    public Chat_accImplementation(Account_accImplementation acc, String title, boolean type, HashMap<String, Chat> titleToChat) {
        queue = new Queue<Message>();
        users = new LinkedList<Integer>();
        this.type = type;
        this.title = title;
        this.admin = acc;
        if (type = false) {
            if (titleToChat.containsKey(title) && !titleToChat.get(title).isFull())
            Account.addChat(acc, titleToChat.get(title));         // if the exact same question exists & chat is not full, add the user to the existing chat
            else if (titleToChat.containsKey(title) && titleToChat.get(title).isFull())
            titleToChat.put(title + " ", this);                   // if exact same question exists & other chat is full, create a modified title
            else                                                  // if question doesn't exist, add it to hashmap with no changes
            titleToChat.put(title, this);
        }
    }

    public void addMessage(String m, Audio v, Picture p, int id) {
        Message newMsg = new Message(m, v, p, id);
        queue.enqueue(newMsg);
    }

    // delete chat if all users leave it
    public static void deleteChat(Chat chat) {
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

    public void addUser(int id) {
        if (isFull())
        throw new IllegalArgumentException("Chat is full!");
        users.add(id);
    }

    // leave chat
    public void remove(int id, Chat chat, HashMap<Integer, Account> idToAcc) {
        if (isEmpty())
        throw new IllegalArgumentException("Empty chat!");
        users.removeFirstOccurrence(id);
        Account.leaveChat(idToAcc.get(id), chat);                                                                       // updates chats assoaciated with account that left
    }

    private boolean isFull() {
        if (type == false)
        return users.size() == groupCapacity;
        else
        return users.size() == indCapacity;
    }

    private boolean isEmpty() {
        return users.size() == 0;
    }

}
