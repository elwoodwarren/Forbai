/******************************************************************************
  *  Name:    Kelvin Yu
  *  NetID:   zkyu
  *  Precept: P02A
  *
  *  Partner Name:    N/A
  *  Partner NetID:   N/A
  *  Partner Precept: N/A
  *
  * Description: Implement autocomplete function for a given set of Terms.
  * To do so, sort the terms in lexicographic order with Term.java methods; use
  * binary search to find the all query strings that start with a given prefix;
  * and sort the matching terms in descending order by weight.
  *****************************************************************************/
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Autocomplete {

    private final Term[] autoterm; // array of Term values

    // autocomplete, call everytime user types a new letter when typing an interest to search
    public static Term[] autocomplete(String prefix, HashMap<String, LinkedList<Integer>> interests_Database) {
        Term[] words = new Term[interests_Database.size()];
        int counter = 0;
        for (String i : interests_Database.keySet()) {
            words[counter] = new Term(i, 0);
            counter++;
        }

        Autocomplete acTest = new Autocomplete(words);
        Term[] matches = acTest.allMatches(prefix);
        return matches;
    }

// Constructor, initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null)
            throw new java.lang.IllegalArgumentException("Null argument.");

        autoterm = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            if (terms[i] == null)
                throw new java.lang.IllegalArgumentException("Null argument.");
            autoterm[i] = terms[i];
        }
        Arrays.sort(autoterm);
    }

    // Returns all terms that start with the given prefix, in descending order
    // of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null)
            throw new java.lang.IllegalArgumentException("Null search term.");

        Comparator<Term> comp = Term.byPrefixOrder(prefix.length());
        Term search = new Term(prefix, 0);
        int firstindex = BinarySearchDeluxe.firstIndexOf(autoterm, search, comp);
        int lastindex = BinarySearchDeluxe.lastIndexOf(autoterm, search, comp);

        if (firstindex < 0 || lastindex < 0) {
            Term[] empty = new Term[0];
            return empty;
        }
// puts all matching terms into array matchFinder
        Term[] matchFinder = new Term[lastindex - firstindex + 1];
        for (int i = 0; i < lastindex - firstindex + 1; i++) {
            matchFinder[i] = autoterm[firstindex+i];
        }

// sorts matchfinder based on descending order
        Comparator<Term> descend = Term.byReverseWeightOrder();
        Arrays.sort(matchFinder, descend);
        return matchFinder;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null)
            throw new java.lang.IllegalArgumentException("Null search term.");

        Comparator<Term> comp = Term.byPrefixOrder(prefix.length());
        Term search = new Term(prefix, 0);

        int firstindex = BinarySearchDeluxe.firstIndexOf(autoterm, search, comp);
        int lastindex = BinarySearchDeluxe.lastIndexOf(autoterm, search, comp);
        if (firstindex < 0 || lastindex < 0) {
            return 0;
        }
        return (lastindex - firstindex + 1);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Term[] test = new Term[9];
        test[0] = new Term("Hel", 3);
        test[1] = new Term("Hellooo", 3);
        test[2] = new Term("He", 3);
        test[3] = new Term("Boo", 3);
        test[4] = new Term("Hel", 3);
        test[5] = new Term("Hello", 3);
        test[6] = new Term("Hello", 3);
        test[7] = new Term("Fast", 3);
        test[8] = new Term("Warrior", 3);
        Autocomplete autotest = new Autocomplete(test);
        Term[] temp = autotest.allMatches("Hel");
        for (int i = 0; i < temp.length; i++)
            StdOut.println(temp[i]);
        StdOut.println("'Hel' has " + autotest.numberOfMatches("Hel") +
                       " matches.");
    }
}
