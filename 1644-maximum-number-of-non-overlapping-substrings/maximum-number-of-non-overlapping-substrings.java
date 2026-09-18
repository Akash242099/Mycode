class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[][] range = new int[26][2];

        for (int i = 0; i < 26; i++) {
            range[i][0] = n;
            range[i][1] = -1;
        }

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            range[c][0] = Math.min(range[c][0], i);
            range[c][1] = i;
        }

        List<int[]> indexArray = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (range[c][1] == -1) continue;

            int l = range[c][0];
            int r = range[c][1];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int x = s.charAt(i) - 'a';

                if (range[x][0] < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, range[x][1]);
            }

            if (valid)
                indexArray.add(new int[]{r, l});
        }

        indexArray.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<String> res = new ArrayList<>();
        int prevEnd = -1;

        for (int[] iv : indexArray) {
            int r = iv[0], l = iv[1];

            if (l > prevEnd) {
                res.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return res;
    }
}