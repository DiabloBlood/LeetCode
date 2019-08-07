


/**
 * Problem Analysis:
 *    1. 1 <= K <= points.length <= 10000
 *    2. -10000 < points[i][0] < 10000
 *    3. -10000 < points[i][1] < 10000
 */
class Solution973 {
    /**
     * Quick Selection method.
     *
     * Time: Avg O(2n), Totol operations = `n + n/2 + n/4 + n/8 + n/16 ...` = `2n`.
     *       Worst O(n^2), `n + n-1 + n-2 +...+1` = `n^2/2`, which array is already sorted.
     *       Worst case example, input [1, 2, 3, 4, 5, 6, 7], k = 7;
     * Space: O(1), please notes that Quick Selection Algorithm don't use recursion.
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || K < 1 || K > points.length) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int mid = partition(points, left, right);
            if (mid == K) {
                break;
            } else if (mid < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }
    
    private int partition(int[][] points, int low, int high) {
        int[] p = points[high];
        int pivot = p[0]*p[0] + p[1]*p[1];
        int i = low;
        for (int j = low; j < high; j++) {
            p = points[j];
            if (p[0]*p[0] + p[1]*p[1] < pivot) {
                swap(points, i++, j);
            }
        }
        swap(points, i, high);
        return i;
    }
    
    private void swap(int[][] points, int p, int q) {
        int[] temp = points[p];
        points[p] = points[q];
        points[q] = temp;
    }

    /**
     * Heap method. Use a max heap, so the remain points should be the K cloest one.
     * 
     * Time:  O((2n-k)*logk), build heap `k*logk`, offer `(n-k)*logk`, poll `(n-k)*logk`, build result `k`.
     * Space: O(k)
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || K < 1 || K > points.length) {
            throw new IllegalArgumentException();
        }
        
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1];
            }
        });
        
        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] result = new int[K][2];
        for (int[] p: pq) {
           result[--K] = p; 
        }
        return result;
    }
}
