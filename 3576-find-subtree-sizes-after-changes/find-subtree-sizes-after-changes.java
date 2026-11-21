class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> oldAdj = new ArrayList<>();
        List<List<Integer>> newAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            oldAdj.add(new ArrayList<>());
            newAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            oldAdj.get(parent[i]).add(i);
        }

        Map<Character, List<Integer>> node = new HashMap<>();

        dfs(0, oldAdj, newAdj, node, s, parent);

        int[] ans = new int[n];
        dfs1(0, newAdj, ans);

        return ans;
    }

    void dfs(int cur, List<List<Integer>> oldAdj,
             List<List<Integer>> newAdj,
             Map<Character, List<Integer>> node,
             String s, int[] parent) {

        char ch = s.charAt(cur);

        if (!node.containsKey(ch) || node.get(ch).isEmpty()) {
            if (cur > 0) {
                newAdj.get(parent[cur]).add(cur);
            }
        } else {
            List<Integer> temp = node.get(ch);
            newAdj.get(temp.get(temp.size() - 1)).add(cur);
        }

        node.computeIfAbsent(ch, k -> new ArrayList<>()).add(cur);

        for (int u : oldAdj.get(cur)) {
            dfs(u, oldAdj, newAdj, node, s, parent);
        }

        node.get(ch).remove(node.get(ch).size() - 1);
    }

    void dfs1(int cur, List<List<Integer>> newAdj, int[] ans) {
        ans[cur] = 1;

        for (int u : newAdj.get(cur)) {
            dfs1(u, newAdj, ans);
            ans[cur] += ans[u];
        }
    }
}