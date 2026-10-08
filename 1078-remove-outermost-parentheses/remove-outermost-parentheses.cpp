class Solution {
public:
    string removeOuterParentheses(string S) {
       // stack<char>p;
        string r="";
        int p=0;
          for(int i=0;i<S.size();i++)
        {
            if(S[i]=='(' &&  p > 0)
            {
               // p.push(S[i]);
                r=r+S[i];
                p++;
            } 
              else if(S[i]=='(' &&  p==0)
                  p++;
            if(S[i]==')' && p > 1 )
            {
              //  p.pop();
                r=r+S[i];
                p--;
            }
            else if(S[i]==')' && p==1 )
                p--;
        }
        
        return r;
        
    }  
     /*   string removeOuterParentheses(string S) {
        string res;
        int opened = 0;
        for (char c : S) {
            if (c == '(' && opened++ > 0) res += c;
            if (c == ')' && opened-- > 1) res += c;
        }
        return res;
    }*/
        
        
    };    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       /* string k=" ";
        char r=' ';
        string h;
        
        for(int i=0;i<S.size();i++)
        {
            if(S[i]=='(')
            {
                p.push(S[i]);
                r=r+S[i];
            } 
            if(S[i]!=p.top())
            {
                p.pop();
                r=r+')';
            }
            if(p.empty())
            {
                h=r;
                h.erase(h.begin());
                h.erase(h.begin()+(h.size()-1));
                k=k+h;
                r=' ';
                
            }
        }
        return k;*/
