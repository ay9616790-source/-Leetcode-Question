class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length];
        Arrays.fill(dp,-1);
        return solve(0,days,costs,dp);
    }
    int solve(int i,int [] arr,int [] costs, int [] dp){
        if(i>=arr.length){
            return 0;
        }
       if(dp[i]!=-1){
        return dp[i];
       }
       int OneDay=costs[0]+solve(i+1,arr,costs,dp);
       int j=i;
       while(j<arr.length && arr[j]<arr[i]+7){
        j++;
       }
       int SevenDays=costs[1]+solve(j,arr,costs,dp);
       j=i;
       while(j<arr.length && arr[j]<arr[i]+30){
        j++;
       }
       int thirtyDay=costs[2]+solve(j,arr,costs,dp);
       return dp[i]=Math.min(OneDay,Math.min(SevenDays,thirtyDay));
        

        
    }
    
}