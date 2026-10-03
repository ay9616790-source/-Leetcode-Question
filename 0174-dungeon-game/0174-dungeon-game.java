class Solution {
    public int calculateMinimumHP(int[][] grid) {
       int [][] dp=new int[grid.length][grid[0].length];
       for(int i=0;i<grid.length;i++){
        Arrays.fill(dp[i],-1);
       }
        return solve(0,0,grid,dp);
    }
    int solve(int i, int j,int [][] grid,int [][] dp){
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]>0) return 1;
            return Math.abs(grid[i][j])+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i+1,j,grid,dp);
        int down=solve(i,j+1,grid,dp);
        int result=Math.min(right,down)-grid[i][j];
        return dp[i][j]=(result >0) ? result:1;
        

        

    }
}