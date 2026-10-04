class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans=Integer.MAX_VALUE;
        int [][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<grid[0].length;i++){
            ans=Math.min(ans,solve(0,i,grid,dp));
        }
        return ans;
    }
    int solve(int i, int j ,int [][] grid,int [][] dp){
       
        if(i==grid.length-1){
            return grid[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<grid[0].length;k++){
            if(k!=j){
                ans=Math.min(ans,grid[i][j]+solve(i+1,k,grid,dp));
            }
        }
        return dp[i][j]=ans;
        
    }
}