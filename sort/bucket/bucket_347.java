


class Solution347 {
    /**
     * Bucket Sort method with bucket size optimization.
     *
     * Tips:
     *     1. Hashmap iterate use Map.Entry is quick than just iterate key when you want key and value.
     *        Since `map.get(key)` is slow.
     *
     * Problem Pitfalls:
     *     1. Case nums = [1, 1, 2, 2, 3, 3, 4, 4], k = 2; We just want out put 2 numbers. [1, 2], [2, 3]... all is right.
     *
     * Time:  O(n), first for loop is `n`, second for loop is `n`, third for loop is between [k, n + k]
     *              Total is between [2n + k, 3n + k]
     *              Third loop please consider case [1, 2, 3, 4, 5, 6, 7] and [1, 1, 1, 1, 1, 1, 1], respectively.
     * Space: O(3n), map is `n`, bucket list is `2n`, total is `3n` 
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            max = Math.max(max, freq);
        }
        List<Integer>[] bucket = new List[max + 1];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        // if k may > nums.length `i >= 0` condition should be add
        // for (int i = bucket.length - 1; result.size() < k && i >= 0; i--)
        for (int i = bucket.length - 1; result.size() < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            int size = k - result.size();
            if (bucket[i].size() <= size) {
                result.addAll(bucket[i]);
                continue;
            }
            for (int j = 0; j < size; j++) {
                result.add(bucket[i].get(j));
            }
        }
        return result;
    }
    /**
     * Bucket Sort method.
     *
     * Tips:
     *     1. Hashmap iterate use Map.Entry is quick than just iterate key when you want key and value.
     *        Since `map.get(key)` is slow.
     *
     * Problem Pitfalls:
     *     1. Case nums = [1, 1, 2, 2, 3, 3, 4, 4], k = 2; We just want out put 2 numbers. [1, 2], [2, 3]... all is right.
     *
     * Time:  O(n), first for loop is `n`, second for loop is `n`, third for loop is between [k, n + k]
     *              Total is between [2n + k, 3n + k]
     *              Third loop please consider case [1, 2, 3, 4, 5, 6, 7] (n + k) and [1, 1, 1, 1, 1, 1, 1] (k), respectively.
     * Space: O(3n), map is `n`, bucket list is `2n`, total is `3n` 
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        // if k may > nums.length `i >= 0` condition should be add
        // for (int i = bucket.length - 1; result.size() < k && i >= 0; i--)
        for (int i = bucket.length - 1; result.size() < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            int size = k - result.size();
            if (bucket[i].size() <= size) {
                result.addAll(bucket[i]);
                continue;
            }
            for (int j = 0; j < size; j++) {
                result.add(bucket[i].get(j));
            }
        }
        return result;
     }
    /**
     * Heap/PriorityQueue Method.
     * 
     * Problem Analysis:
     *     1. Use a hashmap to record number frequency, then use a min heap select the top k.
     *
     * Time:  O(n*logk), Total = `n + k*logk + (n - k)*logk + k`
     * Space: O(n + k), hashmap is n, priority queue is k.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        });
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: pq) {
            result.add(entry.getKey());
        }
        return result;
    }
}
