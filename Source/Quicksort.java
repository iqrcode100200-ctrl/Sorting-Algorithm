/*
-Divide and conquer
-chooses a pivot
-places smaller elements in the left
-places larger elements in the right
*/

public class QuickSort {
    public static int quickSort(int[] arr, int lowIndex, int highIndex) {

        int num_comparisons = 0;

        // when there is only one element left- already ordered (corner case)
        if (lowIndex >= highIndex) {
            return 0;
        }

        // choose pivot (last element)
        int pivot = arr[highIndex];

        // partitioning - 2 variables (left pointer and right pointer)
        // lp - walks through the array until we find a num larger than the pivot
        // rp - walks through the array until we find a num smaller than the pivot
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1; // exclude pivot

        // loop to move lp and rp until they cross each other
        while (leftPointer <= rightPointer) {

            // walking from the left
            while (leftPointer <= rightPointer && arr[leftPointer] <= pivot) {
                num_comparisons++; // counting comparison
                leftPointer++;
            }

            // walking from the right
            while (leftPointer <= rightPointer && arr[rightPointer] >= pivot) {
                num_comparisons++; // counting comparison
                rightPointer--;
            }

            // swapping the elements that are at leftPointer and rightPointer
            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }
        }

        // swap our pivot into its correct position
        swap(arr, leftPointer, highIndex);

        /*
         * After placing the pivot, the array is divided into two parts:
         * 
         * Left side of the pivot → unsorted, but all values ≤ pivot
         * Right side of the pivot → unsorted, but all values ≥ pivot
         */

        // recursively sorting the left and right partitions
        num_comparisons += quickSort(arr, lowIndex, leftPointer - 1); // left side
        num_comparisons += quickSort(arr, leftPointer + 1, highIndex); // right side

        return num_comparisons;
    }

    // swapping method
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}