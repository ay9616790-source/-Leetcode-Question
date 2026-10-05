class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=0;i<s.length();i++){
            if( s.charAt(i)=='('){
                st.push(0);
            }else{
                int val=st.pop();
                int score=(val==0) ?1:2*val;
                int parent=st.pop();
                st.push(parent+score);
            }
        }
        return st.pop();
    }
}