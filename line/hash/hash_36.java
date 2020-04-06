


public class Solution36 {
    /**
     * Problem Analysis:
     *     1. `i` in [0, 8] seen as box index, `j` in [0, 8] seen as cell index inside this box.
     *
     * General Cases:
     *     1. board[i][j]; ---> // check rows
     *     2. board[j][i]; ---> // check cols
     *     3. int row = 3 * (i / 3) + j / 3; ---> // `3 * (i / 3)` in [0, 3, 6] is the start row number of each row boxes.
     *                                               `j / 3` in [0, 1, 2] is the row number inside this box.
     *     4. int col = 3 * (i % 3) + j % 3; ---> // `3 * (i % 3)` in [0, 3, 6] is the start col number of each row boxes.
     *                                               `j / 3` in [0, 1, 2] is the col number inside this box.
     * Corner Cases:
     *     1. board == null || board.length != 9 || board[0].length != 9; ---> return false;
     *     2. c != '.' && (c < '1' || c > '9'); ---> return false; 
     *
     * Time:  O(1), total 9 * 36 = 324 times O(1) operations.
     * Space: O(1), array maps takes contant space
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[] rowMap = new boolean[9];
        boolean[] colMap = new boolean[9];
        boolean[] boxMap = new boolean[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // check rows
                if (!isValid(board[i][j], rowMap)) {
                    return false;
                }
                // check cols
                if (!isValid(board[j][i], colMap)) {
                    return false;
                }
                // check box
                int row = 3 * (i / 3) + j / 3;
                int col = 3 * (i % 3) + j % 3;
                if (!isValid(board[row][col], boxMap)) {
                    return false;
                }
            }
            Arrays.fill(rowMap, false);
            Arrays.fill(colMap, false);
            Arrays.fill(boxMap, false);
        }
        return true;
    }

    private boolean isValid(char c, boolean[] map) {
        if (c == '.') {
            return true;
        }
        if (c >= '1' && c <= '9' && !map[c - '1']) {
            map[c - '1'] = true;
            return true;
        }
        return false;
    }
}
