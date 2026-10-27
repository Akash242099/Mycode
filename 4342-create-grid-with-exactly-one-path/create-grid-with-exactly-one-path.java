class Solution {
    public String[] createGrid(int m, int n) {
        char [][] dp=new char[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]='.';
        }
        for(int i=0;i<m;i++){
            dp[i][n-1]='.';
        }

        String[] ans=new String[m];
        for(int i=0;i<m;i++){
            String res="";
            for(int j=0;j<n;j++){
                if(dp[i][j]!='.'){
                    dp[i][j]='#';
                }
                res+=dp[i][j];
            }
            ans[i]=res;
        }
        return ans;
    }
}