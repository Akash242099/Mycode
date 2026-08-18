class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int a=nums[0],b=nums[n-1],p=0,q=0,maxi=-1,r=-1;
        int[] fr=new int[51];
        for(int x:nums){
            fr[x]++;
            maxi=Math.max(maxi,x);
        }
        if(k>n) return -1;
        if(n==1) return nums[0];
        for(int i=50;i>=0;i--){
            if(fr[i]!=0){
if(fr[i]==1){
    r=i;
    break;
}
            }
        }
        p=fr[a];
        q=fr[b];
         if(k==1) return r;
  if(k==n){
          return maxi;
        }
           if(a==b) return -1;
        if(p>1 && q>1) return -1;
         if(p>1) return b;
        if(q>1) return a;
         return Math.max(a,b);
    }
}