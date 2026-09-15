class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;
        
        for (int i = 0; i + 1 < n; ++i)
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = true;
        
        for (int len = 3; len <= n; ++len)
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            tmp[i] = tmp[i - 1];
            for (int j = 0; j <= i - k; ++j)
                if (dp[j][i - 1])
                    tmp[i] = Math.max(tmp[i], tmp[j] + 1);
        }
        return tmp[n];
    }
}