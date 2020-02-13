


class Solution167 {
    /**
     * Case Analysis:
     *     1. sum == target; ---> return [start + 1, end + 1];
     *     2. sum <  target; ---> start++;
     *     3. sum >  target; ---> end--;
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[2];
    }
}
