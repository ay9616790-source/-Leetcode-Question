class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
       for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
       }
       int []arr=new int[max+1];
       for(int i=0;i<nums.length;i++){
         arr[nums[i]]+=nums[i];
       }
       int dp[]=new int[max+1];
       Arrays.fill(dp,-1);
       return solve(0,arr,dp);

    }
    int solve(int i, int[] arr,int [] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
         return dp[i] = Math.max(solve(i+1,arr,dp),arr[i]+solve(i+2, arr, dp));
        
    }
}