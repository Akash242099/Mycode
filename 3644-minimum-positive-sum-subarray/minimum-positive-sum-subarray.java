class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
    int n=nums.size();
    int ans=Integer.MAX_VALUE;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
           int sum=0;
           if(j-i+1>=l && j-i+1<=r){
         for(int k=i;k<=j;k++){
         sum+=nums.get(k);
         }
         if(sum>0)
         ans=Math.min(ans,sum);
           }
        }
    }


    return ans==Integer.MAX_VALUE?-1:ans;

    }
}