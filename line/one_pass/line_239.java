


class Solution {

    /*
     * O(n) solution, every element add to deque one time, remote from deque one time. Assight to result is O(n-k)
     * Time:  2n + n - k, O(3n - k)
     * Space: O(k)
     *
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            //throw new IllegalArgumentException();
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    /*
     * O(nk) solution
     * Time:  O((n - k + 1)*k)
     * Space: O(1)
     *
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            //throw new IllegalArgumentException();
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        for (int i = 0; i < result.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            result[i] = max;
        }
        return result;
    }
}









