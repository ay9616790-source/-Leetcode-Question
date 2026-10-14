class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
    int solve(int i, int [] nums,int [] dp){
        if(i>=nums.length-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            int next=i+j;
            if(next<nums.length){
                int jump=solve(next,nums,dp);
                if(jump!=Integer.MAX_VALUE){
                    ans=Math.min(ans,1+jump);
                }
            }
        }
        return dp[i]=ans;
    }
}