class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] lf=new int[n];
        lf[0]=nums[0];
        int rf=nums[n-1],ans=-1;
        for(int i=1;i<n;i++){
          lf[i]=Math.max(nums[i],lf[i-1]);
        }
        for(int i=n-1;i>=0;i--){
              rf=Math.min(rf,nums[i]);
          int t=lf[i]-rf;
          if(t<=k){
            ans=i;
         }
        }
        return ans;
    }
}