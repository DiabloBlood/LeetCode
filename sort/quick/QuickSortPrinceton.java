import java.util.Arrays;


/**
 * Partition sub-routine:
 *
 * Input: [7, 3, 1, 3, 6, 2, 3]
 * 
 * pivot = 3
 *
 *  i
 *  j
 * [7, 3, 1, 3, 6, 2, 3]
 *           |  
 *  i  j 
 * [7, 3, 1, 3, 6, 2, 3]
 *           |
 *     i  j 
 * [3, 7, 1, 3, 6, 2, 3]
 *           |
 *        i  j
 * [3, 1, 7, 3, 6, 2, 3]
 *           |
 *           i  j
 * [3, 1, 3, 7, 6, 2, 3]
 *           |
 *           i     j
 * [3, 1, 3, 7, 6, 2, 3]
 *           |
 *              i     j
 * [3, 1, 3, 2, 6, 7, 3]
 *           |
 *              i     j
 * [3, 1, 3, 2, 3, 7, 6]
 *
 * END
 */
public class QuickSortPrinceton {
    /**
     * Case Analysis:
     * 1. Any teim `0` ~ `i - 1` is the part which `<= pivot`.
     * 2. Finally `i + 1` ~ `high` is the part which `> pivot`.
     * 3. Finally `i` position is pivot.
     * 
     * Time:  Best  O(nlogn)
     *        Worst O(n^2 / 2) if the array is already sorted. The recursive tree is a flat list tree.
     * Space: Best  O(logn)
     *        Worst O(n)
     */
    public static void sort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int bound = partition(array, low, high);
        quicksort(array, low, bound - 1);
        quicksort(array, bound + 1, high);
    }
    
    /**
     * Code Analysis:
     * 1. Why `array[j] <= pivot` instead of `array[j] < pivot`?
     *    Answer: If `array[j] <= pivot`, then `0` ~ `i - 1` is the part which `<= pivot`, `i + 1` ~ `high` is the part which `> pivot`.
     *.           If  `array[j] < pivot`, then `0` ~ `i - 1` is the part which `< pivot`, `i + 1` ~ `high` is the part which `>= pivot`.
     * 2. What is the last 2 line `swap(array, i, high);` mean?
     *    Answer: To guarantee finally the position `i` value is pivot.
     */
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i++, j);
            }
        }
        swap(array, i, high);
        return i;
    }

    private static void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {85, 6, 57, 60, 83, 73, 72};
        QuickSortPrinceton.sort(array);
        System.out.println(Arrays.toString(array));
        //int[] array2 = new int[] {7, 3, 1, 3, 6, 2, 3};
        int[] array2 = new int[] {2, 1, 0, 2, 1, 0, 1};
        System.out.println(QuickSortPrinceton.partition(array2, 0, array2.length - 1));
        System.out.println(Arrays.toString(array2));
    }
}
