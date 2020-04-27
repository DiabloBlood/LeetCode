


public class Solution359 {
    /**
     * Notes:
     *     1. If have unlimited kinds of messages, use this method, since the space of hashmap in method 2 may very huge
     *     2. Assume method `shouldPrintMessage` only call with incremental timestamp,
     *        so we can only store the messages of the last 10 timestamps.
     *     3. `sets = new Set<String>[SIZE];` will throw generaic array creation error.
     *
     * Problem Analysis:
     *     1. Use buckets sets track only the last 10 timestamps.
     *
     * General Cases:
     *     1. timestamp > times[idx]; ---> times[idx] = timestamp; sets[idx].clear();
     *     2. timestamp - times[i] < 10 && sets[i].contains(message); ---> return false;
     *
     * Time:  O(1), for `shouldPrintMessage` method, assume messages arrive at same timestamp is O(1).
     * Space: O(1), `shouldPrintMessage` method not use extra space. Class uses O(1) space, since messages arrive at same timestamp is O(1).
     */
    private int[] times;
    private Set<String>[] sets;
    private static final int SIZE = 10;
    public Logger() {
        times = new int[SIZE];
        sets = new Set[SIZE];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int idx = timestamp % SIZE;
        if (timestamp > times[idx]) {
            times[idx] = timestamp;
            sets[idx].clear();
        }
        for (int i = 0; i < sets.length; i++) {
            if (timestamp - times[i] < SIZE && sets[i].contains(message)) {
                return false;
            }
        }
        sets[idx].add(message);
        return true;
    }

    /**
     * Trivial solution, hashmap may occupy more space.
     *
     * Notes:
     *     1. If only have several kinds of messages, just use this method, then hashmap space is limited, too.
     *
     * General Cases:
     *     1. !map.containsKey(message) || timestamp - map.get(message) >= 10; ---> map.put(message, timestamp); return true;
     *     2. map.containsKey(message) && timestamp - map.get(message) < 10;   ---> return false;
     *
     * Time:  O(1), for `shouldPrintMessage` method
     * Space: O(1), `shouldPrintMessage` method not use extra space.
     */
    private Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
