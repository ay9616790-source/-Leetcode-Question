class Solution {
    public int minimumRecolors(String s, int k) {
        int i=0;
        int wt=0;
        int min=Integer.MAX_VALUE;
        
        for(int j=0;j<s.length();j++){
           if(s.charAt(j)=='W'){
            wt++;
           }
           while(j-i+1>k){
                if(s.charAt(i)=='W'){
                    wt--;
                }
                i++;
           }
           if(j-i+1==k){
            min=Math.min(min,wt);
           }
        }
        return min;
    }
}