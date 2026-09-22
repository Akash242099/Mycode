//taken reference
class Solution {

class Node {
    int product;
    int[] count;

    Node(int k) {
        count = new int[k];
    }
}

int n, k;
int[] nums;
Node[] tree;

public int[] resultArray(int[] nums, int k, int[][] queries) {
    this.nums = nums;
    this.n = nums.length;
    this.k = k;

    tree = new Node[4 * n];

    build(1, 0, n - 1);

    int[] res = new int[queries.length];

    for (int q = 0; q < queries.length; q++) {
        int index = queries[q][0];
        int value = queries[q][1];
        int start = queries[q][2];
        int x = queries[q][3];

        nums[index] = value;
        update(1, 0, n - 1, index, value);

        Node ans = query(1, 0, n - 1, start, n - 1);
        res[q] = ans.count[x];
    }

    return res;
}

private void build(int node, int left, int right) {
    if (left == right) {
        tree[node] = new Node(k);
        int remainder = nums[left] % k;
        tree[node].product = remainder;
        tree[node].count[remainder] = 1;
        return;
    }

    int mid = left + (right - left) / 2;

    build(node * 2, left, mid);
    build(node * 2 + 1, mid + 1, right);

    tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
}

private Node merge(Node a, Node b) {
    Node res = new Node(k);
    res.product = (a.product * b.product) % k;

    for (int r = 0; r < k; r++) {
        res.count[r] += a.count[r];
    }

    for (int r = 0; r < k; r++) {
        int newRemainder = (a.product * r) % k;
        res.count[newRemainder] += b.count[r];
    }

    return res;
}

private void update(int node, int left, int right, int index, int value) {
    if (left == right) {
        tree[node] = new Node(k);
        int remainder = value % k;
        tree[node].product = remainder;
        tree[node].count[remainder] = 1;

        return;
    }

    int mid = left + (right - left) / 2;

    if (index <= mid) {
        update(node * 2, left, mid, index, value);
    } else {
        update(node * 2 + 1, mid + 1, right, index, value);
    }

    tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
}

private Node query(int node, int left, int right, int queryLeft, int queryRight) {
    if (queryLeft <= left && right <= queryRight) {
        return tree[node];
    }

    int mid = left + (right - left) / 2;

    if (queryRight <= mid) {
        return query(node * 2, left, mid, queryLeft, queryRight);
    }

    if (queryLeft > mid) {
        return query(node * 2 + 1, mid + 1, right, queryLeft, queryRight);
    }

    Node a = query(node * 2, left, mid, queryLeft, queryRight);
    Node b = query(node * 2 + 1, mid + 1, right, queryLeft, queryRight);

    return merge(a, b);
}
}