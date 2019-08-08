


class Solution274 {
    /**
     *
     * Time: Avg O(2n), Totol operations = `n + n/2 + n/4 + n/8 + n/16 ...` = `2n`.
     *       Worst O(n^2), `n + n-1 + n-2 +...+1` = `n^2/2`, which array is already sorted.
     *       Worst case example, input is [8, 9, 10, 11, 12, 13, 14], hIndex is 7
     * Space: O(1), please notes that Quick Selection Algorithm don't use recursion.
     */
    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int hIndex = 0;
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = partition(citations, left, right);
            if (citations[mid] >= n - mid) {
                hIndex = n - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return hIndex;
    }
    
    private int partition(int[] array, int low, int high) {
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
    
    private void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

    /**
     * Example: input [0, 1, 4, 5, 6], hIndex = 3
     * 
     * Case Analysis:
     *    1. a[i] >= n - i; --> hIndex = n - i;
     *    2. a[i] <  n - i; --> break;
     *  
     * Time:  O(n*logn)
     * Space: O(1)
     */
    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int n = citations.length;
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] < n - i) {
                break;
            }
            hIndex = n - i;
        }
        return hIndex;
    }
}
