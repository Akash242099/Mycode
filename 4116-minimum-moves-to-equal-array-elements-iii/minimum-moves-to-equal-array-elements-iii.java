class Solution {
    public int minMoves(int[] nums) {
      int maxi = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans += maxi - nums[i];
        }

        return ans;
    }
}