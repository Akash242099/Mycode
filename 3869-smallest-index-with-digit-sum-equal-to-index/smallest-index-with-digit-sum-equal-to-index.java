class Solution {
       public int helper(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i==helper(nums[i])){
                return i;
            }
        }
        return -1;
    }
 
}