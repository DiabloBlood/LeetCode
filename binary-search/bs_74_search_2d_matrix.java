


class Solution74 {
    /**
     * Notes: this method has same big O with the 2nd method, how ever the 1st method run time is slow.
     *        That's because `mid / n` is slow and the 2nd method takes advantage of cache. 
     *
     * Problem Pitfalls:
     *     1. How to handle corner cases matrix == null, matrix = [], matrix =[[]]?
     *
     * Time:  O(logm + logn), total = `logmn` = `logm + logn`.
     * Space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return false;
    }
    /**
     * Problem Pitfalls:
     *     1. How to handle corner cases matrix == null, matrix = [], matrix = [[]]?
     *
     * Time:  O(logm + logn)
     * Space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                return searchRow(matrix, mid, target);
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    
    private boolean searchRow(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
