class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length,m=arr2.length,ans=0;
        for(int i=0;i<n;i++){
            int j;
            for( j=0;j<m;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                  break;
                }
              
            }
              if(j==m) ans++;
        }
        return ans;
    }
}