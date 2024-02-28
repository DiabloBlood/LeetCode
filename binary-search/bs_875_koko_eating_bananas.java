


class Solution875 {
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs6` template.
     *     2. Piles array not need to be ascending or descending order, the search space is a descending order space, so using bs6 template.
     *     3. Hours must use `long` type, to avoid int our of range
     *
     * Problem Analysis:
     *
     * General Cases:
     *     1. hours <= h; ---> right = mid - 1;
     *     2. hours >  h; ---> left = mid + 1;
     *
     * Corner Cases:
     *     1. Since nums.length >= 3, so there is not corner cases.
     *
     * Time:  O(nlogn)
     * Space: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null) {
            return -1;
        }

        int max = 0;
        for (int num: piles) {
            max = Math.max(max, num);
        }

        int left = 1;
        int right = max;
        int k = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            for (int num: piles) {
                hours += num / mid;
                if (num % mid > 0) {
                    hours += 1;
                }
            }

            if (hours <= h) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
}
