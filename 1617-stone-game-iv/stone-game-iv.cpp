class Solution {
public:
    
    bool helper(int n,vector<bool>&dp){
        if(n==0){
            return false;
        }
        if(dp[n]!=false)
            return dp[n];
        bool p=false;
        for(int i=1;i*i<=n;i++){
              p=p || !helper(n-i*i,dp);
        }
        return dp[n]=p;
    }
    bool winnerSquareGame(int n) {
        vector<bool>dp(n+1,false);
        bool ans=helper(n,dp);
        
       return ans;
    }
};