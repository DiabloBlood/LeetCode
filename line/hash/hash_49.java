/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

public class Solution49 {

    /*
    * Assume `m` is the average length of s, `n` is the length of string array `strs`
    * Time Complexity: O((128 + m)*n), since the counting sort is O(m)
    * Space Complexity: O(128 + m), for StringBuilder usage
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String key = countingSort(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String countingSort(String s) {
        if (s == null || s == "") {
            return s;
        }
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            int count = map[i];
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    /*
    * Assume `m` is the average length of s, `n` is the length of string array `strs`
    * Time Complexity: O(m*logm*n), since the sort is m*logm
    * Space Complexity: O(m), for char array usage.
    */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] strArray = s.toCharArray();
            Arrays.sort(strArray);
            String key = String.valueOf(strArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}









