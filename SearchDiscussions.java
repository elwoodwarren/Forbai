import java.util.HashMap;
import java.util.LinkedList;

public class SearchDiscussions {

    public static GroupChat[] search(String keyword, HashMap<String, GroupChat> titleToChat) {                    // takes O(n) time
        GroupChat[] matches = new GroupChat[8];
        int i = 0;
        // scan all chat titles for keyword
        for (String title : titleToChat.keySet()) {
            if (i == 7)
            break;
            if (title.contains(keyword)) {
                matches[i] = titleToChat.get(title);
                i++;
            }
        }

        return matches;
    }
}
