class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m + 1];
        Arrays.fill(suf, n);

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                for (int k = j; k >= 0; k--) {
                    suf[k] = -1;
                }
                break;
            }

            suf[j] = i;
            i--;
        }

        List<Integer> res = new ArrayList<>();

        int j = 0;
        boolean changed = false;

        for (i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res.add(i);
                j++;
            } else if (!changed && suf[j + 1] > i) {
                res.add(i);
                changed = true;
                j++;
            }
        }

        if (j == m) {
            int[] ans = new int[res.size()];
            for (i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }

        return new int[0];
    }
}