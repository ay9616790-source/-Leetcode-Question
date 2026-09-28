class Solution {
    public int maxCoins(int[] nums) {
         int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int dp[][]=new int[nums.length+2][nums.length+2];
        
        for(int i=1;i<nums.length+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(1,nums.length,arr,dp);
    }
    int solve(int i, int j,int[] nums, int[][] dp){
        
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=0;
        for(int k=i;k<=j;k++){
        int cost=nums[i-1]*nums[k]*nums[j+1]+solve(i,k-1,nums,dp)+solve(k+1,j,nums,dp);
        max=Math.max(cost,max);
        }
        return dp[i][j]=max;
    }
}