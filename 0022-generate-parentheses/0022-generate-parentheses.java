class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        
         solve(0,0,n,ans,"");
         return ans;
    }
     void solve(int open ,int close,int n,List<String> ans,String s){
        if(s.length()==n*2){
             ans.add(s);
             return ;
        }
        if(open<n){
           solve(open+1,close,n,ans,s+"(");
        }
        if(close<open){
            solve(open,close+1,n,ans,s+")");
        }
    }
}