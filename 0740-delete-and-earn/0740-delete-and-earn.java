class Solution {
    public int deleteAndEarn(int[] nums) {

        // Step 1: Frequency count
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find maximum number
        int max = 0;

        for (int key : map.keySet()) {
            max = Math.max(max, key);
        }

        // Step 3: Points array
        int[] points = new int[max + 1];

        for (int key : map.keySet()) {
            points[key] = key * map.get(key);
        }

        // Step 4: House Robber DP
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i <= max; i++) {

            int take = prev2 + points[i];
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}