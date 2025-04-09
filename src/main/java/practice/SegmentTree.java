package practice;

class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }

    private void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            buildTree(arr, leftChild, start, mid);
            buildTree(arr, rightChild, mid + 1, end);
            tree[node] = Math.max(tree[leftChild], tree[rightChild]);
        }
    }

    public int query(int l, int r) {
        return queryHelper(0, 0, n - 1, l, r);
    }

    private int queryHelper(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return Integer.MIN_VALUE; // Out of range
        if (l <= start && end <= r) return tree[node]; // Total overlap
        int mid = (start + end) / 2;
        int leftMax = queryHelper(2 * node + 1, start, mid, l, r);
        int rightMax = queryHelper(2 * node + 2, mid + 1, end, l, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12};
        SegmentTree segmentTree = new SegmentTree(a);
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                System.out.println("i " +  i + " j " +  j + " max " + segmentTree.query(i, j));
            }
        }
    }
}
