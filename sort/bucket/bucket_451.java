class Solution451 {
    /**
     * Bucket Sort method.
     *
     * Tips:
     *     1. Use int map to calculate character frequency.
     *
     * Problem Pitfalls:
     *     1. How to optimize the bucket size? Track the max frequency, max maybe less than `n`.
     *
     * Time:  O(n), first for loop is `n`, second for loop is `256`, third for loop is between [n, 2n]
     *              Total is between [2n, 3n]
     *              Third loop please consider case "abcdef" and "aaaaaaa", respectively.
     * Space: O(3n), map is `256`, bucket list is `2n`, total is `3n` 
     */
    public String frequencySort(String s) {
        if (s == null) {
            return "";
        }
        int[] map = new int[256];
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