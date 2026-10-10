
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int [][] dp=new int[nums.size()+1][target+1];
        for(int i=0;i<=nums.size();i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(0, nums, target,dp);
        return ans < 0 ? -1 : ans;
    }

    int solve(int i, List<Integer> nums, int tar,int [][]dp) {
        if (tar == 0) {
            return 0;
        }
       if(dp[i][tar]!=-1){
        return dp[i][tar];
       }
        if (i == nums.size() || tar < 0) {
            return -1000000;
        }

        int take = -1000000;

        if (nums.get(i) <= tar) {
            take = 1 + solve(i + 1, nums, tar - nums.get(i),dp);
        }

        int nottake = solve(i + 1, nums, tar,dp);

        return dp[i][tar]=Math.max(take, nottake);
    }
}
