class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        solve(0,graph,temp,ans);
        return ans;
        
    }
    void solve(int curr,  int[][] graph,List<Integer> temp, List<List<Integer>> ans){
       if(curr==graph.length-1){
            ans.add(new ArrayList<>(temp));
            return ;
       }
       for(int i=0;i<graph[curr].length;i++){
            int next=graph[curr][i];
            temp.add(next);
            solve(next,graph,temp,ans);
            temp.remove(temp.size()-1);
       }
    }
}