


public class Solution771 {
    /**
     * Notes:
     *     1. The letters in J are guaranteed distinct.
     *     2. All characters in J and S are letters.
     *     3. Letters are case sensitive
     *
     * Problem Analysis:
     *     1. Use a boolean array map to mark which letter is jewel.
     *
     * General Cases:
     *     1. map[S.charAt(i) == true;  ---> result++;
     *     2. map[S.charAt(i) == false; ---> // do nothing
     *
     * Corner Cases:
     *     1. J == null || S == null; ---> return 0; otherwise `i < J.length();` or `i < S.length();` will throw `NullPointerException`.
     *     2. J.length() == 0; ---> // doesn't need to handle, will skip 1st for loop and finally result is `0`;
     *     3. S.length() == 0; ---> // doesn't need to handle, will skip 2nd for loop and fiaally result is `0`;
     *
     * Time:  O(m + n), string J length is `m`, string S length is 'n'.
     * Space: O(1), array map takes constant space.
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        boolean[] map = new boolean[128];
        for (int i = 0; i < J.length(); i++) {
            map[J.charAt(i)] = true;
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map[S.charAt(i)]) {
                result++;
            }
        }
        return result;
    }
}
