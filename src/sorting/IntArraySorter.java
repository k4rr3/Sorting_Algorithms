package sorting;

/**
 * This class contains methods relaytes tothe sorting of arrays of integers.
 *
 * @author jmgimeno
 */

public class IntArraySorter {

    private final int[] array;

    /**
     * Constructs an instance of the class.
     *
     * @param array the array to be sorted.
     */
    public IntArraySorter(int[] array) {
        this.array = array;
    }

    /**
     * Utility method to check is the array is sorted.
     *
     * @return a boolean telling if the array is sorted or not.
     */
    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Swaps the values at two positions in the array.
     * <p>
     * If either {@code i} or {@code j} are invalid positions in the array,
     * it throws {@code java.lang.ArrayIndexOutOfBoundsException}
     *
     * @param i index of one of the positions
     * @param j index of the other
     */
    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Sorts the array using the insertion sort algorithm.
     */
    public void insertionSort() {
        // Invariant: The prefix [0, end) is a sorted array
        for (int end = 1; end < array.length; end++) {
            // We insert element at end into this prefix

            // Invariant: arrays sorted in the ranges [0, insert)
            // and [insert, end] and all elements in [0, insert)
            // are lower than or equal to those in [insert+1, end]

            for (int insert = end; insert >= 1; insert--) {
                if (array[insert - 1] > array[insert]) {
                    swap(insert - 1, insert);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Sorts the array using the bubble sort algorithm.
     */
    public void bubbleSort() {
        // TODO
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = len - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {

                    swap(j, j - 1);
                }
            }
        }
       /* if (array.length > 1) {
            bubbleSortRecursive(0);
        }*/
    }

    private void bubbleSortRecursive(int sorted) {

        int arrayLength = array.length;
        int swaps = 0;
        for (int i = arrayLength - 1; i > sorted; i--) {
            if (array[i] < array[i - 1]) {
                swap(i, i - 1);
                swaps += 1;
            }
        }
        if (swaps != 0) {
            bubbleSortRecursive(sorted + 1);
        }


    }

    /*
     * Sorts the array using the selection sort algorithm.
     */
    public void selectionSort() {
        // TODO
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++)
                if (array[j] < array[min])
                    min = j;
            swap(min, i);
        }
       /* if (array.length > 1) {
            selectionSortRecursive(0);
        }*/
    }

    private void selectionSortRecursive(int pos) {
        if (pos <= array.length - 1) {
            int min = pos;
            boolean found = false;
            for (int i = pos; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                    found = true;
                }
            }
            if (found && pos < array.length - 1) {
                swap(pos, min);
            }
            selectionSortRecursive(pos + 1);
        }
    }

    /*
     * Sorts the arry using the quicksort algortithm.
     */
    public void quickSort() {
        // TODO: Remove throw and uncomment call
        //throw new UnsupportedOperationException("TODO");
        quickSort(0, array.length);
    }

    private void quickSort(int left, int right) {
        // DO NOT MODIFY !!!!
        // 0 <= left <= right <= array.length
        if (right - left > 1) {
            int pivotPos = left + (right - left) / 2;
            int pivotValue = array[pivotPos];
            swap(left, pivotPos);
            int pos = partitionIterative(pivotValue, left + 1, right);
            swap(left, pos - 1);
            quickSort(left, pos - 1);
            quickSort(pos, right);
        }
    }

    private int partitionRecursive(int pivotValue, int inf, int sup) {
        // DO NOT USE -> create an iterative version which does the same
        // 0 <= left <= inf <= sup <= right <= v.length
        if (inf == sup) {
            return inf;
        } else if (array[inf] <= pivotValue) {
            return partitionRecursive(pivotValue, inf + 1, sup);
        } else if (array[sup - 1] > pivotValue) {
            return partitionRecursive(pivotValue, inf, sup - 1);
        } else {
            swap(inf, sup - 1);
            return partitionRecursive(pivotValue, inf + 1, sup - 1);
        }
    }

    private int partitionIterative(int pivotValue, int inf, int sup) {
        // TODO

        int i = (inf - 1);
        for (int j = inf; j <= sup - 1; j++) {
            if (array[j] <= pivotValue) {
                i++;

                swap(i, j);
            }

        }
        return i + 1;

    }
}