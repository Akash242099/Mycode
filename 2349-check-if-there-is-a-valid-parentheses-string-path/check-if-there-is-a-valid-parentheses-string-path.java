// class Solution {
//     int n,m;
    
//     public boolean helper(int i,int j,int l,int r,char[][] grid){
//         if(i<0 || i>=n || j<0  || j>=m) return false;
//         if(grid[i][j]=='('){
//             l++;
//         }
//            if(grid[i][j]==')'){
//             r++;
//         }
//         if(r>l) {
             
//         if(grid[i][j]=='('){
//             l++;
//         }
//            if(grid[i][j]==')'){
//             r++;
//         }
//             return false;

//         }
//         if(i==n-1 && j==m-1){
//             if(l==r) return true;
//             else {
             
//         if(grid[i][j]=='('){
//             l++;
//         }
//            if(grid[i][j]==')'){
//             r++;
//         }
//             return false;

//         }
//         }
     
//     boolean down= helper(i+1,j,l,r,grid);
 
     
//     boolean right= helper(i,j+1,l,r,grid);

//     return down || right;
      
//     }
//     public boolean hasValidPath(char[][] grid) {
//         n=grid.length;
//         m=grid[0].length;
//         return helper(0,0,0,0,grid);
//     }
// }
class Solution {
    int n, m;
    Boolean[][][] dp;

    public boolean helper(int i, int j, int l, int r, char[][] grid) {

        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;

        if (grid[i][j] == '(') {
            l++;
        }

        if (grid[i][j] == ')') {
            r++;
        }

        if (r > l) {
            return false;
        }

        // r can be calculated from i, j and l
        // so we only need i, j and l for memoization
        if (dp[i][j][l] != null) {
            return dp[i][j][l];
        }

        if (i == n - 1 && j == m - 1) {
            if (l == r) {
                return dp[i][j][l] = true;
            } else {
                return dp[i][j][l] = false;
            }
        }

        boolean down = helper(i + 1, j, l, r, grid);

        boolean right = helper(i, j + 1, l, r, grid);

        return dp[i][j][l] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new Boolean[n][m][n + m + 1];

        return helper(0, 0, 0, 0, grid);
    }
}