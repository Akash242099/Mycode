class Solution {

    public void dfs(int node, List<List<Integer>> graph, int[] indegree, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            indegree[neighbor]--;

            if (!visited[neighbor]) {
                dfs(neighbor, graph, indegree, visited);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];

        for (int[] edge : invocations) {
            int source = edge[0];
            int destination = edge[1];

            graph.get(source).add(destination);
            indegree[destination]++;
        }

        dfs(k, graph, indegree, visited);

        List<Integer> ans = new ArrayList<>();
        boolean invalid = false;

        for (int i = 0; i < n; i++) {
            if (visited[i] && indegree[i] > 0) {
                invalid = true;
                break;
            }

            if (!visited[i]) {
                ans.add(i);
            }
        }

        if (invalid) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(i);
            }

            return temp;
        }

        return ans;
    }
}