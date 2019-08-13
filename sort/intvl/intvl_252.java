


class Solution252 {
    /**
     * Case Analysis
     *    1. Sort intervals by start to `ascending` order.
     *    2. i1.end > i2.start; --> return false;
     *    3. other case;        --> return true;
     *
     * Time:  O(nlogn)
     * Space: O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}