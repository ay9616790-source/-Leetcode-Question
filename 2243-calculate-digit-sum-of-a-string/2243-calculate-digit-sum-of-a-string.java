class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            String str = "";

            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                int j = i;

                while (j < i + k && j < s.length()) {
                    sum += s.charAt(j) - '0';
                    j++;
                }

                str += sum;
            }

            s = str;
        }

        return s;
    }
}