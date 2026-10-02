class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean visted[][]=new boolean [n][m];
        int ans[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                  q.add(new int[]{i,j,0});
                  visted[i][j]=true;
                  ans[i][j]=0;
                }
            }
        }
        
        while(!q.isEmpty()){
            int [] curr=q.remove();
            int i=curr[0];
            int j=curr[1];
            int t=curr[2];
           
            if(i-1>=0 && !visted[i-1][j] && mat[i-1][j]==1){
                ans[i-1][j]=t+1;
                q.add(new int []{i-1,j,t+1});
                visted[i-1][j]=true;
            }
            if(i+1<mat.length && !visted[i+1][j] && mat[i+1][j]==1){
                ans[i+1][j]=t+1;
                q.add(new int []{i+1,j,t+1});
                visted[i+1][j]=true;
            }
            if(j-1>=0 && !visted[i][j-1] && mat[i][j-1]==1){
                ans[i][j-1]=t+1;
                q.add(new int []{i,j-1,t+1});
                visted[i][j-1]=true;
            }
            if(j+1<mat[0].length && !visted[i][j+1] && mat[i][j+1]==1){
                ans[i][j+1]=t+1;
                q.add(new int []{i,j+1,t+1});
                visted[i][j+1]=true;
            }


        }
        return ans;
    }
}