class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n=nums.size(),sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(x>sum)return -1;
        if(x==sum) return n;
        int p=sum-x,ans=-1;
        int j=0,k=0,l=0;
        for(int i=0;i<n;i++){
            k+=nums[i];
            while(j<=i && k>=p){
                if(k==p){
                    ans=max(ans,i-j+1);
                    
                }
                
                k-=nums[j];
           j++;         
        }
        }
        if(ans==-1) return ans;
        return n-ans;
    }
};