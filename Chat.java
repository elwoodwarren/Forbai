import java.util.LinkedList;

public class Chat {

    private Queue<Message> queue;               // queue of messages
    private String title;                       // title of chat (title = null if DM, otherwise title = question uploaded by user who started the group chat)
    private LinkedList<Integer> users;          // users in the chat
    private boolean type;                       // true is mes, false is group chat
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
    public Chat(String title, boolean type) {
        queue = new Queue<Message>();
        users = new LinkedList<Integer>();
        this.type = type;
        this.title = title;
    }

    public void addMessage(String m, Audio v, Picture p, int id) {
        Message newMsg = new Message(m, v, p, id);
        queue.enqueue(newMsg);
    }

    // show all user IDs in a chat
    public Object[] showUsers() {
        return users.toArray();
    }

    public Queue<Message> history() {
        return queue;
    }

    public void addUser(int id) {
        if (isFull())
            throw new IllegalArgumentException("Chat is full!");
        users.add(id);
    }

    public void removeUser(int id) {
        if (isEmpty())
            throw new IllegalArgumentException("Empty chat!");
        users.removeFirstOccurrence(id);
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
