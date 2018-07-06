import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.File;

public class Account {

  private Picture pic; // profile pic
  private String first, last, country, email, username, password;
  private boolean gender, ambassador; // true is M, false is F for gender
  private int id; // user id
  private String interests[]; // all interests associated with a particular acc

// constructor
  public Account(String first, String last, String country, String email, String username, String password,
                boolean gender, Picture pic, RedBlackBST<Integer, Account> idToAcc) {
    this.first = first;
    this.last = last;
    this.country = country;
    this.email = email;
    this.username = username;
    this.password = password;
    this.gender = gender;
    this.interests = new String[20];
    this.pic = pic;
    this.ambassador = false;
    this.id = idToAcc.size(); // assign special id # to this account
  }

  public static void create(String f, String l, String c, String e, String u, String p, boolean g, Picture picture,
                       HashMap<String, LinkedList<Integer>> countries_Database, HashMap<String, LinkedList<Integer>> interests_Database,
                       RedBlackBST<String, String> loginInfo, RedBlackBST<String, String> userToPass, RedBlackBST<Integer, Account> idToAcc) {
    // check if username and email are available
    if (!loginInfo.isEmpty()) {
        if (loginInfo.contains(e))
            throw new IllegalArgumentException("Email already taken!");
        if (userToPass.contains(u))
            throw new IllegalArgumentException("Username already taken!");
    }

    Account newUser = new Account(f, l, c, e, u, p, g, picture, idToAcc);
    idToAcc.put(newUser.id, newUser);
    loginInfo.put(newUser.email, newUser.password);
    userToPass.put(newUser.username, newUser.password);

    updateDatabases(newUser, c, countries_Database, interests_Database);
  }

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

// when user adds an interest, add it to hashmap (returns false if interest is null)
  public static boolean addInterest(Account acc, String interest, HashMap<String, LinkedList<Integer>> interests_Database) {
// check if interest is valid
    if (interest == null)
      return false;
// if interest is not on hashmap, add it
    else if (interests_Database.get(interest) == null) {
      LinkedList<Integer> newAcc = new LinkedList<Integer>();               // update database
      newAcc.add(acc.id);
      interests_Database.put(interest, newAcc);

      for (int i = 0; i < acc.interests.length; i++) {                            // update account's interests
        if (acc.interests[i] == null) {
          acc.interests[i] = interest;
          break;
        }
      }
      return true;
    }
    // otherwise add it to hashmap and update accounts
    else {
      LinkedList<Integer> interestAccount = interests_Database.get(interest); // update database
      interestAccount.add(acc.id);
      interests_Database.put(interest, interestAccount);
      for (int i = 0; i < acc.interests.length; i++) {                            // update account's interests
        if (acc.interests[i] == null) {
          acc.interests[i] = interest;
          break;
        }
      }
      return true;
    }
  }

// remove an interest (returns true if interest exist, false if interest doesn't exist)
  public static boolean removeInterest(Account acc, String interest, HashMap<String, LinkedList<Integer>> interests_Database) {
    // check if interest is valid
    if (interest == null || interests_Database.get(interest) == null)
      return false;

    LinkedList<Integer> interestAccounts = interests_Database.get(interest);
    if (!interestAccounts.contains(acc.id) || interestAccounts.size() == 0)
      return false;

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
    return true;
  }

  // change email
  public static void changeEmail(Account acc, String newEmail, RedBlackBST<String, String> loginInfo, RedBlackBST<Integer, Account> idToAcc) {
    loginInfo.delete(acc.email);
    acc.email = newEmail;
    loginInfo.put(newEmail, acc.password);
    idToAcc.put(acc.id, acc);
  }

  // change username
  public static void changeUsername(Account acc, String newUser, RedBlackBST<String, String> userToPass, RedBlackBST<Integer, Account> idToAcc) {
    userToPass.delete(acc.username);
    acc.username = newUser;
    userToPass.put(newUser, acc.password);
    idToAcc.put(acc.id, acc);
  }

  // change password
  public static void changePassword(Account acc, String newPass, RedBlackBST<String, String> loginInfo, RedBlackBST<String, String> userToPass,
                                    RedBlackBST<Integer, Account> idToAcc) {
    acc.password = newPass;
    userToPass.put(acc.username, newPass);
    loginInfo.put(acc.email, newPass);
    idToAcc.put(acc.id, acc);
  }

  public static String showUser(Account acc) {
    return acc.username;
  }

  public static String showPass(Account acc) {
    return acc.password;
  }

  public static String showEmail(Account acc) {
      return acc.email;
  }

  public static int showID(Account acc) {
      return acc.id;
  }

  public static void makeAmbassador(Account acc) {
    acc.ambassador = true;
  }

// edit profile picture
  public static void editProfPic(Account acc, File file) {
    Picture newProfPic = new Picture(file);
    acc.pic = newProfPic;
  }


// returns a string array of interests associated with given Account
  public static String[] interestList(Account acc) {
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

// unit testing
  public static void main(String[] args) {
/*    HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();
    HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();
    RedBlackBST<String, String> loginInfo = new RedBlackBST<String, String>();
    RedBlackBST<String, String> userToPass = new RedBlackBST<String, String>();
    countries_Database.put("USA", new LinkedList<Integer>());
    countries_Database.put("All", new LinkedList<Integer>());
    countries_Database.put("China", new LinkedList<Integer>());

    Account warrenelwood12 = new Account("Warren", "Elwood", "USA", "warren@gmail.com",
                                         "warrenelwood12", "password12", true, new Picture(args[0]), 000000000,
                                         countries_Database, interests_Database, loginInfo, userToPass);
    Account zkyu2 = new Account("Kelvin", "Yu", "China", "kelly@gmail.com",
                                "zkyu2", "kobebryant24", true, new Picture(args[1]), 000000001,
                                countries_Database, interests_Database, loginInfo, userToPass);
    Account nturk12 = new Account("Nick", "Turk", "USA", "nickturk@gmail.com",
                                  "nturk12", "rogerfreder33", true, new Picture(args[0]), 000000002,
                                  countries_Database, interests_Database, loginInfo, userToPass);
    Account lynna_xia = new Account("Hong", "Xia", "China", "blueberry@gmail.com",
                                    "lynna_xia", "password3", false, new Picture(args[1]), 000000003,
                                    countries_Database, interests_Database, loginInfo, userToPass);

    warrenelwood12.addInterest("Food", interests_Database);
    warrenelwood12.addInterest("Fortnite", interests_Database);
    warrenelwood12.addInterest("Lebron James", interests_Database);
    warrenelwood12.addInterest("Drums", interests_Database);
    warrenelwood12.addInterest("Music", interests_Database);

    LinkedList<Integer> foodAccounts = interests_Database.get("Food");
    LinkedList<Integer> allAccounts = countries_Database.get("All");
    for (int a : foodAccounts)
      System.out.println(a);
    for (int b : allAccounts)
      System.out.println(b);
    System.out.println(toCountryString("All", countries_Database)); */
  }

}
