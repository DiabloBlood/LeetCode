import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;



public class Test {
    public List<String> numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<StringBuilder> prev = new ArrayList<>();
        List<StringBuilder> next = new ArrayList<>();
        prev.add(new StringBuilder());

        if (s.charAt(0) != '0') {
            int value = s.charAt(0) - '0';
            char c = (char)(value - 1 + 'A');
            next.add(new StringBuilder(c + ""));
        }

        for (int i = 1; i < s.length(); i++) {
            List<StringBuilder> cur = new  ArrayList<>();
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (value >= 10 && value <= 26) {
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: prev) {
                    sb.append(c);
                    cur.add(sb);
                }
            }
            if (s.charAt(i) != '0') {
                value = s.charAt(i) - '0';
                char c = (char)(value - 1 + 'A');
                for (StringBuilder sb: next) {
                    StringBuilder copy = new StringBuilder(sb);
                    copy.append(c);
                    cur.add(copy);
                }
            }
            prev = next;
            next = cur;
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb: next) {
            result.add(sb.toString());
        }
        return result;
    }

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

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    System.out.println((0.0 + size) / m / n);
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
                    count++;
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test t = new Test();
        //String s = "1821";
        //[RU, AHU, RBA, AHBA]
        //System.out.println(t.numDecodings(s));
        int[][] grid = new int[500][500];
        t.shortestPathBinaryMatrix(grid);
    }
}

