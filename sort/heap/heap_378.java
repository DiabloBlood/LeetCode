


class Solution378 {
    /**
     * Notes: rows and columns are `ascending` order, respectively.
     * 
     *  -------------------------->  
     * [a1b1, a1b2, a1b3, ..., a1bn] |
     * [a2b1, a2b2, a2b3, ..., a2bn] |
     * [a3b1, a3b2, a3b3, ..., a3bn] |
     *                           (down arrow)
     * Analysis:
     *     1. Do merge k sorted lists of the upper array.
     *     2. This `n*n` matrix and `1 <= k <= n^2`.
     *
     * Time:  First for loop is `n*logn`, second for loop is `k*logn`.
     *        Best,  O(n*logn), `k` at O(n) level.
     *        Worst, O(n^2*logn), `k` at O(n^2) level.
     * Space: O(n), heap size at most is `n`.
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        int n = matrix.length;
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return matrix[p1[0]][p1[1]] - matrix[p2[0]][p2[1]];
            }
        });
        
        for (int i = 0; i < n && i < k; i++) {
            pq.offer(new int[]{0, i});
        }
        // if k > n^2, pq.poll() may return `null`, then NullPointerException will throw.
        for (int i = 0; i < k - 1; i++) {
            int[] p = pq.poll();
            if (p[0] + 1 == n) {
                continue;
            }
            pq.offer(new int[]{p[0] + 1, p[1]});
        }
        int[] p = pq.peek();
        return matrix[p[0]][p[1]];
    }
}
