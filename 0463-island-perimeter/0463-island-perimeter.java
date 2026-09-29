class Solution {

    public int islandPerimeter(int[][] grid) {

        boolean[][] visited =
            new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {
                    return solve(i, j, grid, visited);
                }
            }
        }

        return 0;
    }

    int solve(int i, int j, int[][] grid, boolean[][] visited) {

        
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length) {
            return 1;
        }

        if (grid[i][j] == 0) {
            return 1;
        }

   
        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int up = solve(i - 1, j, grid, visited);
        int down = solve(i + 1, j, grid, visited);
        int left = solve(i, j - 1, grid, visited);
        int right = solve(i, j + 1, grid, visited);

        return up + down + left + right;
    }
}