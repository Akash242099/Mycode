class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int n=nums.size(),res=0;
        int c=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                c++;
            }
            else{
                res=max(res,c);
                c=1;
            }
        }
          res=max(res,c);
              c=1;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                c++;
            }
            else{
                res=max(res,c);
                c=1;
            }
        }
          res=max(res,c);
        return res;
        
        
    }
};