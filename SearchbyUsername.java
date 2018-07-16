import java.util.HashMap;

// THIS IS CURRENTLY NOT NEEDED. IN THE FUTURE IF PEOPLE WANT A WAY TO SEARCH FOR THEIR IRL FRIENDS WE WILL IMPLEMENT THIS.

public class SearchbyUsername {

    public static int search(String username, HashMap<String, Integer> userToID) {

        return userToID.get(username);
    }
}
