class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int p = 1, q = 1, ans = 1;

        for (int i = 1; i < n; i++) {
            int temp = nums[i] - nums[i - 1];

            switch (temp) {
                case 0:
                    q = p + 1;
                    break;
                case 1:
                    p++;
                    q++;
                    break;
                case 2:
                    p = q + 1;
                    q = 1;
                    break;
                default:
                    p = q = 1;
            }

            ans = Math.max(ans, Math.max(p, q));
        }

        return ans;
    }
}