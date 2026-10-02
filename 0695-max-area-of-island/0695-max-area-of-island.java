class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean [][] visted=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visted[i][j]){
                     ans=Math.max(ans,dfs(i,j,grid,visted));
                }

             
            }
        }
        return ans;
    }
    int dfs(int i, int j, int[][] grid,boolean visted[][]){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0 || visted[i][j]) return 0;
       
        visted[i][j]=true;
        int a=dfs(i-1,j,grid,visted);
        int b=dfs(i+1,j,grid,visted);
        int c=dfs(i,j-1,grid,visted);
        int d=dfs(i,j+1,grid,visted);
        return 1+a+b+c+d;
    }
}