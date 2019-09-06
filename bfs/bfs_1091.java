


class Solution1091 {
    /**
     * Problem Analysis.
     *     1. This is BFS shortest path problem.
     *
     * Time:  O(m * n), for every node, only enqueue on time.
     * Space: O(m + n), please draw contour line of this graph, assume input is grid[m][n], all cells value is 0,
     *                  the deepest level has `m + n` nodes, so at most `(m + n)` will been added to queue. 
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        int depth = 0;
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return depth + 1;
                }
                for (int j = 0; j < dir.length; j++) {
                    int x = cur[0] + dir[j][0];
                    int y = cur[1] + dir[j][1];
                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] || grid[x][y] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            depth++;
        }
        return -1;
    }
    /**
     * Problem Analysis.
     *     1. This is BFS shortest path problem.
     *
     * Time:  O(8m*n), for every node, 8 nodes around this node will been added to queue.
     * Space: O(8(m + n)), please draw contour line of this graph, assume input is grid[m][n], all cells value is 0,
     *                     the deepest level has `m + n` nodes, so at most `8(m + n)` will been added to queue. 
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        int depth = 0;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] || grid[x][y] != 0) {
                    continue;
                }
                if (x == m - 1 && y == n - 1) {
                    return depth + 1;
                }
                for (int j = 0; j < dir.length; j++) {
                    int nextX = cur[0] + dir[j][0];
                    int nextY = cur[1] + dir[j][1];
                    queue.offer(new int[]{nextX, nextY});
                }
                visited[x][y] = true;
            }
            depth++;
        }
        return -1;
    }
}
