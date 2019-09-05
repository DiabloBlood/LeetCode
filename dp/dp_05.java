


class Solution05 {
    /**
     * General Method.
     *
     * Problem Pitfalls:
     *     1. Please note that `"".substring(0, 0) == ""`, `"".substring(0, 1)` will throw out of range exceptions.
     *     2. Think case "abcde", answer is "a", `helper(s, index, i, i + 1)` will always has `end - start - 1 == 0`,
     *
     * Time:  O(n^2), best is `n` of case "abcde", worst is `n^2` of case "aaaaa"
     * Space: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // index[0] is `start` point, index[1] is `end` point
        int[] index = new int[2];
        for (int i = 0; i < s.length(); i++) {
            helper(s, index, i, i);
            helper(s, index, i, i + 1);
        }
        return s.substring(index[0], index[1] + 1);
    }
    
    private void helper(String s, int[] index, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (end - start - 1 > index[1] - index[0] + 1) {
            index[0] = start + 1;
            index[1] = end - 1; 
        }
    }

    /**
     * DP method with visited map.
     *
     * Poblem Analysis:
     *     1. State transition function is f(i, j) = s[i] == s[j] && (i + 1 > j - 1 || f(i + 1, j - 1))
     *
     * Time:  O(n^2), graph has `n^2` nodes.
     * Space: O(n^2), visted map is `n^2`
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    /**
     * Memorization method.
     *
     * Poblem Analysis:
     *     1. State transition function is f(i, j) = s[i] == s[j] && (i + 1 > j - 1 || f(i + 1, j - 1))
     *
     * Time:  O(n^2), graph has `n^2` nodes.
     * Space: O(n^2), visted map is `n^2`
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (helper(s, dp, i, j) && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
    private boolean helper(String s, boolean dp[][], int i, int j) {
        if (i > j || dp[i][j]) {
            return true;
        }
        dp[i][j] = s.charAt(i) == s.charAt(j) && helper(s, dp, i + 1, j - 1);
        return dp[i][j];
    }
}
