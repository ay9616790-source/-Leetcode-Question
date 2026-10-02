class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visted=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        int ans=0;
        if(grid[0][0]!=0){
            return -1;
        }
        q.add(new int[]{0,0,1});
        visted[0][0]=true;
        while(!q.isEmpty()){
            int[] curr= q.remove();
            int i=curr[0];
            int j=curr[1];
            int t=curr[2];
            
            ans=Math.max(ans,t);
            if(i==n-1 && j==m-1){
                return ans;
            }
            if(i-1>=0 && !visted[i-1][j] && grid[i-1][j]==0){
                visted[i-1][j]=true;
                q.add(new int[]{i-1,j,t+1});
            }
            if(i-1>=0 && j-1>=0 && !visted[i-1][j-1] && grid[i-1][j-1]==0){
                visted[i-1][j-1]=true;
                q.add(new int[]{i-1,j-1,t+1});
            }
            if(i-1>=0 && j+1<grid[0].length && !visted[i-1][j+1] && grid[i-1][j+1]==0){
                visted[i-1][j+1]=true;
                q.add(new int[]{i-1,j+1,t+1});
            }
            if(i+1<grid.length && !visted[i+1][j] && grid[i+1][j]==0){
                visted[i+1][j]=true;
                q.add(new int[]{i+1,j,t+1});
            }
            if(i+1<grid.length && j-1 >=0 && !visted[i+1][j-1] && grid[i+1][j-1]==0){
                visted[i+1][j-1]=true;
                q.add(new int[]{i+1,j-1,t+1});
            }
            if(i+1<grid.length && j+1<grid[0].length && !visted[i+1][j+1] && grid[i+1][j+1]==0){
                visted[i+1][j+1]=true;
                q.add(new int []{i+1,j+1,t+1});
            }
            if(j-1>=0 && !visted[i][j-1] && grid[i][j-1]==0){
                visted[i][j-1]=true;
                q.add(new int[]{i,j-1,t+1});
            }
            if(j+1<grid[0].length && !visted[i][j+1] && grid[i][j+1]==0){
                visted[i][j+1]=true;
                q.add(new int[]{i,j+1,t+1});
            }
        }
        return -1;
        
    }

   
}