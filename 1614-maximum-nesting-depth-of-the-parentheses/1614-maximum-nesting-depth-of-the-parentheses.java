class Solution {
    public int maxDepth(String s) {
        int maxCnt=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
            cnt++;
           }else if(s.charAt(i)==')'){
            maxCnt=Math.max(maxCnt,cnt);
            cnt--;
           }
        }
        return maxCnt;
    }
}