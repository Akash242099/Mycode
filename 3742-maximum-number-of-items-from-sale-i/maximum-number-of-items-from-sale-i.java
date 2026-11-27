class Solution {
    int[] fac;
    int[][][] dp;

    int helper(int i, int[][] items, int budget, int isbought) {

        if (i == items.length) {
            return 0;
        }

        if (dp[i][budget][isbought] != -1) {
            return dp[i][budget][isbought];
        }

        int notTake = helper(i + 1, items, budget, 0);

        int take = Integer.MIN_VALUE;

        if (budget - items[i][1] >= 0) {
            if (isbought == 0)
                take = fac[items[i][0]] + helper(i, items, budget - items[i][1], 1);
            else
                take = 1 + helper(i, items, budget - items[i][1], 1);
        }

        return dp[i][budget][isbought] = Math.max(notTake, take);
    }

    public int maximumSaleItems(int[][] items, int budget) {

        fac = new int[1501];

        for (int[] x : items) {
            int y = x[0];

            for (int i = 1; i <= 1500; i++) {
                if (y % i == 0) fac[i]++;
            }
        }

        dp = new int[items.length][budget + 1][2];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return helper(0, items, budget, 0);
    }
}