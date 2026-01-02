package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement insertion sort
        for (int i = 1; i < a.length; i++) {
            T currentValue = a[i]; // store the current value to insert

            int j = i - 1; // index to walk back thru the sorted portion

            // shift elements greater than sorted value to the right
            while (j >= 0 && comp.compare(a[j], currentValue) > 0) {
                a[j + 1] = a[j]; // shift element one position to the right
                j--; // keep moving toward beginning of array
            }
            a[j + 1] = currentValue; // insert current value into correct spot
        }
    }
}
