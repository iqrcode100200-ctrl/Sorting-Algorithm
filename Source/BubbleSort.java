/*This sorting algorithm repeatedly compares adjacent elements abd swaps them if 
ever they are in the wrong order and therefore the largest value happens to be 
at the end of every pass- it bubbles up
 */

public class BubbleSort {
    public static int bubbleSort(int[] array) {
        int num_comparisons = 0;

        for (int i = 0; i < array.length; i++) {// the first element
            for (int j = 0; j < array.length - i - 1; j++) {// i shortens the comparison

                // increment compariosns every time adjacent elements are being compared
                num_comparisons++;

                if (array[j] > array[j + 1]) {// comparing adjacent elements
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return num_comparisons;
    }
}
