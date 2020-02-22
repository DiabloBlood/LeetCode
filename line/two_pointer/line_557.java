


public class Solution541 {
    /**
     * Notes:
     *     1. If use string builder could O(3n) solution, but the purpose of this kind of problem is to check
     *        if you could reverse in place. So use s.toCharArray() is a decent way to solve this kind of problems.
     * 
     * Problem Analysis:
     *     1. When traverse ptr `i` value is ' ', reverse [start, i - 1], then assign start = i + 1;
     *
     * General Cases:
     *     1. i == array.length; ---> reverse(array, start, i - 1); // put `start = i + 1;` is OK, could merge with case 2.
     *     2. i <  array.length && array[i] == ' '; ---> reverse(array, start, i - 1); start = i + 1;
     *     merge case 1 and 2,
     *     1. i == array.length || array[i] == ' ' ---> reverse(array, start, i - 1); start = i + 1;
     *
     * Corner Cases:
     *     1. s == null; ---> return null; // otherwise `s.toCharArray();` will throw `NullPointerException`.
     *     2. s.length() == 0; ---> // doesn't need to handle, will into for loop and skip reverse method, then return an empty string.
     *
     * Time:   O(4n), s.toCharArray() takes `n`, for loop takes `2n`, new String(array) takes `n`.
     * Space:  O(n), extra space char array been used.
     */
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i <= array.length; i++) {
            if (i == array.length || array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
            }
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
}
