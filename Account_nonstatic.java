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
  public Account(String first, String last, String country, String email,
                 String username, String password, boolean gender,
                 Picture pic, int id, HashMap<String, LinkedList<Integer>> countries_Database, HashMap<String, LinkedList<Integer>> interests_Database,
                 RedBlackBST<String, String> loginInfo, RedBlackBST<String, String> userToPass) {
    // check if username and email are available
    if (loginInfo.contains(email))
      throw new IllegalArgumentException("Email already taken!");
    if (userToPass.contains(username))
      throw new IllegalArgumentException("Username already taken!");

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
    this.id = id; // assign special id # to this account
    loginInfo.put(email, password);
    userToPass.put(username, password);

    LinkedList<Integer> countryAccs = countries_Database.get(country);
    LinkedList<Integer> allAccs = countries_Database.get("All");
    countryAccs.add(id);
    allAccs.add(id);
    countries_Database.put(country, countryAccs);
    countries_Database.put("All", allAccs);

    if (interests_Database.get("All") == null) {
      LinkedList<Integer> newAcc = new LinkedList<Integer>();
      newAcc.add(id);
      interests_Database.put("All", newAcc);
    }
    interests_Database.put("All", allAccs);
  }

// when user adds an interest, add it to hashmap (returns false if interest is null)
  public boolean addInterest(String interest, HashMap<String, LinkedList<Integer>> interests_Database) {
// check if interest is valid
    if (interest == null)
      return false;
// if interest is not on hashmap, add it
    else if (interests_Database.get(interest) == null) {
      LinkedList<Integer> newAcc = new LinkedList<Integer>();               // update database
      newAcc.add(id);
      interests_Database.put(interest, newAcc);


      for (int i = 0; i < interests.length; i++) {                            // update account's interests
        if (interests[i] == null) {
          interests[i] = interest;
          break;
        }
      }
      return true;
    }
    // otherwise add it to hashmap and update accounts
    else {
      LinkedList<Integer> interestAccount = interests_Database.get(interest); // update database
      interestAccount.add(id);
      interests_Database.put(interest, interestAccount);
      for (int i = 0; i < interests.length; i++) {                            // update account's interests
        if (interests[i] == null) {
          interests[i] = interest;
          break;
        }
      }
      return true;
    }
  }

// remove an interest (returns true if interest exist, false if interest doesn't exist)
  public boolean removeInterest(String interest, HashMap<String, LinkedList<Integer>> interests_Database) {
    // check if interest is valid
    if (interest == null || interests_Database.get(interest) == null)
      return false;

    LinkedList<Integer> interestAccounts = interests_Database.get(interest);
    if (!interestAccounts.contains(id) || interestAccounts.size() == 0)
      return false;
    interestAccounts.removeFirstOccurrence(id);                             // update database
    interests_Database.put(interest, interestAccounts);
    for (int i = 0; i < interests.length; i++) {                            // update account's interests
      if (interests[i] == null)
        continue;
      if (interests[i].equals(interest)) {
        interests[i] = null;
        break;
      }
    }
    return true;
  }

  // change email
  public void changeEmail(String newEmail, RedBlackBST<String, String> loginInfo) {
    loginInfo.delete(email);
    this.email = newEmail;
    loginInfo.put(newEmail, this.password);
  }

  // change username
  public void changeUsername(String newUser, RedBlackBST<String, String> userToPass) {
    userToPass.delete(username);
    this.username = newUser;
    userToPass.put(newUser, this.password);
  }

  // change password
  public void changePassword(String newPass, RedBlackBST<String, String> loginInfo, RedBlackBST<String, String> userToPass) {
    this.password = newPass;
    userToPass.put(this.username, newPass);
    loginInfo.put(this.email, newPass);
  }

  public String showUser() {
    return this.username;
  }

  public String showPass() {
    return this.password;
  }

  public String showEmail() {
      return this.email;
  }

  public Account makeAmbassador(Account acc) {
    acc.ambassador = true;
    return acc;
  }

// edit profile picture
  public void editProfPic(File file) {
    Picture newProfPic = new Picture(file);
    pic = newProfPic;
  }


// returns a string array of interests associated with given Account
  public String[] interestList() {
    return interests;
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
    HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();
    HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();
    RedBlackBST<String, String> loginInfo = new RedBlackBST<String, String>();
    RedBlackBST<String, String> userToPass = new RedBlackBST<String, String>();
    countries_Database.put("USA", new LinkedList<Integer>());
    countries_Database.put("All", new LinkedList<Integer>());
    countries_Database.put("China", new LinkedList<Integer>());

    /*  LinkedList<Integer> chinaAccounts = new LinkedList<Integer>();
     LinkedList<Integer> foodAccounts = new LinkedList<Integer>();
     chinaAccounts.add(0);
     chinaAccounts.add(1);
     chinaAccounts.add(3);
     foodAccounts.add(0);
     foodAccounts.add(1);
     foodAccounts.add(2);
     countries_Database.put("China", chinaAccounts);
     interests_Database.put("Food", foodAccounts); */

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
    System.out.println(toCountryString("All", countries_Database));
  }

}
