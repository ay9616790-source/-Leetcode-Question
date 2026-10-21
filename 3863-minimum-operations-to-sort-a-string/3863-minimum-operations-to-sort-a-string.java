class Solution {
    public int minOperations(String s) {
        boolean sort=true;
        int n=s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)>s.charAt(i+1)){
                sort=false;
                break;
            }
        }
        if(sort) return 0;
        if(n==2) return -1;
        char min='z';
        char max='a';
        for(int i=0;i<n;i++){
            min=(char) Math.min(min,s.charAt(i));
            max=(char) Math.max(max,s.charAt(i));
        }
        if(s.charAt(0)==min || s.charAt(n-1)==max){
            return 1;
        }
        for(int i=1;i<n-1;i++){
               if(s.charAt(i)==min || s.charAt(i)==max){
                return 2;
               }
        }
        return 3;
    }
}