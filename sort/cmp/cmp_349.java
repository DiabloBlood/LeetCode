


class Solution349 {
    /**
     * Problem Analysis:
     *    1. If the two input arrays are not been sorted, hashset method is the best method.
     * 
     * Assume: nums1.length is `m`, nums2.length is `n`.
     * Time:  O(m + n), first for loop is `m`, second for loop is `n`, build result < O(min(m, n))
     * Space: Best  O(m)
     *        Worst O(m + n), if `m > n` and result size is O(n), which means all nums2 numbers in result,
     *        then intxn set size is `n`.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> intxn = new HashSet<>();
        
        for (int num: nums1) {
            set.add(num);
        }
        
        for (int num: nums2) {
            if (set.contains(num)) {
                intxn.add(num);
            }
        }
        int[] result = new int[intxn.size()];
        int i = 0;
        for (int num: intxn) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * If the array is already sorted, please use two pointer solution.
     *
     * Case Analysis:
     *     1. nums1[i] <  nums2[j]; ---> i++;
     *     2. nums1[i] == nums2[j]; ---> result.add(nums[i]); i++; j++;
     *     3. nums1[i] >  nums2[j]; ---> j++;
     *
     * Time:  O(m*logm + n*logn), if two arrays already sorted, time is O(min(m, n)).
     * Space: Best  O(1)
     *        Worst O(min(m, n))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> intxn = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intxn.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[intxn.size()];
        int k = 0;
        for (int num: intxn) {
            result[k++] = num;
        }
        return result;
    }
}
