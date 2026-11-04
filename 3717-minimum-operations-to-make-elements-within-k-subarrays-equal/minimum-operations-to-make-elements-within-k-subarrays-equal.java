class Solution {
    int n, x, k;

    long[] arr;
    long[][] dp;

    static final long INF = (long) 1e16;

    long solve(int count, int i) {
        if (count == k)
            return 0;

        int remaining = k - count;
        int needed = remaining * x;
        int last = i + needed - 1;

        if (last >= n) {
            return INF;
        }

        if (dp[count][i] != -1) {
            return dp[count][i];
        }

        long res = arr[i] + solve(count + 1, i + x);

        res = Math.min(res, solve(count, i + 1));

        return dp[count][i] = res;
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int freq = map.get(val);
        if (freq == 1) map.remove(val);
        else map.put(val, freq - 1);
    }

    public long minOperations(int[] nums, int x, int k) {
        this.n = nums.length;
        this.x = x;
        this.k = k;

        arr = new long[n + 1];
        dp = new long[k + 1][n + 1];

        for (long[] row : dp) Arrays.fill(row, -1);

        TreeMap<Integer, Integer> l = new TreeMap<>();
        TreeMap<Integer, Integer> r = new TreeMap<>();

        int ls = 0, rs = 0;
        long lsum = 0, rsum = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            if (ls <= rs) {
                add(l, nums[j]);
                ls++;
                lsum += nums[j];
            } else {
                add(r, nums[j]);
                rs++;
                rsum += nums[j];
            }

            if (ls > 0 && rs > 0) {
                int a = l.lastKey();
                int b = r.firstKey();

                if (a > b) {
                    remove(l, a);
                    remove(r, b);

                    add(l, b);
                    add(r, a);

                    lsum += b - a;
                    rsum += a - b;
                }
            }

            if (j - i + 1 == x) {
                long median = l.lastKey();

                arr[i] = (ls * median - lsum) + (rsum - rs * median);

                if (l.containsKey(nums[i])) {
                    remove(l, nums[i]);
                    ls--;
                    lsum -= nums[i];
                } else {
                    remove(r, nums[i]);
                    rs--;
                    rsum -= nums[i];
                }

                i++;
            }

            j++;
        }

        return solve(0, 0);
    }
}