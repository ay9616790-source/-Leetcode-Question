class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[][]=new int[nums.length][3];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        } 
        return solve(0,nums,dp,0);
    }
    int solve(int i, int[] nums, int[][] dp, int rem){
        if(i==nums.length){
            return rem ==0?0:Integer.MIN_VALUE/2; 
        }
        if(dp[i][rem] !=-1){
            return dp[i][rem];
        }
        int take=nums[i]+solve(i+1,nums,dp,(rem+nums[i])%3);
        int notake=solve(i+1,nums,dp,rem);
        return dp[i][rem]=Math.max(take,notake);
    }
}