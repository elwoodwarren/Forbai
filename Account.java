import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.File;
import java.lang.StringBuilder;

public class Account {

    private Picture pic; // profile pic
    private String first, last, country, email, username, password;
    private boolean gender, ambassador; // true is M, false is F for gender
    private int id; // user id
    private int age; // user age
    private String[] interests; // all interests associated with a particular acc
    private LinkedList<GroupChat> groupchats; // all group chats associated with a particular acc
    private LinkedList<IndividualChat> indchats; // all individual chats associated with a particular acc
    private int numberOfChats; // number of chats this user has participated in
    private int numberOfInterests; // number of interests this user has added
    private LinkedList<Integer> embraceRequests; // ids of all accounts that sent embrace requests sent to this user
    private String[] reports; // reasons for the reports against this user
    private int report_Num; // number of reports against this user
    private boolean suspended; // if reports > 5 then suspend acc

    // constructor
    public Account(String first, String last, int age, String country, String email, String username, String password,
    boolean gender, Picture pic, HashMap<Integer, Account> idToAcc) {
        this.first = first;
        this.last = last;
        this.country = country;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.interests = new String[20];
        this.pic = pic;
        this.numberOfChats = 0;
        this.ambassador = false;
        this.id = idToAcc.size(); // assign unique id to this account
        this.groupchats = new LinkedList<GroupChat>();
        this.indchats = new LinkedList<IndividualChat>();
        this.embraceRequests = new LinkedList<Integer>();
        this.report_Num = 0;
        this.reports = new String[10];
        this.suspended = false;
    }

    // creates new account
    public static void create(String f, String l, int a, String c, String e, String u, String p, boolean g, Picture picture,
    HashMap<String, LinkedList<Integer>> countries_Database, HashMap<String, LinkedList<Integer>> interests_Database,
    HashMap<String, String> loginInfo, HashMap<String, Integer> userToID, HashMap<Integer, Account> idToAcc) {
        // check if username and email are available
        if (!loginInfo.isEmpty()) {
            if (loginInfo.containsKey(e))
            throw new IllegalArgumentException("Email already taken!");
            if (userToID.containsKey(u))
            throw new IllegalArgumentException("Username already taken!");
        }

        // check if criteria is allowed
        checkProfanity(u);
        checkUserValidity(u);
        checkEmailValidity(e);
        checkPasswordLength(p);
        checkAge(a);

        Account newUser = new Account(f, l, a, c, e, u, p, g, picture, idToAcc);
        idToAcc.put(newUser.id, newUser);
        loginInfo.put(newUser.email, newUser.password);
        userToID.put(newUser.username, newUser.id);

        updateDatabases(newUser, c, countries_Database, interests_Database);
    }

    // throws error if username contains profanity
    private static void checkProfanity(String m) {
        if (m.contains("Fuck") || m.contains("fuck") || m.contains("Shit") || m.contains("shit") || m.contains("Bitch") || m.contains("bitch")
        || m.contains("Cunt") || m.contains("cunt") || m.contains("Nigger") || m.contains("nigger") || m.contains("Ass") || m.contains("ass")
        || m.contains("Dick") || m.contains("dick") || m.contains("Vagina") || m.contains("vagina") || m.contains("Nigga") || m.contains("nigga"))
        throw new IllegalArgumentException("Please pick an appropriate username.");
    }

    // throws error if not a valid email
    private static void checkEmailValidity(String e) {

    }

    // throws error if under 13
    private static void checkAge(int a) {
        if (a < 13)
        throw new IllegalArgumentException("Sorry, you must be above 13 years old to make an account.");
    }

    private static void checkPasswordLength(String p) {
        if (p.length() < 7)
        throw new IllegalArgumentException("Password must be over 6 characters!");
    }

    // throws error if username contains non-valid characters
    private static void checkUserValidity(String m) {
        if (m.contains("~") || m.contains("!") || m.contains("@") || m.contains("#") || m.contains("$") || m.contains("%")
        || m.contains("^") || m.contains("&") || m.contains("*") || m.contains("(") || m.contains(")") || m.contains("-")
        || m.contains("+") || m.contains("=") || m.contains("[") || m.contains("]") || m.contains("{") || m.contains("}")
        || m.contains("?") || m.contains("/") || m.contains(";") || m.contains(":") || m.contains("<") || m.contains(">")
        || m.contains(","))
        throw new IllegalArgumentException("Please pick an appropriate username.");

        if (m.length() >= 16)
        throw new IllegalArgumentException("Username must be under 16 characters!");

        if (m.length() <= 3)
        throw new IllegalArgumentException("Username must be at least 4 characters!");

    }

