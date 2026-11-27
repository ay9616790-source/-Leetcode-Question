import java.util.Arrays;

class Solution {

    int solve(int[] nums, int i, int[] dp) {

        if (i < 2) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (nums[i] - nums[i - 1] ==
            nums[i - 1] - nums[i - 2]) {

            dp[i] = 1 + solve(nums, i - 1, dp);
        } else {
            dp[i] = 0;
        }

        return dp[i];
    }

    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 2; i < n; i++) {
            ans += solve(nums, i, dp);
        }

        return ans;
    }
}