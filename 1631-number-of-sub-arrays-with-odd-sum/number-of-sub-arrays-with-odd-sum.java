class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int e=0,o=0,ans=0;
        int mod=1000000000+7;
         for(int i=1;i<n;i++){
arr[i]+=arr[i-1];
         }
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                ans=(ans+o)%mod;
                e++;
            }
            else{
                 ans=(ans+e)%mod;
                ans++;
                o++;
            }
        }
        return ans;
    }
}

// 1. 3. 5
// 1  4. 9
// 1  1  
