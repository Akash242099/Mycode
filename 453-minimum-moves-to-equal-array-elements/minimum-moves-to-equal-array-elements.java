class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int me = Arrays.stream(nums).min().getAsInt();

        for (int x : nums){
            ans += x - me;
        }

        return ans;
    }
}