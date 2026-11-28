class Solution {
    int n;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, -1);

        int maxLen = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, solve(i, nums, dp, count));
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }

    int solve(int i, int[] nums, int[] dp, int[] count) {

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = 1;
        count[i] = 1;

        for (int j = 0; j < i; j++) {

            if (nums[j] < nums[i]) {

                int len = solve(j, nums, dp, count);

                if (len + 1 > dp[i]) {
                    dp[i] = len + 1;
                    count[i] = count[j];
                }
                else if (len + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
        }

        return dp[i];
    }
}