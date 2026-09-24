class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        // Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> set=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        solve(0,temp,set,arr,target);
        return new ArrayList<>(set);

    }
    void solve(int start,ArrayList<Integer> temp,List<List<Integer>> set,int[] arr,int target ){
        
            if(target==0){
               set.add(new ArrayList<>(temp));
               return ;
            }
           
        
        for(int i=start;i<arr.length;i++){
             if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if(target<arr[i]){
                break;
            }
            
                temp.add(arr[i]);
            solve(i+1,temp,set,arr,target-arr[i]);
            temp.remove(temp.size()-1);
            

        }
       
    }
}