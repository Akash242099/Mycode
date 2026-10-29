//taken reference
class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int LOG = 16;
        int[][] up = new int[LOG][n];
        for (int[] row : up) Arrays.fill(row, -1);

        int[] depth = new int[n];
        int[] in = new int[n];
        int[] out = new int[n];
        int[] parent = new int[n];
        int[] mask = new int[n];
        int[] timer = {1};

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, -1, g, up, depth, in, out, parent, timer, LOG);

        int[] bit = new int[n + 2];

        class Fenwick {
            void upd(int i, int val) {
                for (; i <= n; i += i & -i) bit[i] ^= val;
            }

            int qry(int i) {
                int res = 0;
                for (; i > 0; i -= i & -i) res ^= bit[i];
                return res;
            }

            void rangeXor(int l, int r, int val) {
                if (l > r) return;
                upd(l, val);
                upd(r + 1, val);
            }
        }

        Fenwick fw = new Fenwick();

        for (int i = 0; i < n; i++) {
            fw.rangeXor(in[i], out[i] - 1, mask[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int u = 0, i = 7;

                while (q.charAt(i) != ' ') {
                    u = u * 10 + (q.charAt(i++) - '0');
                }

                char c = q.charAt(q.length() - 1);
                int nm = 1 << (c - 'a');

                int delta = mask[u] ^ nm;
                mask[u] = nm;

                fw.rangeXor(in[u], out[u] - 1, delta);
            } else {
                int u = 0, v = 0, i = 6;

                while (q.charAt(i) != ' ') {
                    u = u * 10 + (q.charAt(i++) - '0');
                }

                i++;

                while (i < q.length()) {
                    v = v * 10 + (q.charAt(i++) - '0');
                }

                int l = getLca(u, v, depth, up, parent, LOG);
                int m = fw.qry(in[u]) ^ fw.qry(in[v]) ^ mask[l];

                ans.add(Integer.bitCount(m) <= 1);
            }
        }

        return ans;
    }

    private void dfs(int u, int p, List<List<Integer>> g,
                     int[][] up, int[] depth, int[] in, int[] out,
                     int[] parent, int[] timer, int LOG) {

        in[u] = timer[0]++;
        parent[u] = p;
        up[0][u] = p;

        for (int k = 1; k < LOG; k++) {
            if (up[k - 1][u] != -1) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        for (int v : g.get(u)) {
            if (v != p) {
                depth[v] = depth[u] + 1;
                dfs(v, u, g, up, depth, in, out, parent, timer, LOG);
            }
        }

        out[u] = timer[0];
    }

    private int getLca(int u, int v, int[] depth, int[][] up,
                       int[] parent, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }
}