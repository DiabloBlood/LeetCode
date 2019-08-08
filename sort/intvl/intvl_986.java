


class Solution986 {
    /**
     * The most optimized method. 
     *
     * Case Analysis:
     *     1. a[i].start > b[j].end; ---> no intxn; j++;
     *     2. a[i].end < b[j].start; ---> no intxn; i++;
     *     3. a[i].start <= b[j].end && a[i].end >= b[j].start; add min start; add min end;
     *         3.1 a[i].end <  b[j].end; ---> i++;
     *         3.2 a[i].end >= b[j].end; ---> j++;
     *  
     * Time:  O(m + n), the while loop.
     * Space: Best  O(1)
     *        Worst O(max(m, n))
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return new int[0][0];
        }
        
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < A.length && j < B.length) {
            if (A[i][0] > B[j][1]) {
                j++;
            } else if (A[i][1] < B[j][0]) {
                i++;
            } else {
                list.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                if (A[i][1] < B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
    /**
     * The trivial and slow method.
     *
     * Case Analysis:
     *     1. a[i].start > b[j].end; ---> no intxn; // do nothing
     *     2. a[i].end < b[j].start; ---> no intxn; // do nothing
     *     3. a[i].start <= b[j].end && a[i].end >= b[j].start; ---> add max start; add min end;
     *  
     * Time:  O(m*n)
     * Space: Best  O(1)
     *        Worst O(max(m, n))
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return new int[0][0];
        }
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i][0] <= B[j][1] && A[i][1] >= B[j][0]) {
                    list.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
