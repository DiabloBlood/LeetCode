


public class Solution345 {
    /**
     * Notes:
     *     1. Class `String` use `private final char value[];` as characters storage, so method `toCharArray()`
     *        and constructor `new String(char[] value)` all takes O(n) time to copy char array in or out.
     *
     * Problem Analysis:
     *     1. Two inside while loop finally will make sure start == end, and swap will not has side effect.
     *     2. Seen `vowels.indexOf(array[start]) == -1` as O(1) time.
     *
     * General Cases:
     *     1. start < end && vowels.indexOf(array[start]) == -1; ---> loop start++;
     *     2. start < end && vowels.indexOf(array[end]) == -1;   ---> loop end--;
     *
     * Corner Cases:
     *     1. s == null; ---> return null; // otherwise `s.toCharArray();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // will skip while loop, and return an empty string.
     *
     * Time:  O(3n), s.toCharArray() takes `n`, while loop takes `n`, `new String(array)` take `n`.
     * Space: O(n), extra char array been used.
     */
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(array[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(array[end]) == -1) {
                end--;
            }
            swap(array, start++, end--);
        }
        return new String(array);
    }

    private void swap(char[] array, int p, int q) {
        char temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
}
