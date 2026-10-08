class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!st.isEmpty())
                    str.append(ch);

                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty())
                    str.append(ch);

            }
        }
        return str.toString();
        // for(int i=0;i<s.length();i++) {
        //     char ch = s.charAt(i);
        //    if(ch=='('){
        //        if(!st.isEmpty()){
        //            str.append(ch);
        //        }
        //        st.push(ch);
        //    }else{
        //        st.pop();
        //        if(!st.isEmpty()){
        //            str.append(ch);
        //        }
        //    }
        // }
        // return str.toString();
    }
}