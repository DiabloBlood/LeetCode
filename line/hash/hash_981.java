


public class Solution981 {
    /**
     * Notes:
     *     1. All key/value strings have length in the range [1, 100], so no corner cases.
     *
     * Problem Analysis:
     *     1. The timestamps for all TimeMap.set operations are strictly increasing, which indicates we could use binary search.
     *     2. Please refer to `BinarySearchAsc.bs2` template for binary search part.
     *
     * Set method:
     * Time:  O(1), all map and list build-in method used is O(1)
     * Space: O(1), no extra space been used.
     *
     * Get method:
     * Time:  O(logm), assume there are `m` entries with same key, binary search time is takes `logm`
     * Space: O(1), no extra space been used.
     */
    private class Entry {
        int timestamp;
        String value;
        Entry(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Entry> list = map.get(key);
        int idx = binarySearch(list, timestamp);
        return idx == -1 ? "" : list.get(idx).value;
    }

    private int binarySearch(List<Entry> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * TreeMap method.
     *
     * Notes:
     *     1. All key/value strings have length in the range [1, 100], so no corner cases.
     *
     * Problem Analysis:
     *     1. The timestamps for all TimeMap.set operations are strictly increasing, so timestamp could use as key of treemap.
     *     1. Please refer to `BinarySearchAsc.bs2` template for binary search part.
     *
     * Set method:
     * Time:  O(1), all map and list build-in method used is O(1)
     * Space: O(1), no extra space been used.
     *
     * Get method:
     * Time:  O(logm), assume there are `m` entries with same key, treemap get floor key takes `logm` time.
     * Space: O(1), no extra space been used.
     */
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    /**
     * Trivial solution.
     *
     * Set method:
     * Time:  O(1), all map and list build-in method used is O(1)
     * Space: O(1), no extra space been used.
     *
     * Get method:
     * Time:  O(m), assume there are `m` entries with same key.
     * Space: O(1), no extra space been used.
     */
    private class Entry {
        int timestamp;
        String value;
        Entry(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Entry> list = map.get(key);
        for (int i = list.size() - 1; i >= 0; i--) {
            Entry entry = list.get(i);
            if (entry.timestamp <= timestamp) {
                return entry.value;
            }
        }
        return "";
    }
}
