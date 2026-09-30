class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int [][] dp=new int [m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(m-1,n-1,arr,dp);
    }
    int solve(int row,int col,int [][] arr,int [][] dp){
        
        if(row<0 || col< 0){
            return 0;
        }
        if(arr[row][col]==1){
            return 0;
        }
        if(row==0 && col==0){
            return 1;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        return dp[row][col]=solve(row-1,col,arr,dp)+solve(row,col-1,arr,dp);
    }
}