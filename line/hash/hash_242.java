


class Solution242 {

    /*
     * Time:  O(n)
     * Space: O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i]!= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i]!= 0) {
                return false;
            }
        }
        return true;
    }
}