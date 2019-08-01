


class Solution373 {
    /**
     * Notes: Two input arrays are `ascending` order.
     * 
     *  -------------------------->  
     * [a1b1, a1b2, a1b3, ..., a1bk] |
     * [a1b1, a1b2, a1b3, ..., a1bk] |
     * [a1b1, a1b2, a1b3, ..., a1bk] |
     * 
     * Assume: `m` is length of nums1, `n` is length of nums2.
     * Time:  O(k*logk), fisrt for loop is `k*logk`, second for loop is `k*logk`.
     * Space: O(k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[2] - p2[2];
            }
        });
        
        for (int i = 0; i < nums2.length && i < k; i++) {
            pq.offer(new int[]{0, i, nums1[0] + nums2[i]});
        }
        int size = Math.min(nums1.length * nums2.length, k);
        for (int i = 0; i < size; i++) {
            int[] cur = pq.poll();
            List<Integer> list = Arrays.asList(nums1[cur[0]], nums2[cur[1]]);
            result.add(list);
            int nextIdx = cur[0] + 1;
            if (nextIdx == nums1.length) {
                continue;
            }
            pq.offer(new int[]{nextIdx, cur[1], nums1[nextIdx] + nums2[cur[1]]});
        }
        return result;
    }

    /**
     * Time:  O(m*n*logk), `k*logk` + `(m*n - k)*logk` = `m*n*logk`
     * Space: O(k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k < 1) {
            return new ArrayList<>();
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                return p2.get(0) + p2.get(1) - p1.get(0) - p1.get(1);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                pq.offer(pair);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return new ArrayList<>(pq);
    }
}
