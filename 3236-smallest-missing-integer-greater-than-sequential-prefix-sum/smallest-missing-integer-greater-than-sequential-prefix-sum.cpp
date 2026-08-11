class Solution {
public:
    int missingInteger(vector<int>& nums) {
        unordered_map<int,int>mp;
        for(auto &x:nums){
            mp[x]++;
        }
        int n=nums.size();
       
        int ans=nums[0];
        if(n==1){
            return ans+1; 
        }
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]==1){
                ans=ans+nums[i];
                
            
            }
            else break;
        }
        while(true){
           if(mp.count(ans))  ans++;
            else return ans;
        }
        return -1;
    }
};