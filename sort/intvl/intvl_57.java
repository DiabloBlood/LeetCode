


class Solution57 {
    /**
     * Note: This solution is not the most optimized solution!
     *
     * Problems pitfalls:
     *     1. Why don't need to handle corner case `intervals.length == 0`?
     *        Answer: if intervals is an empty array, the return value should conclude newInterval.
     *
     * Case Analysis:
     *     1. i.end < new.start;      ---> list.add(i);
     *     2. i.start > new.end;      ---> list.add(i);
     *     3. i.end >= new.start && i.start <= new.end; ---> update new.start, new.end;
     * 
     * Time:  O(n), for loop is O(n), list.add at most is O(n), build result at most is O(n);
     * Space: Best  O(1), the list size.
     *        Worst O(n), the list size.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return new int[0][0];
        }
        int pos = 0;
        List<int[]> list = new ArrayList<>();
        for (int[] intvl: intervals) {
            if (intvl[1] < newInterval[0]) {
                pos++;
                list.add(intvl);
            } else if (intvl[0] > newInterval[1]) {
                list.add(intvl);
            } else {
                newInterval[0] = Math.min(newInterval[0], intvl[0]);
                newInterval[1] = Math.max(newInterval[1], intvl[1]);
            }
        }
        list.add(pos, newInterval);
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * A more optimized solution.
     *
     * Time:  O(n), for loop is half O(n), list add is O(1), while loop is half O(n), build result at most is O(n);
     * Space: Best  O(1), the list size.
     *        Worst O(n), the list size.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return new int[0][0];
        }
        int pos = 0;
        List<int[]> list = new ArrayList<>();
        for (int[] intvl: intervals) {
            if (intvl[1] < newInterval[0]) {
                pos++;
                list.add(intvl);
            } else if (intvl[0] > newInterval[1]) {
                break;
            } else {
                pos++;
                newInterval[0] = Math.min(newInterval[0], intvl[0]);
                newInterval[1] = Math.max(newInterval[1], intvl[1]);
            }
        }
        list.add(newInterval);
        while (pos < intervals.length) {
            list.add(intervals[pos++]);
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * An other more optimized solution.
     *
     * Time:  O(n), three while loop total is O(n), build result at most is O(n);
     * Space: Best  O(1), the list size.
     *        Worst O(n), the list size.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return new int[0][0];
        }
        int pos = 0;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        while (pos < n && intervals[pos][1] < newInterval[0]) {
            list.add(intervals[pos++]);
        }
        
        while (pos < n && intervals[pos][1] >= newInterval[0] && intervals[pos][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[pos][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[pos][1]);
            pos++;
        }
        
        list.add(newInterval);
        while (pos < n) {
            list.add(intervals[pos++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
