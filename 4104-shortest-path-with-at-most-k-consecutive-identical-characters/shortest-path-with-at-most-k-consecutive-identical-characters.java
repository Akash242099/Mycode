class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, x -> new ArrayList<>());
        for (int[] x : edges){
            graph[x[0]].add(new int[]{x[1], x[2]});
        }

        int[] tillConsec = new int[n];  
        Arrays.fill(tillConsec, k + 1);
         PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));   
        q.add(new long[]{0, 1, 0});
        while (!q.isEmpty()) {
            long[] s = q.poll();
            long d = s[0];
            int run = (int) s[1], x = (int) s[2];
            if (run >= tillConsec[x])  
                continue;
            if (x == n - 1)
                return (int) d;
            tillConsec[x] = run;
            for (int[] e : graph[x]) {
                int y = e[0];
                int r = labels.charAt(y) == labels.charAt(x) ? run + 1 : 1;
                if (r < tillConsec[y]){
                    q.add(new long[]{d + e[1], r, y});
                }
            }
        }
        return -1;
    }
}