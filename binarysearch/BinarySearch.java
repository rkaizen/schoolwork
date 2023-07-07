import java.util.Comparator;

public class BinarySearch {

// Common description of the below functions:
// * Precondition: `a` is sorted according to the given comparator.
// * Precondition: all arguments are non-null (no need to check).
// * Required complexity: O(log(n)) comparisons where n is the length of `a`.


    public static <T> boolean binarySearch(T[] array, int startIndex, int endIndex, T key, Comparator<T> comparator){

        if (array.length < 1){
            return false;
        }
       
        int mid = (startIndex + endIndex) / 2;

        int keyMidCompareResult = comparator.compare(key, array[mid]);

        if (keyMidCompareResult == 0){

            return true;

        }

        if ((startIndex - endIndex) == 0){

            return false;

        }

        if (keyMidCompareResult > 0){

            startIndex = mid + 1;

            return binarySearch(array, startIndex, endIndex, key, comparator);

        } else if (keyMidCompareResult < 0){

            if (endIndex - startIndex == 1){

                return false;

            }

            endIndex = mid - 1;

            return binarySearch(array, startIndex, endIndex, key, comparator);

        }

        return false;

    }

    // Check if the array `a` contains the given search key.
    public static <T> boolean contains(T[] a, T key, Comparator<T> comparator) {

        boolean doesContainKey = binarySearch(a, 0, a.length - 1, key, comparator);

        return doesContainKey;

    }

    // Return the *first position* of `key` in `a`, or -1 if `key` does not occur.
    public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {

        int startIndex = 0;

        int endIndex = a.length - 1;

        int mid;

        int keyMidCompareResult;

        int foundItemIndex = -1;

        while (endIndex - startIndex != -1){

            mid = (startIndex + endIndex) / 2;

            keyMidCompareResult = comparator.compare(key, a[mid]);

            if (keyMidCompareResult == 0){

            foundItemIndex = mid;

            endIndex = mid - 1;

            } else if (keyMidCompareResult > 0) {

            startIndex = mid + 1;

            } else {

            endIndex = mid - 1;

            }

        }

        return foundItemIndex;

    }

    // Versions of the above functions that use the natural ordering of the type T.
    // T needs to be "comparable" (i.e., implement the interface Comparable).
    // Examples: Integer, String (the alphabetic ordering)

    public static <T extends Comparable<? super T>> boolean contains(T[] a, T key) {
        return contains(a, key, Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> int firstIndexOf(T[] a, T key) {
        return firstIndexOf(a, key, Comparator.naturalOrder());
    }

    // Your tests.

    public static void main(String[] args) {
        Integer[] a = { 1, 3, 5, 7, 9 };
        assert contains(a, 1);
        assert !contains(a, 4);
        assert contains(a, 7);

        String[] b = { "cat", "cat", "cat", "dog", "turtle", "turtle" };
        assert firstIndexOf(b, "cat") == 0;
        assert firstIndexOf(b, "dog") == 3;
        assert firstIndexOf(b, "turtle") == 4;
        assert firstIndexOf(b, "zebra") == -1;
        assert firstIndexOf(b, "bee") == -1;
    }

}
