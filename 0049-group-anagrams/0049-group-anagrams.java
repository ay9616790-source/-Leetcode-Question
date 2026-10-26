
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        String[] arr = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            arr[i] = sorted(strs[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();

            if (arr[i] == null) {
                continue;
            }

            temp.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (arr[i].equals(arr[j])) {
                    arr[j] = null;
                    temp.add(strs[j]);
                }
            }

            ans.add(temp);
        }

        return ans;
    }

    String sorted(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
