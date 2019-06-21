


class Solution205 {
    /*
     * Time:  O(n)
     * Space: O(1)
     */
    // isomorphic means every char the last position is same
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if(mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // Notes: test case s = "ab", t = "aa", array int[128] default is zero, which will confuse with the index zero
    /*
     * Case Analysis:
     * 1. s[i] == notFound && t[i] != notFound; return false;
     * 2. s[i] == notFound && t[i] == notFound; s[i] =i; t[i] = i;
     * 3. s[i] != notFound && t[i] == notFound; return false;
     * 4. s[i] != notFound && t[i] != notFound && s[i] != t[i]; return false;
     * 5. s[i] != notFound && t[i] != notFound && s[i] == t[i]; s[i] =i; t[i] = i;
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        
        final notFound = -1;
        Arrays.fill(mapS, notFound);
        Arrays.fill(mapT, notFound);
        
        for (int i = 0; i < s.length(); i++) {
            if(mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i;
            mapT[t.charAt(i)] = i;
        }
        return true;
    }
}









