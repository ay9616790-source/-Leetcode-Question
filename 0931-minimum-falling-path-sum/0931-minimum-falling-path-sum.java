class Solution {
    public int minFallingPathSum(int[][] mat) {
     Integer [][] dp=new Integer [mat.length][mat[0].length];
        // for(int i=0;i<mat.length;i++){
        //     Arrays.fill(dp[i],Integer.MAX_VALUE);
        // }
        int ans=Integer.MAX_VALUE;
        
            for(int j=0;j<mat[0].length;j++){
                ans=Math.min(ans,solve(0,j,mat,dp));
            }
        
        return ans;
    }
    int solve(int i, int j, int [][]mat,Integer[][]dp){
         
        
        if( i>=mat.length || j<0 || j>=mat[0].length){
            return Integer.MAX_VALUE;
        }
         if(i==mat.length-1){
            return mat[i][j];
        }
       
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        int downLeft=solve(i+1,j-1,mat,dp);
        int down=solve(i+1,j,mat,dp);
        int downRight=solve(i+1,j+1,mat,dp);
        ans=Math.min(down,Math.min(downLeft,downRight));
         if (ans == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }
       return dp[i][j]= mat[i][j] +ans;
    }
}