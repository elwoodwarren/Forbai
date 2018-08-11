// This is the embracee feed, where embracees can share posts with each other. idToPosts maps account IDs to all posts posted by a given account
import java.util.LinkedList;
import java.util.HashMap;

public class Post {

    private String mes;
    private Audio voice;
    private Picture pic;
    private int likes;
    private String caption;                     // if people upload a picture, they can have a caption with it
    private int owner;                          // id of the account that this update belongs to
    private Queue<Comment> comments;        // comments on this post

    // comment helper class, for comments on a particular post
    public class Comment {
        private int id;                     // id of the commentor
        private String comment;             // comment

        public Comment(int accID, String newComment) {
            this.id = accID;
            this.comment = newComment;
        }

        // returns string
        public String toString() {
            return this.comment;
        }
    }

    public Post(String mes, Audio voice, Picture pic, int owner, String caption, HashMap<Integer, LinkedList<Post>> idToPosts,
    HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs) {
        // if user has no embracees
        if (idToEmbraceeIDs.get(owner) == null)
        throw new IllegalArgumentException("You need embracees before you can share stuff with them!");

        this.mes = mes;
        this.voice = voice;
        this.pic = pic;
        this.likes = 0;
        this.caption = caption;
        this.owner = owner;
        this.comments = new Queue<Comment>();
        updatePosts(owner, idToEmbraceeIDs, idToPosts);
    }

    // add post to linkedlist of posts by a given user's embracees. idToPosts maps user ID to all the posts uploaded by that user's embracees
    private void updatePosts(int id, HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs, HashMap<Integer, LinkedList<Post>> idToPosts) {
        LinkedList<Integer> embracees = idToEmbraceeIDs.get(id);
        for (int accID : embracees) {
            // if user's embracees have never posted anything
            if (!idToPosts.containsKey(accID)) {
                LinkedList<Post> posts = new LinkedList<Post>();
                posts.addFirst(this);
                idToPosts.put(accID, posts);
                continue;
            }
            // if user's embracees have posted things before
            LinkedList<Post> posts = idToPosts.get(accID);
            posts.addFirst(this);
            idToPosts.put(accID, posts);
        }
    }

    // returns visual representation of the post
    public Object toVisual() {
        if (this.mes != null)
        return this.mes;
        if (this.voice != null)
        return this.voice;
        else
        return this.pic;
    }

    // adds comment from ID to the post
    public void addComment(int accID, String c) {
        Comment newComment = new Comment(accID, c);
        this.comments.enqueue(newComment);
    }

    // returns list of comments on a post
    public Queue<Comment> getComments() {
        return this.comments;
    }

    // adds like to a message
    public void addLike() {
        this.likes++;
    }

    // returns number of likes on this message
    public int getLikes() {
        return this.likes;
    }

    // returns the caption
    public String getCaption() {
        return this.caption;
    }

    // deletes a post by the owner
    public static void deletePost(int owner, Post post, HashMap<Integer, LinkedList<Post>> idToPosts) {
        LinkedList<Post> posts = idToPosts.get(owner);
        posts.remove(post);
        post = null;
    }

}
