


class Solution218 {
    /**
     * Problem Pitfalls:
     *     1. Case [[0,2,3],[2,5,3]], start height [2, -3] should in front of height [2, 3]
     *     2. Map interface doesn't has `lastKey()` method. Please declare by using treemap.
     * 
     * Time:  O(2n*logn), first for loop is `n`, sort is `2n*logn`, third for loop worst is `n*logn`
     * Space: Worst O(3n), worst case of treemap size if O(n)
     *        Best  O(2n), best case of treemap size is O(1)
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null) {
            return new ArrayList<>();
        }
        int[][] heights = new int[buildings.length * 2][2];
        int i = 0;
        for (int[] b: buildings) {
            heights[i++] = new int[]{b[0], -b[2]};
            heights[i++] = new int[]{b[1], b[2]};
        }
        Arrays.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] h1, int[] h2) {
                if (h1[0] == h2[0]) {
                    return h1[1] - h2[1];
                }
                return h1[0] - h2[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prev = 0;
        map.put(prev, 1);
        for (int[] h: heights) {
            if (h[1] < 0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                int temp = map.get(h[1]);
                if (temp == 1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], temp - 1);
                }
            }
            int cur = map.lastKey();
            if (cur != prev) {
                result.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return result;
    }
    /**
     * Problem Pitfalls:
     *     1. Case [[0,2,3],[2,5,3]], start height [2, -3] should in front of height [2, 3]
     * 
     * Time:  Worst O(n^2), the second for loop worst is O(n^2), since the `pq.remove` is O(n) level
     *        Best  O(2n*logn), best case if all building is not overlap, second for loop is O(n)
     * Space: Worst O(3n), worst case of pq size if O(n)
     *        Best  O(2n), best case of pq size is O(1)
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>();
        }
        int[][] heights = new int[buildings.length * 2][2];
        int i = 0;
        for (int[] b: buildings) {
            heights[i++] = new int[]{b[0], -b[2]};
            heights[i++] = new int[]{b[1], b[2]};
        }
        Arrays.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] h1, int[] h2) {
                if (h1[0] == h2[0]) {
                    return h1[1] - h2[1];
                }
                return h1[0] - h2[0];
            }
        });
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> result = new ArrayList<>();
        int prev = 0;
        pq.offer(0);
        for (int[] h: heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                result.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return result;
    }
}
