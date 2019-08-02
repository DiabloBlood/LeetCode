import java.util.Arrays;



public class MergeSort {
    
    public static void sort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        mergeSort(array, 0, array.length - 1);
    }
    
    private static void mergeSort(int[] array, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    /**
     * Case Analysis:
     *     1. i <= mid && j <= end && a[i] < a[j];  --> temp[k] = a[i++];
     *     2. i <= mid && j > end;                  --> temp[k] = a[i++];
     *     3. i <= mid && j <= end && a[i] >= a[j]; --> temp[k] = a[j++];
     *     4. i > mid && j <= end;                  --> temp[k] = a[j++];
     *     5. i > mid && j > end; //do nothing, loop already finished.
     */  
    private static void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;
        int[] temp = new int[n];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (k = 0 ; k < n ; k++) {
            array[low + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
