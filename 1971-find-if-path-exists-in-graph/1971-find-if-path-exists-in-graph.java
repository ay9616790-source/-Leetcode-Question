class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
         boolean[] visited = new boolean[n];
        return dfs(source,graph,destination,visited);

    }
    boolean dfs(int curr,ArrayList<Integer>[] graph,int dest,boolean[] visited){
        if(curr==dest){
            return true;
        }
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int next=graph[curr].get(i);
            if (!visited[next]) {

                if (dfs(next, graph, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}