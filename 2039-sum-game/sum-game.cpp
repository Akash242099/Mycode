class Solution {
public:
    bool sumGame(string num) {
        int n = num.size();
        int m = n / 2;
        int l = 0, r = 0, qL = 0, qR = 0;

        for (int i = 0; i < n; i++) {
            if (i < m) {
                if (num[i] == '?') qL++;
                else l += num[i] - '0';
            } else {
                if (num[i] == '?') qR++;
                else r += num[i] - '0';
            }
        }
        return (l - r) != (qR - qL) * 4.5;
    }
};