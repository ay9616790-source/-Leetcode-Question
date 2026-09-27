class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                st.push(s.charAt(i));
            }
            else{
                String str="";
                while( !st.isEmpty() && st.peek()!='('){
                    str+=st.pop();
                }
               if(!st.isEmpty()){
                 st.pop();
               }
                for(int j=0;j<str.length();j++){
                    st.push(str.charAt(j));
                }
            }
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        return ans;
    }
}