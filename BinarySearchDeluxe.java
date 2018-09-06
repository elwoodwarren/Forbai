/******************************************************************************
  *  Name:    Kelvin Yu
  *  NetID:   zkyu
  *  Precept: P02A
  *
  *  Partner Name:    N/A
  *  Partner NetID:   N/A
  *  Partner Precept: N/A
  *
  *  Description: Given a sorted array, write a Binary Search API that returns
  * either the first or last index of the provided key, depending on the
  * method called.
  *****************************************************************************/
import java.util.Comparator;

public class BinarySearchDeluxe {

// Returns the index of the first key in a[] that equals the search key, or -1
    // if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key>
                                         comparator) {
        if (a == null || key == null || comparator == null)
            throw new java.lang.IllegalArgumentException("Illegal Arguments!");

        // if array is empty
        if (a.length == 0)
            return -1;

        int low = 0;
        int high = a.length - 1;
        int middle = low + (high - low)/2;
        int storage = -1;

        // find an index with the key
        while (high >= low) {
            middle = low + (high - low)/2;
            int indicator = comparator.compare(key, a[middle]);
            if (indicator < 0) {
                high = middle - 1;
            }
            else if (indicator > 0) {
                low = middle + 1;
            }
            else {
                storage = middle;
                high = middle - 1;
            }
        }
        return storage;
    }
    // Returns the index of the last key in a[] that equals the search key, or
    // -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key>
                                        comparator) {
        if (a == null || key == null || comparator == null)
            throw new java.lang.IllegalArgumentException("Illegal Arguments!");

// if array is empty
        if (a.length == 0)
            return -1;

        int low = 0;
        int high = a.length - 1;
        int middle = low + (high - low)/2;
        int storage = -1;

        // find an index with the key
        while (high >= low) {
            middle = low + (high - low)/2;
            int indicator = comparator.compare(key, a[middle]);
            if (indicator < 0) {
                high = middle - 1;
            }
            else if (indicator > 0) {
                low = middle + 1;
            }
            else {
                storage = middle;
                low = middle + 1;
            }
        }
        return storage;
    }
    // Test integer comparator
    private static Comparator<Integer> byIntValue() {
        return new IntComparator();
    }
    // Comparator interface
    private static class IntComparator implements Comparator<Integer> {
        public int compare(Integer v1, Integer v2) {
            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
            else return 0;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Integer[] test = {0};
        StdOut.println(BinarySearchDeluxe.firstIndexOf(test, 0, byIntValue()));
        StdOut.println(BinarySearchDeluxe.lastIndexOf(test, 0, byIntValue()));
    }
}
