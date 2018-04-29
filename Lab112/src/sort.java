
import java.util.Arrays;

/** Sort algorithms 
 *
 * @author Andrew Vetter
 */
public class sort<K> {

    /**
     * a Stupildy simple bubble sort that takes for ever
     * @param <K>
     * @param data
     * @param comp 
     */
    public static <K> void simpleBubbleSort(K[] data, Comparator<K> comp) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comp.compare(data[j], data[j + 1]) < 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    /**
     * A more efficient bubble sort 
     * @param <K>
     * @param data
     * @param comp 
     */
    public static <K> void effcientBubbleSort(K[] data, Comparator<K> comp) {
        boolean complete;

        for (int i = 0; i < data.length; i++) {
            complete = true;
            for (int j = 0; j < (data.length - 1 - i); j++) {
                if (comp.compare(data[j], data[j + 1]) <= 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    complete = false;
                }
            }
            if (complete) {
                break;
            }
        }
    }

    /**
     * insertion sort alogrithm 
     * @param <K>
     * @param data
     * @param comp 
     */
    public static <K> void insertionSort(K[] data, Comparator<K> comp) {

        K temp;
        int j;
        for (int i = 1; i < data.length; i++) {
            j = i;
            temp = data[j];

            while (j != 0) {
                if (comp.compare(temp, data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                    j++;
                } else {
                    break;
                }
            }
            data[j] = temp;
        }

    }

    /**
     * Selection sort alogrithm 
     * @param <K>
     * @param data
     * @param comp 
     */
    public static <K> void selectionSort(K[] data, Comparator<K> comp) {
        K temp;
        int max;

        for (int i = 0; i < data.length; i++) {
            max = indexOfLargestElement(data, data.length - i, comp);
            temp = data[max];
            data[max] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }

    /**
     * Find the largest element in the data set
     * @param <K>
     * @param data
     * @param length
     * @param comp
     * @return 
     */
    private static <K> int indexOfLargestElement(K[] data, int length, Comparator comp) {
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (comp.compare(data[i], data[index]) < 0) {
                index = i;
            }

        }
        return index;
    }

    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     * @param <K>
     * @param S1
     * @param S2
     * @param S
     * @param comp
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];                     // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++];                     // copy jth element of S2 and increment j
            }
        }
    }

    /**
     * Merge-sort contents of array S.
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return;                        // array is trivially sorted
        }    // divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);   // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);   // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp);                      // sort copy of first half
        mergeSort(S2, comp);                      // sort copy of second half
        // merge results
        merge(S1, S2, S, comp);               // merge sorted halves back into original
    }

    //-------- support for in-place quick-sort of an array --------
    /**
     * Quick-sort contents of a queue.
     * @param <K>
     * @param S
     * @param comp
     */
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSortInPlace(S, comp, 0, S.length - 1);
    }

    /**
     * Sort the subarray S[a..b] inclusive.
     */
    private static <K> void quickSortInPlace(K[] S, Comparator<K> comp,
            int a, int b) {
        if (a >= b) {
            return;                // subarray is trivially sorted
        }
        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp;                            // temp object used for swapping
        while (left <= right) {
            // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && comp.compare(S[left], pivot) < 0) {
                left++;
            }
            // scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right && comp.compare(S[right], pivot) > 0) {
                right--;
            }
            if (left <= right) {             // indices did not strictly cross
                // so swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        // put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        // make recursive calls
        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left + 1, b);
    }
    
    /**
     * sort a collection in the order of index of comp
     * @param <K>
     * @param data
     * @param comp 
     */
    public static <K> void radixSort(K[] data, Comparator[] comp ){
        
        for (Comparator comp1 : comp) {
            mergeSort(data, comp1);
        }
    }

}
