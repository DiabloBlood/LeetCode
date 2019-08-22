


class Solution315 {
    /**
     * Problem Analysis：
     *     1. Find the inverse number during merge sort
     *     2. Sort the array index instead of array.
     * 
     * Case Analysis:
     *     1. i <= mid && j <= high && a[i] < a[j];  --> temp[k++] = a[i++];
     *     2. i <= mid && j > high;                  --> temp[k++] = a[i++];
     *     3. i <= mid && j <= high && a[i] >= a[j]; --> temp[k++] = a[j++];
     *     4. i > mid && j <= high;                  --> temp[k++] = a[j++];
     *     5. i > mid && j > high; //do nothing, loop already finished.
     *
     * Time:  O(n*logn), generate index array is `n`, result list is `n`, merge sort is `n*logn`.
     * Space: O(2n), index array is `n`, temp array is `n`.
     */  
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(result, nums, index, new int[n], 0, n - 1);
        return result;
    }
    
    private void mergeSort(List<Integer> result, int[] nums, int[] index, int[] temp, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(result, nums, index, temp, low, mid);
        mergeSort(result, nums, index, temp, mid + 1, high);
        merge(result, nums, index, temp, low, mid, high);
    }
    
    private void merge(List<Integer> result, int[] nums, int[] index, int[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int rightCount = 0;
        while (i <= mid && j <= high) {
            if (nums[index[i]] > nums[index[j]]) {
                rightCount++;
                temp[k++] = index[j++];
            } else {
                result.set(index[i], result.get(index[i]) + rightCount);
                temp[k++] = index[i++];
            }
        }
        
        while (i <= mid) {
            result.set(index[i], result.get(index[i]) + rightCount);
            temp[k++] = index[i++];
        }
        
        while (j <= high) {
            temp[k++] = index[j++];
        }

        for (k = low; k <= high ; k++) {
            index[k] = temp[k];
        }
    }
}
