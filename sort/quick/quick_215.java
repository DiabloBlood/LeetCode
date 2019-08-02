


class Solution215 {

    /**
     * Quick Selection Algorithm.
     * Time: Avg O(2n), Totol operations = `n + n/2 + n/4 + n/8 + n/16 ...` = `2n`.
     *       Worst O(n^2), `n + n-1 + n-2 +...+1` = `n^2/2`, which array is already sorted.
     *       Worst case example, input [1, 2, 3, 4, 5, 6, 7], k = 7;
     * Space: O(1), please notes that Quick Selection Algorithm don't use recursion.
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 1) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = partition(nums, left, right);
            if (n - k == mid) {
                return nums[mid];
            } else if (n - k > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
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
     * Time:  O((2n-k)*logk), build heap `k*logk`, offer `(n-k)*logk`, poll `(n-k)*logk`
     * Space: O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException();
        }
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int v: nums) {
            pq.offer(v);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
