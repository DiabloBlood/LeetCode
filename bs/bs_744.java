


class Solution744{
    /**
     * Notes:
     *     1. Please refer to `BinarySearchAsc.bs3` template.
     *     2. `letters` has a length in range [2, 10000].
     *     3. `letters` consists of lowercase letters, and contains at least 2 unique letters.
     *     4. `target` is a lowercase letter.
     *     5. `pos` initialized as `0` instead of `etters.length`,
     *        since if letters = ['a', 'b'] and target = 'z', answer is 'a'.
     *
     * Corner Cases:
     *     1. nums == null; ---> // impossible, pre-condition letters.length >= 2.
     *
     * Time:  O(logn)
     * Space: O(1)
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int pos = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[pos];
    }
}
