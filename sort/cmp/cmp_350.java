


/**
 * Follow ups.
 * 1. What if the given array is already sorted? How would you optimize your algorithm?
 *    Answer: use two pointer solution, time is O(min(m, n)), space is O(min(m, n))
 *
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *    Answer: Which means `m < n`.
 *            1). Time is stil O(m + n).
 *            2). Space is between `m ~ 2m` if use nums1 as map.
 *            3). Space is between `n ~ n + m` if use nums2 as map.
 *
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *    Answer: Divide and conquer. Put nums1 in hashmap and repeadt the following 3 steps frequently.
 *            1). Read chunks of nums2 that fit into the memory.
 *            2). Process (calculate intersections).
 *            3). Write partial results to memory.
 *
 * 4. If nums1 and nums2 all are stored on disk.
 *    Answer: Hashmap method cannot be used. We could only use two pointer method.
 *            1). External sort (Multi-way merge sort) nums1 and nums2.
 *            2). Read chunks of nums1 and nums2 that fit into the memory and then process.
 */
class Solution350 {
    /**
     * Problem Analysis:
     *    1. If the two input arrays are not been sorted, hashmap method is the best method.
     * 
     * Assume: nums1.length is `m`, nums2.length is `n`.
     * Time:  O(m + n), first for loop is `m`, second for loop is `n`, build result < O(min(m, n))
     * Space: Best  O(m)
     *        Worst O(m + n), if `m > n` and result size is O(n), which means all nums2 numbers in result,
     *        then intxn list size is `n`.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num: list) {
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
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (int num: list) {
            result[k++] = num;
        }
        return result;
    }
}
