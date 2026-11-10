class Solution {
    int[] dp;
    int helper(int n,int i,int[] costs){
       if(i>=n-1) return 0;
      int f=Integer.MAX_VALUE,s=Integer.MAX_VALUE,t=Integer.MAX_VALUE;
      if(dp[i+1]!=Integer.MAX_VALUE) return dp[i+1];
      if(i+1<n){
        f= costs[i+1]+1+helper(n,i+1,costs);
      }
        if(i+2<n){
        s= costs[i+2]+4+helper(n,i+2,costs);
      }
        if(i+3<n){
        t= costs[i+3]+9+helper(n,i+3,costs);
      }
      return dp[i+1]=Math.min(f,Math.min(s,t));
       
    }
    public int climbStairs(int n, int[] costs) {
        dp=new int[n+5];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return helper(n,-1,costs);
    }
}