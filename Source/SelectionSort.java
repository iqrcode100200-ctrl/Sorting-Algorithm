/*This sorting algorithm repeateadly finds the smallest element from the 
unsorted part and places it in the correct position */

public class SelectionSort {
    public static int selectionSort(int[] array) {
        int num_comparisons = 0;
        for (int i = 0; i < array.length; i++) { // outer loop:current index
            int smallest = i; // assume current index is smallest
            for (int j = i + 1; j < array.length; j++) {
                num_comparisons++;
                if (array[j] < array[smallest]) {
                    smallest = j; // found smaller element
                }
            }
            // swap
            int temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
        }
        return num_comparisons;
    }
}