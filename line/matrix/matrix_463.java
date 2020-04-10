


public class Solution463 {
    /**
     * Problem Analysis:
     *     1. Perimeter is (total cells of 1) * 4 - (total common edges) * 2;
     *
     * General Cases:
     *     1. grid[i][j] == 0; ---> continue;
     *     2. grid[i][j] == 1;
     *        a. i + 1 < n && grid[i + 1][j] == 1; ---> count -= 2;
     *        b. j + 1 < m && grid[i][j + 1] == 1; ---> count -= 2;
     *
     * Corner Cases:
     *     1. grid == null;        ---> return 0; // otherwise `int n = grid.length;` will throw `NullPointerException`.
     *     2. grid.length == 0;    ---> return 0; // otherwise `int m = grid[0].length;` will throw `ArrayIndexoutofboundsexception`.
     *     3. grid[0].length == 0; ---> // doesn't need to handle, will into outer for loop and skip inner for loop, finally return `0`.
     *
     * Time:  O(nm), two for loops
     * Space: O(1)
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count += 4;
                if (i + 1 < n && grid[i + 1][j] == 1) {
                    count -= 2;
                }
                if (j + 1 < m && grid[i][j + 1] == 1) {
                    count -= 2;
                }
            }
        }
        return count;
    }
}
