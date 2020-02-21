


public class Solution541 {
    /**
     * Notes:
     *     1. The string consists of lower English letters only.
     *     2. Length of the given string and k will in the range [1, 10000].
     *
     * Problem Analysis:
     *     1. Traverse ptr `i` jump 2k steps every loop, [0, ..., k-1, k, ..., 2k-1, 2k, ..., 3k-1, 3k, ..., 4k-1, 4k],
     *        `i` will at 0, 2k, 4k, ..., as long as `i` is valid, which means i < array.length, reverse [i, right],
     *        `right` should be the right bound of, which is min(i + k - 1, array.length - 1)
     *
     * General Cases:
     *     1. right = Math.min(i + k - 1, array.length - 1);
     *
     * Corner Cases:
     *     1. s == null;        ---> return null; // otherwise `s.toCharArray();` will throw `NullPointerException`.
     *     2. s.length() == 0;  ---> // doesn't need to handle, return value is an empty string.
     *     3. k <= 0;           ---> throw new IllegalArgumentException(); // which will lead to endless for loop.
     *     4. k > array.length; ---> // doesn't need to handle, [0, array.length - 1] will been reversed.
     *
     * Time:  O(2.5n), s.toCharArray() takes `n`, for loop and reverse takes `0.5n`, only half elements in array need been reversed,
     *                 new String(array) takes `n`.
     * Space: O(n), extra space char array been used.
     */
    public String reverseStr(String s, int k) {
        if (s == null) {
            return null;
        }
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i += 2 * k) {
            int right = Math.min(i + k - 1, array.length - 1);
            reverse(array, i, right);
        }
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    private void swap(char[] array, int p, int q) {
        char temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

    /**
     * Notes:
     *     1. This method take O(2n) time which less than O(2.5n) time of the above method. However, the intention of
     *        this kind of problem is check if you could reverse string in place, java string type is immutable, but if
     *        you use C/C++ then you could reverse string in place. So transfer java string to a char array first is a
     *        decent way to solve this kind of problems.
     *
     * Problem Analysis:
     *     1. Traverse ptr `i` jump 2k steps every loop, [0, ..., k-1, k, ..., 2k-1, 2k, ..., 3k-1, 3k, ..., 4k-1, 4k],
     *        `i` will at 0, 2k, 4k, ..., as long as `i` is valid, which means i < array.length, copy [i, mid] from
     *        negtive direction and copy [mid + 1, right] from positive direction.
     *
     * General Cases:
     *     1. int mid = Math.min(i + k - 1, n - 1);
     *     2. int right = Math.min(i + 2 * k - 1, n - 1);
     *     3. isPos;  ---> sb.append(s.charAt(start++));
     *     3. !isPos; ---> sb.append(s.charAt(end--));
     *
     * Corner Cases:
     *     1. s == null;        ---> return null; // otherwise `s.toCharArray();` will throw `NullPointerException`.
     *     2. s.length() == 0;  ---> // doesn't need to handle, return value is an empty string.
     *     3. k <= 0;           ---> throw new IllegalArgumentException(); // which will lead to endless for loop.
     *     4. k > array.length; ---> // doesn't need to handle, [0, array.length - 1] will been reversed.
     *
     * Time:  O(2n), for loop takes `n`, inside for loop, positive direction copy takes `0.5n`,
     *               negtive direction copy takes another `0.5n`, sb.toString takes `n`.
     * Space: O(n), extra space string builder been used.
     */
    public String reverseStr(String s, int k) {
        if (s == null) {
            return null;
        }
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int mid = Math.min(i + k - 1, n - 1);
            int right = Math.min(i + 2 * k - 1, n - 1);
            copy(sb, s, i, mid, false);
            copy(sb, s, mid + 1, right, true);
        }
        return sb.toString();
    }
 
    private void copy(StringBuilder sb, String s, int start, int end, boolean isPos) {
        while (start <= end) {
            if (isPos) {
                sb.append(s.charAt(start++));
            } else {
                sb.append(s.charAt(end--));
            }
        }
    }
}
