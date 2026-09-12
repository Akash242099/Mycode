
class Solution {
    static class ScoreAndIndi {
        long score;
        List<Integer> indices;

        ScoreAndIndi(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    static Comparator<ScoreAndIndi> comparator = new Comparator<ScoreAndIndi>() {
        public int compare(ScoreAndIndi a, ScoreAndIndi b) {
            if (a.score != b.score)
                return Long.compare(a.score, b.score);

            int len = Math.min(a.indices.size(), b.indices.size());

            for (int i = 0; i < len; i++) {
                int cmp = Integer.compare(a.indices.get(i), b.indices.get(i));
                if (cmp != 0)
                    return cmp;
            }

            return Integer.compare(a.indices.size(), b.indices.size());
        }
    };

    int n;
    int[][] intervals;
    int[] origIdx;
    int[] nextIndex;
    ScoreAndIndi[][] dp;

    public int[] maximumWeight(List<List<Integer>> a) {
        Map<String, Integer> originalIndex = new LinkedHashMap<>();

        for (int i = 0; i < a.size(); i++) {
            List<Integer> iv = a.get(i);
            String key = iv.get(0) + "," + iv.get(1) + "," + iv.get(2);

            if (!originalIndex.containsKey(key)) {
                originalIndex.put(key, i);
            }
        }

        List<int[]> withIndex = new ArrayList<>();

        for (Map.Entry<String, Integer> e : originalIndex.entrySet()) {
            String[] parts = e.getKey().split(",");

            withIndex.add(new int[]{
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                e.getValue()
            });
        }

        withIndex.sort((x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);

            if (x[1] != y[1])
                return Integer.compare(x[1], y[1]);

            return Integer.compare(x[2], y[2]);
        });

        n = withIndex.size();

        intervals = new int[n][3];
        origIdx = new int[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = withIndex.get(i)[0];
            intervals[i][1] = withIndex.get(i)[1];
            intervals[i][2] = withIndex.get(i)[2];
            origIdx[i] = withIndex.get(i)[3];
        }

        nextIndex = new int[n];

        for (int i = 0; i < n; i++) {
            int right = intervals[i][1];
            int lo = 0, hi = n;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (intervals[mid][0] > right)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            nextIndex[i] = lo;
        }

        dp = new ScoreAndIndi[n + 1][5];

        List<Integer> resultList = solve(0, 4).indices;

        int[] result = new int[resultList.size()];

        for (int i = 0; i < result.length; i++)
            result[i] = resultList.get(i);

        return result;
    }

    private ScoreAndIndi solve(int i, int k) {
        if (i == n || k == 0)
            return new ScoreAndIndi(0, new ArrayList<>());

        if (dp[i][k] != null)
            return dp[i][k];

        ScoreAndIndi skip = solve(i + 1, k);

        int weight = intervals[i][2];

        ScoreAndIndi takeNext = solve(nextIndex[i], k - 1);

        long takeScore = takeNext.score - weight;

        List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
        takeIndices.add(origIdx[i]);
        Collections.sort(takeIndices);

        ScoreAndIndi take = new ScoreAndIndi(takeScore, takeIndices);

        ScoreAndIndi best = comparator.compare(skip, take) <= 0 ? skip : take;

        dp[i][k] = best;

        return best;
    }
}

