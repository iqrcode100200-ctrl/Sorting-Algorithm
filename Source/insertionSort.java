/*This sorting algorithm takes one element
and inserts it into the correct position in
the already sorted part of the array
 */

public class InsertionSort {
    public static int insertionSort(int[] array) {
        // for loop to travers through the array
        int num_comparisons = 0;

        for (int i = 1; i < array.length; i++) {// index(0) is sorted
            // take curr val and copy it to temporary val
            int currVal = array[i];
            // walk from curr element to back from beginning
            int j = i - 1;// compare with previous el

            num_comparisons++;

            // condition for swapping
            while (j >= 0 && array[j] > currVal) {
                // stop once we hit the beginning of the array
                array[j + 1] = array[j];
                j--;// (3,1) -> (1,3)
            }
            array[j + 1] = currVal;
        }

        return num_comparisons;
    }
}