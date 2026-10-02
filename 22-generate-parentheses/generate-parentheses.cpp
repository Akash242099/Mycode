class Solution {
public:
    vector<string>v;
    void gp(string lf,int l,int r )
    {
      
        if(l==0 && r==0)
        {
           
        v.push_back(lf);
            return ;
        }

        if(l>0)
          gp(lf+"(",l-1,r);
        if(r>l)
          gp(lf+")",l,r-1);
    }
    vector<string> generateParenthesis(int n) {
        
        gp( "",n,n);
        return v;
    }
};