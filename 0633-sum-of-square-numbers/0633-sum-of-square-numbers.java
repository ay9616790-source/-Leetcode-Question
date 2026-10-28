class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==2) return true;
        int n = (int) Math.ceil(Math.sqrt(c));
        int [] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=i;
        }
        int i=0;
        int j=n;
        while(i<=j){
            long left=(long)arr[i]*arr[i];
            long right=(long)arr[j]*arr[j];
            if(left+right==c){
                return true;
            }
            if(left+right<c){
                i++;
            }else if(left+right>c){
                j--;
            }
        }
        return false;
    }
}