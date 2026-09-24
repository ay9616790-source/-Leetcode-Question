class Solution {
    public int smallestIndex(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=10){
                int n=nums[i];
                int sum=0;
                while(n!=0){
                     sum+=n%10;
                    
                    n=n/10;
                }
                if(sum==i){
                    ans=Math.min(ans,i);
                }
            }
              if(nums[i]==i && nums[i]<10){
                ans=Math.min(ans,i);
              }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}