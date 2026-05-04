/*Divide and conquer */

public class MergeSort {
    public static int mergeSort(int[] arr) {
        int inputLength = arr.length;
        int num_comparisons = 0;

        // empty array or just one element in the array
        if (inputLength < 2) {
            return 0;
        }

        // 2 or more elements in the array-divide array(need to get midpt)
        int midIndex = inputLength / 2;
        int[] lefthalf = new int[midIndex];
        int[] righthalf = new int[inputLength - midIndex];

        // populating the right half
        for (int i = 0; i < midIndex; i++) {
            lefthalf[i] = arr[i];
        }

        // populating the left half
        for (int i = midIndex; i < inputLength; i++) {
            righthalf[i - midIndex] = arr[i];
        }

        // how to mergesort our lefthalf and righthalf
        // mergesort method- we will simply recursively call it

        num_comparisons += mergeSort(lefthalf);
        num_comparisons += mergeSort(righthalf);

        num_comparisons += merge(arr, lefthalf, righthalf);

        return num_comparisons;

        // now we have 2 sorted halves
        // last step-merge those halves together

    }

    private static int merge(int[] inputArray, int[] lefthalf, int[] righthalf) {
        int leftsize = lefthalf.length;
        int rightsize = righthalf.length;

        // the confusing part
        // we will be needing 3 iterator variables
        // one traversing through lefthalf array-righthalf array-merged array

        int i = 0, j = 0, k = 0;// the three iterators
        int num_comparisons = 0;

        while (i < leftsize && j < rightsize) {
            num_comparisons++;
            if (lefthalf[i] <= righthalf[j]) {// element of lefthalf is smaller
                inputArray[k] = lefthalf[i];// smallest el of lefthalf has been added to merged array
                i++;// increment i to look at the other elements as well
            } else {
                inputArray[k] = righthalf[j];
                j++;

            }
            k++;
        }
        // remaining elements of either right or left halves-add to merged array(k)
        while (i < leftsize) {
            inputArray[k] = lefthalf[i];
            i++;
            k++;
        }

        while (j < rightsize) {
            inputArray[k] = righthalf[j];
            j++;
            k++;
        }

        return num_comparisons;

    }

}