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
    * Time Complexity: 
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