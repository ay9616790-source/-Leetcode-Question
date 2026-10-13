
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        long sum = 0;

        while (i < j) {
            sum += nums[j];
            sum -= nums[i];
            j--;
            i++;
        }

        if (i == j) {
            sum += nums[i];
        }

        return sum;
    }
}
