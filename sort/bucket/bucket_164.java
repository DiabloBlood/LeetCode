


class Solution164 {
    /**
     * Problem pitfalls:
     *    1. input [-2147483648, 2147483647] gap is 0. So this problem input is non-negtive numbers.
     *    2. input [1, 100], `1` will in bucket [1, 100), however, 100 will not in the bucket. So maxGap has finally calculation.
     *    3. Consider that why input [1, 1, 1, 1] not lead to divide zero exception and return valid result.
     *    4. Consider that why input [-1, -1, -1, -1] will return valid result
     *    5. Consider that why prev initialized as `min`.
     *    5. double(99999997) = 9.9999997E7, however float is 1.0E8
     *
     * Problem Analysis:
     *    1. The maximum gap definitely >= `ceil((max - min) / (n - 1))`.
     *       The max gap of numbers within a bucket is `gap - 1`, so the max gap of numbers within a bucket is impossible the maxGap.
     *    2. The bucket interval is left closed and right open. E.g. [1, 100).
     *
     * Time:  O(n), three for loops all is O(n), arrays.fill is O(2n), total is O(5n).
     * Space: O(n), two buckets array, total is O(2n).
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min) {
            return 0;
        }
        int gap = (int)Math.ceil((double)(max - min) / (n - 1));
        
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        for (int num: nums) {
            int idx = (num - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }
        int maxGap = 0;
        int prev = min;
        for (int i = 0; i < n; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        return maxGap;
    }
}
