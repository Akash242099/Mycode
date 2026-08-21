//taken reference from codewith mike
class Solution {

    private long countSmaller(long mid, int[] coins) {
        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask <= (1 << n) - 1; mask++) {
            long lcm = 0;
            long bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }
            }

            if (bits % 2 == 0) {
                count -= mid / lcm;
            } else {
                count += mid / lcm;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long findKthSmallest(int[] coins, int k) {
        long answer = -1;

        int maxCoin = 0;
        for (int coin : coins) {
            maxCoin = Math.max(maxCoin, coin);
        }

        long left = 1;
        long right = (long) maxCoin * k;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countSmaller(mid, coins) >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}