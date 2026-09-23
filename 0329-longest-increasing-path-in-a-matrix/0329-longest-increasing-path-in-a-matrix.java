class Solution {
    public int longestIncreasingPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        // boolean [][]visted=new boolean[n][m];
        int [][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,dfs(i,j,dp,grid)); 
            }
        }
        return ans;

    }
    int dfs(int i, int j, int [][] dp,int [][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =1;
        if(i-1>=0 && grid[i-1][j]>grid[i][j] ){
            // visted[i-1][j]=true; 
            ans=Math.max(ans , 1+dfs(i-1, j , dp, grid));
            
        }
        if(i+1<grid.length && grid[i+1][j]>grid[i][j]){
            // visted[i+1][j]=true;
            ans=Math.max(ans , 1+dfs(i+1, j , dp, grid));
           
        }
        if(j+1<grid[0].length && grid[i][j+1]>grid[i][j]){
            // visted[i][j+1]=true;
            ans=Math.max(ans , 1+dfs(i, j+1, dp, grid));
            
        }
        if(j-1>=0 && grid[i][j-1]>grid[i][j]){
            // visted[i][j-1]=true;
            ans=Math.max(ans , 1+dfs(i, j-1 , dp, grid));
            
        }
        // visted[i][j]=false;
        return dp[i][j]=ans;
    }
}