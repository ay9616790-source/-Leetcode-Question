class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        int len = solve(0, 0, s1, s2, dp);
        return print(0, 0, s1, s2, dp);
    }

    String print(int i, int j, String s1, String s2, int[][] dp) {
        StringBuilder st = new StringBuilder();
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                st.append(s1.charAt(i));
                i++;
                j++;
            } else if (solve(i + 1, j, s1, s2, dp) <= solve(i, j + 1, s1, s2, dp)) {
                st.append(s1.charAt(i));
                i++;
            } else {
                st.append(s2.charAt(j));
                j++;
            }
        }
        while (i < s1.length()) {
            st.append(s1.charAt(i));
            i++;
        }

        while (j < s2.length()) {
            st.append(s2.charAt(j));
            j++;
        }

        return st.toString();
    }

    int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i >= s1.length()) {
            return s2.length() - j;
        }
        if (j >= s2.length()) {
            return s1.length() - i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + solve(i + 1, j + 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.min(1 + solve(i + 1, j, s1, s2, dp), 1 + solve(i, j + 1, s1, s2, dp));
        }
        return dp[i][j];
    }
}