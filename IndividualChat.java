import java.util.LinkedList;
import java.util.HashMap;

public class IndividualChat {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat (title = null if DM, otherwise title = question uploaded by user who started the group chat)
    private LinkedList<Integer> users;          // users in the chat
    private static final int indCapacity = 2;


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

        public Object toVisual() {
            if (this.mes != null)
            return this.mes;
            if (this.voice != null)
            return this.voice;
            else
            return this.pic;
        }
    }

    // initializes an empty chat
    public IndividualChat(int user0, int user1, HashMap<Integer, Account> idToAcc) {
        queue = new Queue<Message>();
        users = new LinkedList<Integer>();
        users.add(user0);
        users.add(user1);
        Account.addIndChat(user0, this, idToAcc);
        Account.addIndChat(user1, this, idToAcc);
    }

    public void addMessage(String m, Audio v, Picture p, int id) {
        Message newMsg = new Message(m, v, p, id);
        queue.enqueue(newMsg);
    }

    // delete chat if all users leave it
    public static void deleteChat(IndividualChat chat) {
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

    // leave chat
    public void remove(int id, IndividualChat chat, HashMap<Integer, Account> idToAcc) {
        if (isEmpty())
        throw new IllegalArgumentException("Empty chat!");
        users.removeFirstOccurrence(id);
        Account.leaveIndChat(id, chat, idToAcc);                                                                           // updates chats assoaciated with account that left
    }

    private boolean isFull() {
        return users.size() == indCapacity;
    }

    private boolean isEmpty() {
        return users.size() == 0;
    }

}
