class Solution1094 {
    /**
     * Problem analysis: this problem is very like 253 meetring rooms II.
     *
     * Time:  O(2n*logn + 2n) ~ O(n*logn), for loop is O(n), two times sort is O(2n*logn), while loop is O(n).
     * Space: O(n), end array is O(n). 
     */
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null) {
            return false;
        }
        int n = trips.length;
        int[][] end = trips.clone();

        Arrays.sort(trips, new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        Arrays.sort(end, new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[2] - t2[2];
            }
        });
        
        int i = 0;
        int j = 0;
        int sum = 0;
        
        // In fact we only need `i < n` condition if the input is valid. (Which means for every interval, start < end)
        while (i < n && j < n) {
            if (trips[i][1] < end[j][2]) {
                sum += trips[i][0];
                i++;
            } else {
                sum -= end[j][0];
                j++;
            }
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }

    /**
     * Couting sort method.
     *
     * Time:  O(1001 + 1001) ~ O(1)
     * Space: O(1001), stops array 
     */
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null) {
            return false;
        }
        
        int[] stops = new int[1001];
        for (int[] trip: trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        
        int sum = 0;
        for (int i = 0; i < stops.length; i++) {
            sum += stops[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
