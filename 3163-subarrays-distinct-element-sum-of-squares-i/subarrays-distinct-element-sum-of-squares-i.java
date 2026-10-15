class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), ans = 0;
        for (int l = 0; l < n; l++) {
            Set<Integer> seen = new HashSet<>();
            int cnt = 0;
            for (int r = l; r < n; r++) {
                int x = nums.get(r);
                if (seen.add(x)) {
                    cnt++;
                }
                ans += cnt * cnt;
            }
        }
        return ans;
    }
}