class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visted[][] = new boolean[n][m];
         for (int i = 0; i < n; i++) {
            solve(i, 0, board, visted);
            solve(i, m - 1, board, visted);
        }

        
        for (int j = 0; j < m; j++) {
            solve(0, j, board, visted);
            solve(n - 1, j, board, visted);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visted[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void solve(int i, int j, char[][] grid, boolean visted[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 'X' || visted[i][j]) {
            return;
        }
        visted[i][j] = true;
        solve(i + 1, j, grid, visted);
        solve(i - 1, j, grid, visted);
        solve(i, j - 1, grid, visted);
        solve(i, j + 1, grid, visted);
        return;
    }
}