    // adds group chat to this account
    public static void addGroupChat(int accID, GroupChat newChat, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        acc.groupchats.addFirst(newChat);
        acc.numberOfChats++;
    }

    // leave group chat
    public static void leaveGroupChat(int accID, GroupChat chat, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        acc.groupchats.remove(chat);
    }

    // adds individual chat to this account
    public static void addIndChat(int accID, IndividualChat newChat, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        acc.indchats.addFirst(newChat);
    }

    // leave individual chat
    public static void leaveIndChat(int accID, IndividualChat chat, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        acc.indchats.remove(chat);
    }

    // returns number of chats this user has participated in
    public static int getNumberOfChats(int accID, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        return acc.numberOfChats;
    }

    // returns all group chats associated with this account
    public static LinkedList<GroupChat> allGroupChats(int accID, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        return acc.groupchats;
    }

    // returns all individual chats associated with this account
    public static LinkedList<IndividualChat> allIndChats(int accID, HashMap<Integer, Account> idToAcc) {
        Account acc = idToAcc.get(accID);
        return acc.indchats;
    }

    // updates interest and country database when new account is created
    private static void updateDatabases(Account newUser, String c, HashMap<String, LinkedList<Integer>> countries_Database,
    HashMap<String, LinkedList<Integer>> interests_Database) {
        LinkedList<Integer> countryAccs = countries_Database.get(c);
        LinkedList<Integer> allAccs = countries_Database.get("All");
        countryAccs.add(newUser.id);
        allAccs.add(newUser.id);
        countries_Database.put(c, countryAccs);
        countries_Database.put("All", allAccs);

        if (interests_Database.get("All") == null) {
            LinkedList<Integer> newAcc = new LinkedList<Integer>();
            newAcc.add(newUser.id);
            interests_Database.put("All", newAcc);
        }
        interests_Database.put("All", allAccs);
    }

