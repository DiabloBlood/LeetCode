


class Solution91 {
    /**
     * Optimized DP method, without visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i - 1] + f[i - 2]
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`
     * Space: O(1)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prev = 1;                           // node i == -1
        int next = s.charAt(0) == '0' ? 0 : 1;  // node i == 0
        for (int i = 1; i < s.length(); i++) {
            int cur = 0;
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                cur += prev;
            }
            if (s.charAt(i) != '0') {
                cur += next;
            }
            prev = next;
            next = cur;
        }
        return next;
    }
    /**
     * A follow up to return all possible strings
     *
     * Test: input "1821", return [RU, AHU, RBA, AHBA]
     */
    public List<String> numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<StringBuilder> prev = new ArrayList<>();
        List<StringBuilder> next = new ArrayList<>();
        prev.add(new StringBuilder());

        if (s.charAt(0) != '0') {
            int value = s.charAt(0) - '0';
            char c = (char)(value - 1 + 'A');
            next.add(new StringBuilder(c + ""));
        }

        for (int i = 1; i < s.length(); i++) {
            List<StringBuilder> cur = new  ArrayList<>();
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: prev) {
                    sb.append(c);
                    cur.add(sb);
                }
            }
            if (s.charAt(i) != '0') {
                value = s.charAt(i) - '0';
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: next) {
                    StringBuilder copy = new StringBuilder(sb);
                    copy.append(c);
                    cur.add(copy);
                }
            }
            prev = next;
            next = cur;
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb: next) {
            result.add(sb.toString());
        }
        return result;
    }
    /**
     * DP method with visited map.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *     2. State transition equation: f[i] = f[i - 1] + f[i - 2]
     *
     * Time:  O(n), the graph only has `n` nodes, for loop takes `n`
     * Space: O(n), visited map size is `n`
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] visited = new int[n + 1];
        visited[0] = 1;
        visited[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                visited[i + 1] += visited[i - 1];
            }
            if (s.charAt(i) != '0') {
                visited[i + 1] += visited[i];
            }
        }
        return visited[n];
    }

    /**
     * Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a graph. Which could be topological sorted.
     *
     * Time:  O(n), the graph only has `n` nodes.
     * Space: O(2n), stack size at most is `n`, visited map size is `n`
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] visited = new int[s.length() + 1];
        Arrays.fill(visited, -1);
        return helper(s, visited, s.length() - 1);
    }
    
    private int helper(String s, int[] visited, int i) {
        int result = 0;
        if (i == -1) {
            result = 1;
        }
        if (i == 0) {
            result = s.charAt(i) == '0' ? 0 : 1;
        }
        if (i > 0) {
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                result += visited[i - 1] == -1 ? helper(s, visited, i - 2) : visited[i - 1];
            }
            if (s.charAt(i) != '0') {
                result += visited[i] == -1 ? helper(s, visited, i - 1) : visited[i];
            }
        }
        visited[i + 1] = result;
        return result;
    }

    /**
     * No Memorization method.
     * 
     * Problem Pitfalls:
     *     1. This method solution space is a tree instead of a graph. Tree node has duplicate call, low efficient.
     *     2. Leetcode throw `Time Exceed Limit` of this method.
     *
     * Time:  O(2^n), the function call times is the sum of fibonacci series, which is `2^n` level.
     * Space: O(n), stack size at most is `n`.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, s.length() - 1);
    }
    
    private int helper(String s, int i) {
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return s.charAt(i) == '0' ? 0 : 1;
        }
        // all cases of i > 0
        int result = 0;
        int value = Integer.parseInt(s.substring(i - 1, i + 1));
        if (value >= 10 && value <= 26) {
            result += helper(s, i - 2);
        }
        if (s.charAt(i) != '0') {
            result += helper(s, i - 1);
        }
        return result;
    }
}
