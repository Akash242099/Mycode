
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int size = queries.length;
        int[][] arr = new int[size][2];

        for (int i = 0; i < size; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[size];
        int[] count = new int[n + 1];

        int start = 0, end = 0, cnt = 0;

        for (int[] curr : arr) {
            int time = curr[0];

            while (end < logs.length && logs[end][1] <= time) {
                int id = logs[end][0];

                if (count[id] == 0) cnt++;
                count[id]++;
                end++;
            }

            while (start < end && logs[start][1] < time - x) {
                int id = logs[start][0];

                count[id]--;
                if (count[id] == 0) cnt--;
                start++;
            }

            ans[curr[1]] = n - cnt;
        }

        return ans;
    }
}