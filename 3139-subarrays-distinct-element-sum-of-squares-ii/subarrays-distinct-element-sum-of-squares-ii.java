class Solution {
    static class Node {
        int sum = 0;
        int squareSum = 0;
        int lazyValue = 0;
    }

    static final int MOD = 1000000007;
    Node[] segmentTree;

    void apply(int idx, int start, int end, int val) {
        int len = end - start + 1;

        segmentTree[idx].squareSum = (int) ((segmentTree[idx].squareSum
                + 2L * val * segmentTree[idx].sum
                + 1L * val * val % MOD * len) % MOD);

        segmentTree[idx].sum = (int) ((1L * len * val + segmentTree[idx].sum) % MOD);

        segmentTree[idx].lazyValue = (int) ((1L * segmentTree[idx].lazyValue + val) % MOD);
    }

    void propagate(int idx, int start, int end) {
        if (segmentTree[idx].lazyValue == 0) return;

        int val = segmentTree[idx].lazyValue;
        int mid = start + (end - start) / 2;

        apply(2 * idx, start, mid, val);
        apply(2 * idx + 1, mid + 1, end, val);

        segmentTree[idx].lazyValue = 0;
    }

    void merge(int idx, int left, int right) {
        segmentTree[idx].sum = (int) ((1L * segmentTree[left].sum
                + segmentTree[right].sum) % MOD);

        segmentTree[idx].squareSum = (int) ((1L * segmentTree[left].squareSum
                + segmentTree[right].squareSum) % MOD);
    }

    void update(int idx, int start, int end, int queryLeft, int queryRight) {
        if (queryRight < start || end < queryLeft) return;

        if (queryLeft <= start && end <= queryRight) {
            apply(idx, start, end, 1);
            return;
        }

        propagate(idx, start, end);

        int mid = start + (end - start) / 2;

        update(2 * idx, start, mid, queryLeft, queryRight);
        update(2 * idx + 1, mid + 1, end, queryLeft, queryRight);

        merge(idx, 2 * idx, 2 * idx + 1);
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int result = 0;

        segmentTree = new Node[4 * n + 1];
        for (int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = new Node();
        }

        int[] lastSeen = new int[100001];
        java.util.Arrays.fill(lastSeen, -1);

        for (int i = 0; i < n; i++) {
            int start = (lastSeen[nums[i]] == -1) ? 0 : lastSeen[nums[i]] + 1;
            lastSeen[nums[i]] = i;

            update(1, 0, n - 1, start, i);

            result = (int) ((1L * segmentTree[1].squareSum + result) % MOD);
        }

        return result;
    }
}