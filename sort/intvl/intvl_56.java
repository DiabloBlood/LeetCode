


class Solutio56 {
    /**
     * If input cannot be change, please use this solution.
     * 
     * Problem pitfalls:
     *    1. Consider that why corner case `intervals.length == 0` need to be handled.
     *
     * Time:  O(n*logn), sort is O(n*logn), for loop is O(n).
     * Space: Best  O(1), the list size.
     *        Worst O(n), the list size.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0].clone();
        list.add(prev);
        for (int[] intvl: intervals) {
            if (intvl[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intvl[1]);
            } else {
                prev = intvl.clone();
                list.add(prev);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * If input could be change, please use this solution.
     *
     * Time:  O(n*logn), sort is O(n*logn), for loop is O(n).
     * Space: Best  O(1), the list size.
     *        Worst O(n), the list size.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        list.add(prev);
        for (int[] intvl: intervals) {
            if (intvl[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intvl[1]);
            } else {
                prev = intvl;
                list.add(prev);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
