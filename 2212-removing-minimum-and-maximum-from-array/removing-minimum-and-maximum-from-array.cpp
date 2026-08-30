class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int mini=INT_MAX;
        int maxi=INT_MIN;
        int n=nums.size();
        int p,q;
        for(int i=0;i<nums.size();i++){
            if(maxi<nums[i]){
                maxi=nums[i];
                p=i;
            }
            if(mini>nums[i]){
                mini=nums[i];
                q=i;
            }
                
        }
        int ans1=max(p,q)+1;
        int ans2=n-min(p,q);
        int ans3=n-max(p,q)+min(p,q)+1;
        return min({ans1,ans2,ans3});
    }
};