    // when user adds an interest, add it to hashmap
    public static void addInterest(int accID, String i, HashMap<String, LinkedList<Integer>> interests_Database,
    HashMap<Integer, Account> idToAcc) {

        Account acc = idToAcc.get(accID);

        // check if interest is valid
        checkInterestValidity(i);
        String interest = fixInterestString(i);
        acc.numberOfInterests++;

        // if interest is not on hashmap, add it
        if (interests_Database.get(interest) == null) {
            LinkedList<Integer> newAcc = new LinkedList<Integer>();               // update database
            newAcc.add(acc.id);
            interests_Database.put(interest, newAcc);

            for (int j = 0; j < acc.interests.length; j++) {                            // update account's interests
            if (acc.interests[j] == null) {
                acc.interests[j] = interest;
                break;
            }
        }
    }
    // otherwise add it to hashmap and update accounts
    else {
        LinkedList<Integer> interestAccount = interests_Database.get(interest); // update database
        interestAccount.add(acc.id);
        interests_Database.put(interest, interestAccount);
        for (int j = 0; j < acc.interests.length; j++) {                            // update account's interests
        if (acc.interests[j] == null) {
            acc.interests[j] = interest;
            break;
        }
    }
}
}

// deletes "The" if user puts "The" as the first word in the interest
private static String fixInterestString(String i) {
    StringBuilder interest = new StringBuilder(i);
    String test = interest.substring(0, 3);
    if (test.equals("The"))
    interest.delete(0, 4);
    return interest.toString();
}

// if interest is null or over 20 characters
private static void checkInterestValidity(String m) {
    if (m == null || m.length() > 25)
    throw new IllegalArgumentException("Please keep interest to less than 25 characters!");

    if (m.contains("Fuck") || m.contains("fuck") || m.contains("Shit") || m.contains("shit") || m.contains("Bitch") || m.contains("bitch")
    || m.contains("Cunt") || m.contains("cunt") || m.contains("Nigger") || m.contains("nigger") || m.contains("Ass") || m.contains("ass")
    || m.contains("Dick") || m.contains("dick") || m.contains("Vagina") || m.contains("vagina") || m.contains("Nigga") || m.contains("nigga"))
    throw new IllegalArgumentException("Please pick an appropriate interest.");
}

// remove an interest (returns true if interest exist, false if interest doesn't exist)
public static void removeInterest(int accID, String interest, HashMap<String, LinkedList<Integer>> interests_Database,
HashMap<Integer, Account> idToAcc) {

    // check if interest is valid
    if (interest == null || interests_Database.get(interest) == null)
    throw new IllegalArgumentException("Invalid Interest!");

    Account acc = idToAcc.get(accID);
    acc.numberOfInterests--;

    LinkedList<Integer> interestAccounts = interests_Database.get(interest);

    interestAccounts.removeFirstOccurrence(acc.id);                             // update database
    interests_Database.put(interest, interestAccounts);
    for (int i = 0; i < acc.interests.length; i++) {                            // update account's interests
    if (acc.interests[i] == null)
    continue;
    if (acc.interests[i].equals(interest)) {
        acc.interests[i] = null;
        break;
    }
}
}

// returns number of interests this user has uploaded
public static int getNumberOfInterests(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.numberOfInterests;
}

// when user0 sends an embrace request to user1
public static void sendEmbrace(int accID0, int accID1, HashMap<Integer, Account> idToAcc) {
    Account user1 = idToAcc.get(accID1);
    if (!user1.embraceRequests.contains(accID0))
    user1.embraceRequests.add(accID0);
}

// when user0 removes/cancels/rejects an embrace request from user1
public static void removeEmbraceRequest(int accID0, int accID1, HashMap<Integer, Account> idToAcc) {
    Account user0 = idToAcc.get(accID0);
    user0.embraceRequests.removeFirstOccurrence(accID1);
}

// when user0 accepts an embrace request from user1
public static void acceptEmbrace(int accID0, int accID1, HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs, HashMap<Integer, Account> idToAcc) {
    Account user0 = idToAcc.get(accID0);
    Account user1 = idToAcc.get(accID1);

    if (user0 == null || user1 == null)
    throw new IllegalArgumentException("Null arguments!");

    // update embraceRequests list of accID0
    removeEmbraceRequest(accID0, accID1, idToAcc);

    // if both users have embracees
    if (idToEmbraceeIDs.get(user0.id) != null && idToEmbraceeIDs.get(user1.id) != null) {
        LinkedList<Integer> user0Embracees = idToEmbraceeIDs.get(user0.id);
        LinkedList<Integer> user1Embracees = idToEmbraceeIDs.get(user1.id);
        user0Embracees.add(user1.id);
        user1Embracees.add(user0.id);
        idToEmbraceeIDs.put(user0.id, user0Embracees);
        idToEmbraceeIDs.put(user1.id, user1Embracees);
    }
    // if user0 has no embracees and user1 has embracees
    else if (idToEmbraceeIDs.get(user0.id) == null && idToEmbraceeIDs.get(user1.id) != null) {
        LinkedList<Integer> firstEmbracee0 = new LinkedList<Integer>();
        firstEmbracee0.add(user1.id);
        idToEmbraceeIDs.put(user0.id, firstEmbracee0);
        LinkedList<Integer> user1Embracees = idToEmbraceeIDs.get(user1.id);
        user1Embracees.add(user0.id);
        idToEmbraceeIDs.put(user1.id, user1Embracees);
    }
    // if user0 has embracees and user1 has no embracees
    else if (idToEmbraceeIDs.get(user1.id) == null && idToEmbraceeIDs.get(user0.id) != null) {
        LinkedList<Integer> firstEmbracee1 = new LinkedList<Integer>();
        firstEmbracee1.add(user0.id);
        idToEmbraceeIDs.put(user1.id, firstEmbracee1);
        LinkedList<Integer> user0Embracees = idToEmbraceeIDs.get(user0.id);
        user0Embracees.add(user1.id);
        idToEmbraceeIDs.put(user0.id, user0Embracees);
    }
    // if both users have no embracees
    else {
        LinkedList<Integer> firstEmbracee0 = new LinkedList<Integer>();
        LinkedList<Integer> firstEmbracee1 = new LinkedList<Integer>();
        firstEmbracee0.add(user1.id);
        firstEmbracee1.add(user0.id);
        idToEmbraceeIDs.put(user0.id, firstEmbracee0);
        idToEmbraceeIDs.put(user1.id, firstEmbracee1);
    }
}

public static void removeEmbracee(int accID0, int accID1, HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs, HashMap<Integer, Account> idToAcc) {
    Account user0 = idToAcc.get(accID0);
    Account user1 = idToAcc.get(accID1);

    if (user0 == null || user1 == null)
    throw new IllegalArgumentException("Null arguments!");

    if (idToEmbraceeIDs.get(user0.id).size() == 0 || idToEmbraceeIDs.get(user1.id).size() == 0)
    throw new IllegalArgumentException("No embracees to remove!");

    LinkedList<Integer> embracees0 = idToEmbraceeIDs.get(user0.id);
    LinkedList<Integer> embracees1 = idToEmbraceeIDs.get(user1.id);
    embracees0.removeFirstOccurrence(user1.id);
    embracees1.removeFirstOccurrence(user0.id);
    idToEmbraceeIDs.put(user0.id, embracees0);
    idToEmbraceeIDs.put(user1.id, embracees1);
}

// returns embracees of given user
public static LinkedList<Integer> showEmbracees(int accID, HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs) {
    return idToEmbraceeIDs.get(accID);
}

// returns list of account IDs that requested to embrace the given user
public static LinkedList<Integer> showEmbraceRequests(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.embraceRequests;
}

// change email
public static void changeEmail(int accID, String newEmail, HashMap<String, String> loginInfo, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    loginInfo.remove(acc.email);
    acc.email = newEmail;
    loginInfo.put(newEmail, acc.password);
    idToAcc.put(acc.id, acc);
}

// change username
public static void changeUsername(int accID, String newUser, HashMap<String, Integer> userToID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    userToID.remove(acc.username);
    acc.username = newUser;
    userToID.put(newUser, acc.id);
    idToAcc.put(acc.id, acc);
}

// change password
public static void changePassword(int accID, String newPass, HashMap<String, String> loginInfo, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    acc.password = newPass;
    loginInfo.put(acc.email, newPass);
    idToAcc.put(acc.id, acc);
}

public static String showUser(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.username;
}

public static String showFirstName(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.first;
}

public static String showLastName(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.last;
}

public static String showPass(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.password;
}

public static String showEmail(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.email;
}

public static int showID(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.id;
}

public static void makeAmbassador(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    acc.ambassador = true;
}

// is the user an ambassador?
public static boolean checkAmbassador(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.ambassador;
}

// edit profile picture
public static void editProfPic(int accID, File file, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    Picture newProfPic = new Picture(file);
    acc.pic = newProfPic;
}


// returns a string array of interests associated with given Account
public static String[] interestList(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.interests;
}

// string representation of accounts in country database
public static String toCountryString(String country, HashMap<String, LinkedList<Integer>> countries_Database) {
    if (countries_Database.get(country) == null)
    return "Empty!";
    LinkedList<Integer> countryIDs = countries_Database.get(country);
    Object[] countryIDArray = countryIDs.toArray();
    return Arrays.toString(countryIDArray);
}

// string representation of accounts in interest database
public static String toInterestString(String interest, HashMap<String, LinkedList<Integer>> interests_Database) {
    if (interests_Database.get(interest) == null)
    return "Empty!";
    LinkedList<Integer> interestIDs = interests_Database.get(interest);
    Object[] interestIDArray = interestIDs.toArray();
    return Arrays.toString(interestIDArray);
}

// call this method when a user is reported. If a user's total # of reports reached 5, it gets suspended
public static void report(int accID, String reason, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    acc.report_Num++;
    for (int i = 0; i < acc.reports.length; i++) {
        if (acc.reports[i] == null)
        acc.reports[i] = reason;
    }

    if (acc.report_Num >= 5)
    acc.suspended = true;
}

public static String[] showReportReasons(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.reports;
}

// if an account has 5+ reports against them, they should be banned from sending messages for a day
public static int reportNum(int accID, HashMap<Integer, Account> idToAcc) {
    Account acc = idToAcc.get(accID);
    return acc.report_Num;
}

// shows all Sonder posts of your embracees in chronological order
public static LinkedList<Post> showEmbraceePosts(int accID, HashMap<Integer, LinkedList<Post>> idToPosts) {
    return idToPosts.get(accID);
}

}
