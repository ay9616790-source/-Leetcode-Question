import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }

    List<Integer> solve(String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*' || ch == '+' || ch == '-') {
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i + 1));

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (ch == '*') {
                            ans.add(left.get(j) * right.get(k));
                        } else if (ch == '+') {
                            ans.add(left.get(j) + right.get(k));
                        } else {
                            ans.add(left.get(j) - right.get(k));
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(s));
        }

        return ans;
    }
}