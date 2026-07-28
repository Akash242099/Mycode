class Solution {
public:
    string smallestPalindrome(string s) {
        vector<int>mp(26,0);
        int n=s.size();
        for(auto &x:s){
            mp[x-'a']++;
            
        };
        string ans(n,' ');
       
        int g=0,h=n-1;
        for(int i=0;i<26;i++){
              
            if(mp[i]){
                char p=(char)(i+'a');
                int k=mp[i];
               
                 if(k%2==1){
                     k--;
                     ans[n/2]=p;
                 }
                while(k){
                    ans[g]=p;
                    g++;
                    ans[h]=p;
                
                    h--;
                    k-=2;
                    
                
                }
            }
        }
        return ans;
       
        
    }
};