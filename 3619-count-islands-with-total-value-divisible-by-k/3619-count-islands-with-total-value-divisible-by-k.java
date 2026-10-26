class Solution {
    int n;
    int m;
    public int countIslands(int[][] grid, int k) {
         n=grid.length;
         m=grid[0].length;
          int count=0;
        boolean visted[][]=new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !visted[i][j]){
                    long a=solve(i, j, grid, visted);
                    if(a%k==0) count++;
                }
            }
        }
        return count;
    }
    long solve(int i, int j, int [][]grid,boolean  visted[][]){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(visted[i][j] || grid[i][j]==0){
            return 0;
        }
        visted[i][j]=true;
        long sum=grid[i][j];
        sum+=solve(i+1,j,grid,visted);
        sum+=solve(i-1,j,grid,visted);
        sum+=solve(i,j-1,grid,visted);
        sum+=solve(i,j+1,grid,visted);
        return sum;
    }
}