class Solution {

    private long gcd(long a, long b) {
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private String fillRemNum(int slots, long t) {
        StringBuilder ans = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (t % d == 0) {
                ans.append((char) ('0' + d));
                t /= d;
            }
        }

        while (ans.length() < slots) {
            ans.append('1');
        }

        return ans.reverse().toString();
    }

    public String smallestNumber(String num, long t) {
        int n = num.length();
        int[] primes = {2, 3, 5, 7};

        long val = t;
        for (int p : primes) {
            while (val % p == 0) {
                val /= p;
            }
        }

        if (val != 1) {
            return "-1";
        }

        long[] res = new long[n + 1];
        res[0] = t;

        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            if (digit == 0) {
                break;
            }
            res[i + 1] = res[i] / gcd(digit, res[i]);
        }

        if (res[n] == 1) {
            return num;
        }

        int st = n - 1;
        int zeroIdx = num.indexOf('0');
        if (zeroIdx != -1) {
            st = zeroIdx;
        }

        for (int i = st; i >= 0; i--) {
            long remVal = res[i];
            int digit = num.charAt(i) - '0';
            int freeSlots = n - i - 1;

            for (int d = digit + 1; d <= 9; d++) {
                long remFurtherVal = remVal / gcd(remVal, d);
                String remFurtherNum = fillRemNum(freeSlots, remFurtherVal);

                if (remFurtherNum.length() == freeSlots) {
                    return num.substring(0, i) + (char) ('0' + d) + remFurtherNum;
                }
            }
        }

        return fillRemNum(n + 1, t);
    }
}