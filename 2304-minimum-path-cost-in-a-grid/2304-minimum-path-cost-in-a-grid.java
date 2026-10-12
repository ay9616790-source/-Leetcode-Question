class Solution {
    int n;
    int m;
   
    public int minPathCost(int[][] grid, int[][] moveCost) {
         n=grid.length;
         m=grid[0].length;
       
        int dp[][]=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,solve(0,i,grid,moveCost,dp));
        }
        return ans;
    }
    int solve(int i, int j, int [][] grid,int [][]cost,int [][]dp){
        if(i==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        
        for(int k=0;k<m;k++){
             ans=Math.min(ans,grid[i][j]+cost[grid[i][j]][k]+solve(i+1,k,grid,cost,dp));
        }
        return dp[i][j]=ans;
    }
}