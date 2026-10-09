class Solution {
    int n ; 
    int m ; 
    public int cherryPickup(int[][] grid) {
        n= grid.length; 
        m = grid[0].length ; 
        int dp [][][] = new int[n][n][n];

        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j<n;j++){
            Arrays.fill(dp[i][j] , -1);
            }
        }

       return Math.max(0, solve(0, 0, 0, grid , dp));
    }
    int solve(int r1 , int c1, int r2 , int[][] grid , int dp[][][]){
        int c2 = r1+c1-r2;
        if (r1 >= n || c1 >= n ||  r2 >= n || c2 >= n) {
            return -10000;
        }
        if(grid[r1][c1] == -1 || grid[r2][c2]==-1) return -10000 ; 
        if(r1 == n-1 && c1==n-1 ) return grid[r1][c1];
         if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }
        int chery = grid[r1][c1]; 
        if(r1 != r2 || c1 != c2){
           chery += grid[r2][c2]; 
        }

        int option4 = solve(r1, c1 + 1, r2, grid , dp );
         int option1 = solve(r1 + 1, c1, r2 + 1, grid, dp );
        int option2 = solve(r1 + 1, c1, r2, grid , dp);
        int option3 = solve(r1, c1 + 1, r2 + 1, grid , dp);
        

         int best = Math.max(
            Math.max(option1, option2),
            Math.max(option3, option4)
        );

        return dp[r1][c1][r2] = best + chery ; 
    }
}