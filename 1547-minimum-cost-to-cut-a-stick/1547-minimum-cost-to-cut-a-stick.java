class Solution {
    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        int m = cuts.length;

        int newCuts[] = new int[m + 2];

        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }

        int dp[][] = new int[m + 2][m + 2];

        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(1, m, newCuts, dp);
    }

    int solve(int i, int j, int[] cuts, int[][] dp) {

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = cuts[j + 1] - cuts[i - 1]
                    + solve(i, k - 1, cuts, dp)
                    + solve(k + 1, j, cuts, dp);

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}