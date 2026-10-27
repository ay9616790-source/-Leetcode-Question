class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);

            while (j - i  > k) {
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);

                if (freq.get(nums[i]) == 0) {
                    freq.remove(nums[i]);
                }

                i++;
            }

            if (j - i  <= k && freq.get(nums[j]) > 1) {
                return true;
            }
        }

        return false;
    }
}