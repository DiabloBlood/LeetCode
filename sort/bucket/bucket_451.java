


class Solution451 {
    /**
     * Bucket Sort method with bucket size optimization.
     *
     * Tips:
     *     1. Use int map to calculate character frequency.
     *
     * Problem Pitfalls:
     *     1. How to optimize the bucket size? Track the max frequency, max maybe less than `n`.
     *     2. Please notify the small optimization of `sb.length() < s.length()`
     *
     * Time:  O(n), first for loop is `n`, second for loop is `128`, third for loop is between [n, 2n]
     *              Total is between [2n, 3n]
     *              Third loop please consider case "abcdef" and "aaaaaaa", respectively.
     * Space: O(3n), map is `128`, bucket list maximum is `2n`, total is `<= 3n` 
     */
    public String frequencySort(String s) {
        if (s == null) {
            return "";
        }
        int[] map = new int[128];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i);
            map[key]++;
            max = Math.max(max, map[key]);
        }
        List<Character>[] bucket = new List[max + 1];
        for (int i = 0; i < map.length; i++) {
            int freq = map[i];
            if (freq == 0) {
                continue;
            }
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add((char)i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 1 && sb.length() < s.length(); i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (char c: bucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Bucket Sort method.
     *
     * Tips:
     *     1. Use int map to calculate character frequency.
     *
     * Problem Pitfalls:
     *     1. How to optimize the bucket size? Track the max frequency, max maybe less than `n`.
     *
     * Time:  O(n), first for loop is `n`, second for loop is `128`, third for loop is between [n, 2n]
     *              Total is between [2n, 3n]
     *              Third loop please consider case "abcdef" and "aaaaaaa", respectively.
     * Space: O(3n), map is `128`, bucket list is `2n`, total is `3n` 
     */
    public String frequencySort(String s) {
        if (s == null) {
            return "";
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (int i = 0; i < map.length; i++) {
            int freq = map[i];
            if (freq == 0) {
                continue;
            }
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add((char)i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 1; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (char c: bucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
     }
}
