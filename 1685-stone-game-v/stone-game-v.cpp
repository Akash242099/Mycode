class Solution {
public:
    int dp[501][501];
   // vector<vector<int>>dp(501,vector<int>(501,-1));
    int recur(vector<int>& stoneValue,int i,int j){

        int l,r,ans=0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        for(int k=i;k<j;k++){
              if(i!=0)
              l=stoneValue[k]-stoneValue[i-1];
              else
              l=stoneValue[k];
              r=stoneValue[j]-stoneValue[k];
              if(r<l){
                  ans=max(ans,r+recur(stoneValue,k+1,j));
              }
              else if(l<r){
                  ans=max(ans,l+recur(stoneValue,i,k));
              }
              else{
                  ans=max(ans,r+max(recur(stoneValue,i,k),recur(stoneValue,k+1,j))); 
              }
          }
            
           return dp[i][j]=ans;
        }
      
    
    int stoneGameV(vector<int>& stoneValue) {
        int n=stoneValue.size();
      for(int i=1;i<n;i++){
          stoneValue[i]=stoneValue[i]+stoneValue[i-1];
      }  
         memset(dp,-1,sizeof(dp));
    return recur(stoneValue,0,n-1);
    }
};