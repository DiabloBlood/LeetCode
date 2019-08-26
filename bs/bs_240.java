


class Solution240 {
    /**
     * Problem Analysis.
     *     1. Use left-bottom or right-top as start point.
     *
     * Time:  O(m + n)
     * Space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
