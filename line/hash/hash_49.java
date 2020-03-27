


public class Solution49 {
    /**
     * Notes:
     *     1. map.values() return type is a Collection
     *
     * Problem Analysis:
     *     1. Use the sorted alphabetical order string as key to group anagrams.
     *     2. Use counting sort to sort string.
     *
     * General Cases:
     *     1. !map.containsKey(key); ---> map.put(key, new ArrayList<>()); map.get(key).add(s);
     *     2. map.containsKey(key);  ---> map.get(key).add(s);
     *
     * Corner Cases:
     *     1. strs == null; ---> return new ArrayList<>(); // otherwise `for (String s: strs)` will throw `NullPointerException`.
     *     2. strs.length == 0; ---> // doesn't need to handle, will skip for loop and finally return an empty array list.
     *     3. s == null; ---> // assume every `s` is not null.
     *
     * Time:  O(mn), assume `m` is the average length of s, `n` is the length of string array,
     *                   counting sort takes O(m), for loop is `n` rounds, `new ArrayList<>(map.values());`
     *                   takes at most `n` (which means has `n` groups of anagrams)
     * Space: O(m), string takes `m`. (Assume every new string will be collected by GC every for loop round)
     *              array map seen as constant space.
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
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            int count = map[i];
            for (int j = 0; j < count; j++) {
                sb.append((char)i);
            }
        }
        return sb.toString();
    }


    /**
     * Notes:
     *     1. Build a string from char array, you could use `new String(arr);` or `String.valueOf(arr)`
     *     2. map.values() return type is a Collection
     *
     * Problem Analysis:
     *     1. Use the sorted alphabetical order string as key to group anagrams.
     *
     * General Cases:
     *     1. !map.containsKey(key); ---> map.put(key, new ArrayList<>()); map.get(key).add(s);
     *     2. map.containsKey(key);  ---> map.get(key).add(s);
     *
     * Corner Cases:
     *     1. strs == null; ---> return new ArrayList<>(); // otherwise `for (String s: strs)` will throw `NullPointerException`.
     *     2. strs.length == 0; ---> // doesn't need to handle, will skip for loop and finally return an empty array list.
     *
     * Time:  O(mnlogm), assume `m` is the average length of s, `n` is the length of string array,
     *                   sort takes O(mlogm), for loop is `n` rounds, `new ArrayList<>(map.values());`
     *                   takes at most `n` (which means has `n` groups of anagrams)
     * Space: O(m), char array takes `m`. (Assume every new char array will be collected by GC every for loop round)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}









