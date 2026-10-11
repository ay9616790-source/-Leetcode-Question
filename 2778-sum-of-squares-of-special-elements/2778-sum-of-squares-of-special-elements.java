class Solution {
    public int sumOfSquares(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=1;i<=nums.length;i++){
            if(n%i==0){
                st.push(nums[i-1]*nums[i-1]);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
           sum+=st.pop();
        }
        return sum;
    }
}