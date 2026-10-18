import java.util.*;

class Solution {
    int[][] dp;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        dp = new int[n][k + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(flights, src, dst, k + 1, n);

        return ans >= 100000000 ? -1 : ans;
    }

    int solve(int[][] flights, int src, int dst, int stops, int n) {
        if (src == dst) {
            return 0;
        }

        if (stops == 0) {
            return 100000000;
        }

        if (dp[src][stops] != -1) {
            return dp[src][stops];
        }

        int minCost = 100000000;

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            if (from == src) {
                int remainingCost =
                    solve(flights, to, dst, stops - 1, n);

                if (remainingCost != 100000000) {
                    minCost = Math.min(minCost, price + remainingCost);
                }
            }
        }

        return dp[src][stops] = minCost;
    }
}