package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {

         int aLength = a.length;

         // base case: arrays with 0 or 1 elements are already sorted
        if (aLength < 2) {
            return;
        }

        // split the array into 2 halves
        int midIndex = aLength / 2;
        T[] leftHalf  = (T[]) new Object[midIndex]; // create left half from start to middle
        T[] rightHalf = (T[]) new Object[aLength - midIndex]; // create right half from middle to end

        // copy elements from original array into left half
        for (int i = 0; i < midIndex; i++) { // loop from 0 to the length of our left half
            leftHalf[i] = a[i];
        }

        // copy elements from original array into right half
        for (int i = midIndex; i < aLength; i++) { // loop from middle to end of original array
            rightHalf[i - midIndex] = a[i]; // Subtract midIndex to start at index 0 in rightHalf
        }

        // recursive call to sort both halves
        sort(leftHalf, comp);
        sort(rightHalf,  comp);

        // merge the 2 sorted halves back into original array
        merge(a, leftHalf, rightHalf, comp);
    }

    private <T> void merge(T[] result, T[] left, T[] right, Comparator<? super T> comp) {
        // track our current position in array
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // while both arrays have elements left to compare
        while (leftIndex < left.length && rightIndex < right.length) {

                // compare the current elements from left and right arrays
                if (comp.compare(left[leftIndex], right[rightIndex]) <= 0) {
                    // left element is smaller or equal, so pick it
                    result[resultIndex] = left[leftIndex];
                    leftIndex++;
                }
                else {
                    // right element is smaller, sppick it
                    result[resultIndex] = right[rightIndex];
                    rightIndex++;
                }
                resultIndex++; // move to next position in result array
            }

        // copy any elements from left array if right array runs out of elements first
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        // copy any elements from right array if left array runs out of elements first
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }
    }
}
