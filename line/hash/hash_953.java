


public class Solution953 {
    /**
     * Notes:
     *     1. 1 <= words.length <= 100
     *     2. 1 <= words[i].length <= 20
     *     3. order.length == 26
     *     4. All characters in words[i] and order are English lowercase letters.
     *
     * General Cases:
     *     1. !isValid(map, words[i], words[i + 1]; ---> return false;
     *     2. isValid(map, words[i], words[i + 1];  ---> // do nothing
     *     3. s1.charAt(i) != s2.charAt(i); ---> return map[s1.charAt(i)] < map[s2.charAt(i)]; 
     *     4. s1.charAt(i) == s2.charAt(i); ---> // do nothing
     *
     * Corner Cases:
     *     1. i < s1.length() && i < s2.length(); ---> // avoid out of bound
     *     2. case ["apple", "app"]; ---> return s1.length() <= s2.length();
     *
     * Time:  O(nm), assume words.length is `n`, avg words[i].length is `m`, then at most takes `nm` time.
     * Space: O(1), array map takes O(1) space.
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[128];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i)] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isValid(map, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int[] map, String s1, String s2) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return map[s1.charAt(i)] < map[s2.charAt(i)]; 
            }
        }
        return s1.length() <= s2.length();
    }
}
