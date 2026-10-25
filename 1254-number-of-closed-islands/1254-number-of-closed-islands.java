class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(i, j, visited, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean dfs(int i, int j, boolean[][] visited, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (grid[i][j] == 1 || visited[i][j]) {
            return true;
        }

        visited[i][j] = true;

        boolean down  = dfs(i + 1, j, visited, grid);
        boolean up    = dfs(i - 1, j, visited, grid);
        boolean right = dfs(i, j + 1, visited, grid);
        boolean left  = dfs(i, j - 1, visited, grid);

        return down && up && right && left;
    }
}