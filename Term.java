/******************************************************************************
*  Name:    Kelvin Yu
*  NetID:   zkyu
*  Precept: P02A
*
*  Partner Name:    N/A
*  Partner NetID:   N/A
*  Partner Precept: N/A
*
* Description: Term represents an autocomplete term - a query string and an
* associated integer weight. The following API supports comparing terms by
* three different orders: lexicographic order by query string (the natural
* order); in descending order by weight (an alternate order); and
* lexicographic order by query string but using only the first r characters.
*****************************************************************************/
// check whether two byPrefixOrder() comparators can be created at the same time
import java.util.Comparator;

public class Term implements Comparable<Term> {

    private final String query; // String component
    private final long weight; // Weight component

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0)
        throw new java.lang.IllegalArgumentException("Illegal arguments!");
        this.query = query;
        this.weight = weight;
    }
    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new TermComparator();
    }

    private static class TermComparator implements Comparator<Term> {

        public int compare(Term first, Term second) {
            if (first.weight < second.weight)
            return 1;
            if (first.weight > second.weight)
            return -1;
            else
            return 0;
        }
    }
    // Compares the two terms in lexicographic order but using only the first
    // r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0)
        throw new java.lang.IllegalArgumentException("Negative number!");
        return new AlternateComparator(r);
    }

    private static class AlternateComparator implements Comparator<Term> {
        private final int maximum; // maximum index of character compares

        // constructs comparator interface for byPrefixOrder
        public AlternateComparator(int r) {
            maximum = r;
        }

        public int compare(Term first, Term second) {
            int length1 = first.query.length();
            int length2 = second.query.length();
            int threshold = Math.min(length1, length2);

            // case when r is <= than both of the terms.length
            if (maximum <= threshold) {
                for (int i = 0; i < maximum; i++) {
                    if (first.query.charAt(i) - second.query.charAt(i) > 0)
                    return 1;
                    else if (first.query.charAt(i) - second.query.charAt(i) < 0)
                    return -1;
                }
            }

            // case when r is greater than the length of one of the terms
            if (maximum > threshold) {
                for (int i = 0; i < threshold; i++) {
                    if (first.query.charAt(i) - second.query.charAt(i) > 0)
                    return 1;
                    if (first.query.charAt(i) - second.query.charAt(i) < 0)
                    return -1;
                }
                if (length1 > length2)
                return 1;
                if (length1 < length2)
                return -1;
            }
            return 0;
        }
    }
    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return (query.compareTo(that.query));
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toFullString() {
        return (weight + "\t" + query);
    }

    // Returns a string representation of the query
    public String toString() {
        return query;
    }
    // unit testing (required)
    public static void main(String[] args) {
        Term test1 = new Term("Do", 3);
        Term test2 = new Term("Dogcatcher", 1);
        Term test3 = new Term("I am a freak.", 1);

        Comparator<Term> alternate = byPrefixOrder(3);
        Comparator<Term> reverse = byReverseWeightOrder();
        StdOut.println(alternate.compare(test2, test1));
        StdOut.println(reverse.compare(test3, test2));
        StdOut.println(test2.compareTo(test1));
        StdOut.println(test1.toString());
    }
}
