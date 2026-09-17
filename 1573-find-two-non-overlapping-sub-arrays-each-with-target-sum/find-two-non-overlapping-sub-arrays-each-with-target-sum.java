class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];

        Arrays.fill(minLen, n + 1);

        int left = 0;
        int sum = 0;
        int ans = n + 1;
        int best = n + 1;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && minLen[left - 1] != n + 1) {
                    ans = Math.min(ans, len + minLen[left - 1]);
                }

                best = Math.min(best, len);
            }

            minLen[right] = best;
        }

        return ans == n + 1 ? -1 : ans;
    }
}