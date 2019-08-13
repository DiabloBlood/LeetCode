class Solution253 {
    /**
     * Problem Analysis:
     *     1. This problem is very like find the maximum layers of "ssseeessee", which is like "((()))(())"
     *
     * Case Analysis:
     *     1. start[i] < end[j];  --> put 's' or '(' to string.
     *     2. start[i] == end[j]; --> put 'e' or ')' to string.
     *     3. start[i] > end[j];  --> put 'e' or ')' to string.
     * 
     * Time:  O(2n*logn + 2n) ~ O(n*logn), for loop is O(n), two times sort is O(2n*logn), while loop is O(n).
     * Space: O(2n) ~ O(n), start array is O(n), end array is O(n). Could optimize to O(n), just use end array.
     *        Start array could use intervals instead of another new array.
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 0;
        int j = 0;
        int rooms = 0;
        int max = 0;
        
        // In fact we only need `i < n` condition if the input is valid. (Which means for every interval, start < end)
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                rooms++;
                i++;
            } else {
                rooms--;
                j++;
            }
            max = Math.max(max, rooms);
        }
        return max;
    }
}

