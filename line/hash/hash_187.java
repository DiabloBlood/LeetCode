


public class Solution187 {
    /**
     * Problem Analysis:
     *     1. Use a result hashset to avoid duplicates.
     *
     * General Cases:
     *     1. !set.add(key); ---> resultSet.add(key);
     *     2. set.add(key);  ---> // do nothing
     *
     * Corner Cases:
     *     1. s == null; ---> return new ArrayList<>(); // otherwise `i < s.length() - 9` will throw `NullPointerException`.
     *     2. s.length() < 10; ---> // doens't need to handle, will skip 1st for loop and finally return an empty array list.
     *
     * Time:  O(10n), O(10n ~ 15n) the 1st for loop takes `10n`, `new ArrayList<>(resultSet)` takes `1 ~ 5n`
     * Space: O(10n), O(1 ~ 10n),  best O(1), worst O(10n), which means each string has 2 count or each string is unique.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (!set.add(key)) {
                resultSet.add(key);
            }
        }
        return new ArrayList<>(resultSet);
    }

    /**
     * Notes:
     *     1. s.substring(start, end) time complexity is O(end - start), this method will call constructor
     *        public String(char value[], int offset, int count) then call Arrays.copyOfRange, then call
     *        System.arraycopy.
     *     2. map.entrySet() is O(1) method, it's not copy anything, just could access map private variable
     *        Node<K, V> table.
     *
     * General Cases:
     *     1. map.put(key, map.getOrDefault(key, 0) + 1);
     *     2. entry.getValue() > 1; ---> result.add(entry.getKey());
     *
     * Corner Cases:
     *     1. s == null; ---> return new ArrayList<>(); // otherwise `i < s.length() - 9` will throw `NullPointerException`.
     *     2. s.length() < 10; ---> // doens't need to handle, will skip 1st for loop and 2nd for loop finally return an empty array list.
     *
     * Time:  O(10n), O(10n ~ 20n), 1st for loop takes `10n`, 2nd for loop takes at most `10n`.
     * Space: O(10n), O(1 ~ 10n),   best O(1), worst O(10n), which means every substring is unique.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
