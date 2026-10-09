class Solution {
    int n;
    int m;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, m - 1, grid, dp);
    }

    int solve(int r1, int c1, int c2, int[][] grid, int[][][] dp) {
        if (r1 >= n || c1 >= m || c1 < 0 || c2 >= m || c2 < 0) {
            return Integer.MIN_VALUE / 2;
        }
        int charry = grid[r1][c1];
        if (c1 != c2) {
            charry += grid[r1][c2];
        }
        if (r1 == n - 1) {
            return dp[r1][c1][c2] = charry;
        }
        if(dp[r1][c1][c2]!=-1){
            return dp[r1][c1][c2];
        }
        int a = solve(r1 + 1, c1 - 1, c2 - 1, grid, dp);
        int b = solve(r1 + 1, c1 - 1, c2, grid, dp);
        int c = solve(r1 + 1, c1 - 1, c2 + 1, grid, dp);

        int d = solve(r1 + 1, c1, c2 - 1, grid, dp);
        int e = solve(r1 + 1, c1, c2, grid, dp);
        int f = solve(r1 + 1, c1, c2 + 1, grid, dp);

        int g = solve(r1 + 1, c1 + 1, c2 - 1, grid, dp);
        int h = solve(r1 + 1, c1 + 1, c2, grid, dp);
        int k = solve(r1 + 1, c1 + 1, c2 + 1, grid, dp);

        int best = Math.max(
                Math.max(Math.max(a, b), Math.max(c, d)),
                Math.max(Math.max(e, f), Math.max(g, Math.max(h, k))));

        return dp[r1][c1][c2] = charry + best;
    }
}