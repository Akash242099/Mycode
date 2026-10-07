class Solution {
public:
  int  getminRemoval(string str)
    {
        stack<char>s;
        for(auto &x:str)
        {
            if(x=='(')
            s.push('(');
            else if(x==')')
            {
                if(s.empty())
                    s.push(')');
                else if(s.top()=='(')
                    s.pop();
                else
                     s.push(')');
             }
            
        }
        return s.size();
    }
    void Rip(string s,int gmr,vector<string>&ans,unordered_map<string,bool>&mp)
    {
        if(mp[s]==1) return;        // if already go back
        else mp[s] = 1;
        if(gmr<0) return;
        if(gmr==0)
        {
            int p=getminRemoval(s);
            if(p==0)
            {
                 ans.push_back(s);
            }
            return;
        }
        for(int i=0;i<s.size();i++)
        {
            if(s[i]!='(' && s[i]!=')')
                continue;
            string l=s.substr(0,i);
            string r=s.substr(i+1);
             Rip(l+r,gmr-1,ans,mp);
        }
       
    }
    vector<string> removeInvalidParentheses(string s) {
        int gmr=getminRemoval(s);

        vector<string>ans;
        unordered_map<string,bool>mp;
        Rip(s,gmr,ans,mp) ;
        
        return ans;
        
        
    }
};