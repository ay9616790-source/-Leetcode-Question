class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[]=new int [n];
        Arrays.fill(dp,-1);
        int dp2[]=new int [n];
        Arrays.fill(dp2,-1);
        return Math.max(solve(1,nums,n-1,dp),solve(0,nums,n-2,dp2));
    }
    int solve(int i,int [] nums,int last,int []dp){
        if(i>last){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(solve(i+1,nums,last,dp),solve(i+2,nums, last,dp)+nums[i]);
        
    }
}