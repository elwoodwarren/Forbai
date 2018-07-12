import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Search {
  private static Object[] matches; // matches

  public static Object[] search(String country, String interest, HashMap<String, LinkedList<Integer>> countries_Database,
                                HashMap<String, LinkedList<Integer>> interests_Database) {
    matches = new Object[30];
    // check if interest and countries exists
    if (!interests_Database.containsKey(interest))
      return null;


    // get all accounts associated with input country and interest
    LinkedList<Integer> countryAccounts = countries_Database.get(country);
    LinkedList<Integer> interestAccounts = interests_Database.get(interest);

// TODO: DELETE MATCHED ACCOUNTS AND ADD TO END OF LIST

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
}
