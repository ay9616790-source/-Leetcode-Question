class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            dp[i]=-1;
        }
        return solve(n,dp,nums);
    }

      int solve(int n,int []dp,int []nums){
        if(n==0 ){
            return 0;
        }
        if(n==1){
          return  dp[n]=nums[0];
        }
        if(n==2){
         return dp[n]=Math.max(nums[0], nums[1]);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
       dp[n] = Math.max(solve(n-1, dp, nums),solve(n-2, dp, nums) + nums[n-1]);

        return dp[n];
    }
}