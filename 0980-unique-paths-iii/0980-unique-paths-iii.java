class Solution {
    public int uniquePathsIII(int[][] grid) {
        boolean visted[][]=new boolean  [grid.length][grid[0].length];
        int count=0;
        int st=0;
        int se=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1) count++;
                if(grid[i][j]==1){
                    st=i;
                    se=j;
                }
            }
        }
        return solve(st,se,grid,visted,count);
        
    }
    int solve(int i, int j, int [][] grid,boolean [][] visted, int count){
         
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0 ;
        }
        if(grid[i][j]==-1 || visted[i][j]){
            return 0;
        }
         if(grid[i][j] == 2) {
            return count == 1 ? 1 : 0;
        }
      visted[i][j]=true;
        int up=solve(i-1,j,grid,visted,count-1);
        
        int down=solve(i+1,j,grid,visted,count-1);
        int right=solve(i,j+1,grid,visted,count-1);
        int left=solve(i,j-1,grid,visted,count-1);
        visted[i][j]=false;
        return up+down+right+left;
    }
}