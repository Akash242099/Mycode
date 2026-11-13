class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        int j = n - 1;
        long x = 0;

        for (int i = n - 1; i >= 0; i--) {
            long cnt = 1;

            while (!dq.isEmpty() && nums[i] > dq.peekFirst()[0]) {
                int[] it = dq.pollFirst();
                cnt += it[1];
                x += 1L * (nums[i] - it[0]) * it[1];
            }

            dq.offerFirst(new int[]{nums[i], (int) cnt});

            while (x > 1L * k) {
                x -= (dq.peekLast()[0] - nums[j]);

                if (dq.peekLast()[1] == 1)
                    dq.pollLast();
                else
                    dq.peekLast()[1]--;

                j--;
            }

            res += (j - i + 1);
        }

        return res;
    }
}