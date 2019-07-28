import java.util.Arrays;


/**
 * Partition sub-routine:
 *
 * Input: [7, 3, 1, 3, 6, 2, 3]
 * 
 * pivot = 3
 *  
 *  i
 *  f                 b
 * [7, 3, 1, 3, 6, 2, 3]
 *           |
 *  i
 *  f              b   
 * [3, 3, 1, 3, 6, 2, 7]
 *           |
 *  f  i           b   
 * [3, 3, 1, 3, 6, 2, 7]
 *           |
 *  f     i        b   
 * [3, 3, 1, 3, 6, 2, 7]
 *           |
 *     f     i     b   
 * [1, 3, 3, 3, 6, 2, 7]
 *           |
 *     f        i  b  
 * [1, 3, 3, 3, 6, 2, 7]
 *           |
 *              i
 *     f        b
 * [1, 3, 3, 3, 2, 6, 7]
 *           |
 *        f     b  i
 * [1, 2, 3, 3, 3, 6, 7]
 *
 * END
 */
public class QuickSort {
    /**
     * Case Analysis:
     * 1. `0` ~ `low - 1` is the part which `< pivot`.
     * 2. `low` ~ `high` is the part which `==pivot`.
     * 3. `high + 1` ~ `n - 1` is the part which `> pivot`.
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
        int[] bound = partition(array, low, high);
        quicksort(array, low, bound[0] - 1);
        quicksort(array, bound[0] + 1, high);
    }

    private static int[] partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        while(i <= high) {
            if(array[i] < pivot) {
                swap(array, low++, i++);
            } else if (array[i] == pivot) {
                i++;
            } else {
                swap(array, high--, i);
            }
        }
        return new int[]{low, high};
    }


    private static void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

    public static void main(String[] args) {
        int[] array = {85, 6, 57, 60, 83, 73, 72};
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = {7, 3, 1, 3, 6, 2, 3};
        QuickSort.partition(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
