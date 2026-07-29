
class Solution {
public:
    using ll = long long;
    ll mod = 1e9+7;
    ll pos(vector<int> & alpha , int k){ 
        vector<ll> m;
        ll n =0;
        for(int i : alpha){
            n+=i;
            if(i>=1){
                m.push_back(i);
            }
        }

        ll num =1 ,add=1;
        for(ll i : m){
            for(ll j = 1 ; j<=i; j++){
                num = (num *add);
                add++;
                num/=j;
                if(num >=k){
                    return k;
                }
            }
        }
        return num;
    }
    string smallestPalindrome(string s, int k) {
        string temp ;
        int n = s.length();
        vector<int> alpha(26,0);
        for(int i =0 ; i <n/2 ; i++ ){
            temp.push_back(s[i]);
            alpha[s[i]-'a']++;
        }
        sort(temp.begin(),temp.end());
        
        string ans;
        ll tot =0;
        for(int i = 0 ;i < n/2; i++ ){ 
            bool ok = true;
            for(int j =0 ; j<26 ; j++ ){
                if(alpha[j]!=0){
                    alpha[j]--; 
                    int val = pos(alpha,k);
                    tot += val; 
                    alpha[j]++; 
                 
                    if(tot >=k){
                        alpha[j]--;
                        tot -= val;
                        ans.push_back(j+'a');
                        ok = false;
                       
                        break;
                    }
                   
                }
            }
           
            
            if(ok){
               
                return "";
            }
          
            
        }
      
        string t =ans;
        reverse(t.begin(),t.end());
        if(n&1){
            ans.push_back(s[(n)/2]);
        }
        ans +=t;
        return ans;
    }
};