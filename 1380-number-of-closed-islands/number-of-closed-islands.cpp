class Solution {
public:
        bool dfs(vector<vector<int>> &grid,int i,int j,int n,int m)
       {
     if(i<0 || j<0 || i>=n || j>=m )
         return false;
            if(grid[i][j]==1)
                return true;
        grid[i][j]=1;
           
       bool d= dfs(grid,i+1,j,n,m);
     
       bool u= dfs(grid,i-1,j,n,m);
        
       bool r= dfs(grid,i,j+1,n,m);
    
       bool l= dfs(grid,i,j-1,n,m);
            
       return l && d  && r  && u;
      
        
    }
    int closedIsland(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    
                if(dfs(grid,i,j,n,m)) 
                   ans++;
                }
            }
        }
        return ans;
    }
};