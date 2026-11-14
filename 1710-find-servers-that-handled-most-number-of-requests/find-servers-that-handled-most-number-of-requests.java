class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];

        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        TreeSet<Integer> availableServers = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        int n = arrival.length;

        for (int i = 0; i < n; i++) {
            int arrTime = arrival[i];

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= arrTime) {
                availableServers.add(busyServers.poll()[1]);
            }

            if (availableServers.isEmpty()) {
                continue;
            }

            Integer it = availableServers.ceiling(i % k);

            if (it == null) {
                it = availableServers.first();
            }

            int serverIndex = it;

            cnt[serverIndex]++;

            busyServers.offer(new int[]{arrTime + load[i], serverIndex});
            availableServers.remove(it);
        }

        int maxRequests = Arrays.stream(cnt).max().getAsInt();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (cnt[i] == maxRequests) {
                ans.add(i);
            }
        }

        return ans;
    }
}