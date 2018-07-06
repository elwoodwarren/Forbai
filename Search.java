import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Search {
  private static Object[] matches; // matches

  public static Object[] search(String country, String interest, HashMap<String, LinkedList<Integer>> countries_Database,
                                HashMap<String, LinkedList<Integer>> interests_Database) {
    matches = new Object[30];
    // check if interest and countries exists
    if (!interests_Database.containsKey(interest))
      return null;


    // get all accounts associated with input country and interest
    HashMap<String, LinkedList<Integer>> interestsCopy = interests_Database;
    LinkedList<Integer> countryAccounts = countries_Database.get(country);
    LinkedList<Integer> interestAccounts = interestsCopy.get(interest);

    // iterate through LinkedLists and find 30 matches
    int count = 0;
    Object[] interestAccountsArray = interestAccounts.toArray();
    for (Object account : interestAccountsArray) {
      if (count >= 30 || count > interestAccountsArray.length - 1)
        break;
      if (countryAccounts.contains(account) && count < 30) {
        matches[count] = account;
        count++;
      }
    }
    return matches;

    /*  random # implementation, doesn't work b/c removing interestAccount values updates it on hashmap too
     // iterate through LinkedLists and find 30 matches
     int count = 0;
     int l = 0;
     while (count < 30 && interestAccounts.size() != 0) {
     int index = (int) (interestAccounts.size() * Math.random());
     if (countryAccounts.contains(interestAccounts.get(index))) {
     matches[l] = interestAccounts.get(index);
     interestAccounts.remove(index);
     l++;
     }
     else
     interestAccounts.remove(index);

     count++;
     }
     return matches; */
  }

  // unit testing
  public static void main(String[] args) {
    HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();
    HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();
    RedBlackBST<String, String> loginInfo = new RedBlackBST<String, String>();
    RedBlackBST<String, String> userToPass = new RedBlackBST<String, String>();

    Account warrenelwood12 = new Account("Warren", "Elwood", "USA", "warren@gmail.com",
                                         "warrenelwood12", "password12", true, new Picture(args[0]), 000000000,
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

    Object[] matches0 = search("All", "Food", countries_Database, interests_Database);                       // test Search
    System.out.println("All countries, food interest: " + Arrays.toString(matches0));

  }
}
