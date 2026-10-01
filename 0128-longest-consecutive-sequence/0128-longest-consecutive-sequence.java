class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int max = 0;
        int curr = 1;

        for(int i = 0; i < nums.length - 1; i++) {

            if(nums[i] + 1 == nums[i + 1]) {
                curr++;
            }
            else if(nums[i] == nums[i + 1]) {
                
            }
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }

        max = Math.max(max, curr);

        return max;
    }
}