


public class Solution380 {
    /**
     * Problem Analysis:
     *     1. Use an array list to guarantee O(1) time of method `getRandom`.
     *     2. Use an hash map to recorde val ---> index of list.
     *     3. Don't use `list.remove(idx)` directly, this method is O(n), swap with the last element first.
     *
     * Corner Cases:
     *     1. insert method
     *        a. map.containsKey(val);  ---> return false;
     *     2. remove method
     *        a. !map.containsKey(val); ---> return false;
     *
     * Time:  O(1), for method insert, remove, and getRandom.
     * Space: O(1), each method doesn't use any extra space. Class space is O(2n).
     */
    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int end = list.size() - 1;
        map.put(list.get(end), idx);
        list.set(idx, list.get(end));
        map.remove(val);
        list.remove(end);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}
