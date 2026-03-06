package leetcode;

import java.util.*;

/**
 * DSAPatterns
 *
 * Staff-level DSA pattern reference.
 *
 * Each section includes:
 *  - What it solves
 *  - When to use
 *  - Complexity
 *  - Subtle interview signals
 */
public class DSAPatterns {

    // ============================================================
    // 1. TWO POINTERS
    // ============================================================
    /**
     * Pattern: Two Pointers (Opposite Direction)
     *
     * Description:
     * Move two pointers towards each other to reduce search space.
     *
     * When to use:
     * - Sorted array
     * - Pair sum
     * - Palindrome checking
     * - Removing duplicates
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int twoPointers(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == 0) return sum;
            if (sum < 0) left++;
            else right--;
        }
        return -1;
    }

    // ============================================================
    // 2. SLIDING WINDOW
    // ============================================================
    /**
     * Pattern: Variable Sliding Window
     *
     * Description:
     * Maintain a window [left, right] that expands and shrinks.
     *
     * When to use:
     * - Longest substring problems
     * - At most K distinct elements
     * - Subarray with constraint
     *
     * Time: O(n)
     * Space: O(k)
     */
    public int slidingWindow(String s) {
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char l = s.charAt(left++);
                map.put(l, map.get(l) - 1);
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // ============================================================
    // 3. BINARY SEARCH
    // ============================================================
    /**
     * Pattern: Classic Binary Search
     *
     * When to use:
     * - Sorted array
     * - Monotonic predicate
     *
     * Time: O(log n)
     */
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // ============================================================
    // 4. BINARY SEARCH ON ANSWER (FIRST TRUE)
    // ============================================================
    /**
     * Pattern: Binary Search on Answer
     *
     * Description:
     * Search minimum x such that isFeasible(x) == true.
     *
     * When to use:
     * - Minimum capacity
     * - Minimum days
     * - Maximum minimum
     *
     * Key property:
     * Predicate must be monotonic.
     *
     * Time: O(log range * costOfCheck)
     */
    public int firstTrue(int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private boolean isFeasible(int x) {
        return true;
    }

    // ============================================================
    // 5. PREFIX SUM
    // ============================================================
    /**
     * Pattern: Prefix Sum
     *
     * When to use:
     * - Range sum queries
     * - Subarray sum equals K
     *
     * Precompute in O(n)
     * Query in O(1)
     */
    public int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            prefix[i + 1] = prefix[i] + arr[i];
        return prefix;
    }

    // ============================================================
    // 6. MONOTONIC STACK / MONOTONIC QUEUE
    // ============================================================
    /**
     * Pattern: Monotonic Stack
     *
     * Maintains increasing/decreasing order.
     *
     * When to use:
     * - Next Greater Element
     * - Histogram
     * - Stock span
     *
     * Time: O(n)
     */
    public int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stack.pop();

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // ============================================================
    // 7. HEAP / PRIORITY QUEUE
    // ============================================================
    /**
     * Pattern: Min Heap (Top K)
     *
     * When to use:
     * - K largest
     * - Merge K lists
     * - Scheduling
     *
     * Time: O(n log k)
     */
    public int[] topK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = pq.poll();

        return result;
    }

    // ============================================================
    // 8. BACKTRACKING
    // ============================================================
    /**
     * Pattern: Backtracking
     *
     * Core Idea:
     *  Choose → Explore → Undo
     *
     * When to use:
     * - Subsets
     * - Permutations
     * - Combinations
     * - N-Queens
     *
     * Time: O(2^n) typical
     */
    public List<List<Integer>> solveSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> path,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    // ============================================================
    // 9. GREEDY
    // ============================================================
    /**
     * Pattern: Greedy Interval Scheduling
     *
     * Strategy:
     * Sort by end time.
     *
     * When to use:
     * - Activity selection
     * - Non-overlapping intervals
     *
     * Time: O(n log n)
     */
    public int maxNonOverlapping(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }

        return count;
    }

    // ============================================================
    // 10. UNION FIND (DSU)
    // ============================================================
    /**
     * Pattern: Disjoint Set Union
     *
     * With:
     *  - Path compression
     *  - Union by rank
     *
     * When to use:
     * - Cycle detection
     * - Kruskal
     * - Connected components
     *
     * Amortized: O(alpha(n))
     */
    public class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }


// ============================================================
// 8. GRAPH – TOPOLOGICAL SORT (DAG)
// ============================================================
    /**
     * Pattern: Kahn’s Algorithm (BFS + In-degree)
     *
     * When to use:
     * - Course scheduling / prerequisites
     * - Task ordering with dependencies
     * - Build systems
     * - Detect cycle in directed graph
     *
     * Works only for Directed Acyclic Graph (DAG)
     *
     * Time: O(V + E)
     * Space: O(V + E)
     * Questions -
     * Core / Must-Do Problems
     * 1 Course Schedule
     * 2 Course Schedule II
     * 3 Alien Dictionary
     * Topo + DP Pattern (Very Important)
     * 4 Parallel Courses
     * 5 Parallel Courses III
     * 6 Longest Increasing Path in a Matrix
     * 7 Minimum Height Trees
     * 8 Sequence Reconstruction
     * 9 Find Eventual Safe States
     * Hard / Advanced
     * 10 Build a Matrix With Conditions
     * 11 Sort Items by Groups Respecting Dependencies

     */
    public List<Integer> topologicalSort(int n, int[][] edges) {

        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            indegree[to]++;
        }

        // Step 2: Add nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        // Step 3: BFS
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // If cycle exists, topological sort not possible
        if (result.size() != n)
            return new ArrayList<>();  // cycle detected

        return result;
    }


    /**
     * Pattern: Trie (Prefix Tree)
     *
     * Description:
     * Tree-like structure for efficient string prefix operations.
     * Each node represents a character.
     *
     * Core Strength:
     * - O(L) insert/search (L = word length)
     * - Much faster than HashSet for prefix queries
     *
     * When to use:
     * - Prefix search (autocomplete)
     * - Word dictionary
     * - Replace words
     * - Word break optimization
     * - XOR problems (bitwise trie)
     *
     * Time Complexity:
     *  Insert: O(L)
     *  Search: O(L)
     *
     * Space:
     *  O(total characters inserted)
     *
     * Staff-level signals:
     *  - Consider memory optimization (Map vs array[26])
     *  - Use compressed Trie (Radix tree) for production systems
     *  - Consider iterative instead of recursive for deep trees
     */
    class Trie {

        static class Node {
            Node[] children = new Node[26]; // for lowercase letters
            boolean isEnd;
        }

        private final Node root = new Node();

        /**
         * Insert a word into the trie.
         */
        public void insert(String word) {
            Node node = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.children[idx] == null)
                    node.children[idx] = new Node();

                node = node.children[idx];
            }

            node.isEnd = true;
        }

        /**
         * Exact word search.
         */
        public boolean search(String word) {
            Node node = traverse(word);
            return node != null && node.isEnd;
        }

        /**
         * Prefix search.
         */
        public boolean startsWith(String prefix) {
            return traverse(prefix) != null;
        }

        /**
         * Internal traversal helper.
         */
        private Node traverse(String word) {
            Node node = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    return null;
                node = node.children[idx];
            }

            return node;
        }
    }

// ============================================================
// 9. SEGMENT TREE
// ============================================================
    /**
     * Pattern: Range Query + Point Update
     *
     * When to use:
     * - Range Sum Query
     * - Range Min / Max Query
     * - Frequent updates + queries
     * - Interval aggregation problems
     *
     * Time:
     * - Build: O(n)
     * - Query: O(log n)
     * - Update: O(log n)
     *
     * Space: O(4n)
     */
    class SegmentTree {

        int[] tree;
        int n;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[4 * n];   // enough space
            build(nums, 0, 0, n - 1);
        }

        // Build Tree
        private void build(int[] nums, int index, int left, int right) {
            if (left == right) {
                tree[index] = nums[left];
                return;
            }

            int mid = left + (right - left) / 2;

            build(nums, 2 * index + 1, left, mid);
            build(nums, 2 * index + 2, mid + 1, right);

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2]; // Range Sum
        }

        // Range Query [l, r]
        public int query(int l, int r) {
            return queryHelper(0, 0, n - 1, l, r);
        }

        private int queryHelper(int index, int left, int right, int l, int r) {

            // No overlap
            if (r < left || l > right)
                return 0;

            // Complete overlap
            if (l <= left && right <= r)
                return tree[index];

            // Partial overlap
            int mid = left + (right - left) / 2;

            return queryHelper(2 * index + 1, left, mid, l, r)
                   + queryHelper(2 * index + 2, mid + 1, right, l, r);
        }

        // Point Update: set nums[pos] = value
        public void update(int pos, int value) {
            updateHelper(0, 0, n - 1, pos, value);
        }

        private void updateHelper(int index, int left, int right, int pos, int value) {

            if (left == right) {
                tree[index] = value;
                return;
            }

            int mid = left + (right - left) / 2;

            if (pos <= mid)
                updateHelper(2 * index + 1, left, mid, pos, value);
            else
                updateHelper(2 * index + 2, mid + 1, right, pos, value);

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }


    // ============================================================
    // 11. FENWICK TREE (BIT)
    // ============================================================
    /**
     * Pattern: Fenwick Tree
     *
     * When to use:
     * - Prefix sums with updates
     * - Inversion count
     *
     * Update: O(log n)
     * Query: O(log n)
     */
    static class FenwickTree {
        private final long[] tree;
        private final int n;

        public FenwickTree(int size) {
            this.n = size;
            this.tree = new long[n + 1];
        }

        public void update(int i, long delta) {
            while (i <= n) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        public long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    // ============================================================
    // 12. MEET IN THE MIDDLE
    // ============================================================
    /**
     * Pattern: Meet in the Middle
     *
     * Split into two halves.
     *
     * When to use:
     * - n <= 40
     * - Subset sum
     *
     * Time: O(2^(n/2))
     */
    public class MeetInMiddle {
        public boolean subsetSum(int[] nums, int target) {
            int n = nums.length;
            int mid = n / 2;

            List<Integer> left = generate(nums, 0, mid);
            List<Integer> right = generate(nums, mid, n);
            Collections.sort(right);

            for (int sum : left) {
                if (Collections.binarySearch(right, target - sum) >= 0)
                    return true;
            }
            return false;
        }

        private List<Integer> generate(int[] nums, int start, int end) {
            List<Integer> sums = new ArrayList<>();
            int len = end - start;

            for (int mask = 0; mask < (1 << len); mask++) {
                int sum = 0;
                for (int i = 0; i < len; i++)
                    if ((mask & (1 << i)) != 0)
                        sum += nums[start + i];
                sums.add(sum);
            }
            return sums;
        }
    }

    /**
     * Pattern: Bitmask DP (State Compression DP)
     *
     * Description:
     * Represent visited elements using a bitmask.
     *
     * mask: which elements are already chosen
     * pos : current position
     *
     * dp[mask][pos] = minimum cost to finish remaining elements
     *
     * When to use:
     * - n <= 15–20
     * - Visiting all nodes exactly once
     * - Assignment problems
     *
     * Time Complexity:
     *  O(n * 2^n)
     *
     * Space:
     *  O(n * 2^n)
     *
     * Staff-level signals:
     *  - Precompute distances
     *  - Use iterative bottom-up to avoid stack overflow
     *  - Memo must be initialized to -1
     */
    class BitmaskDP {

        private int[][] dist;
        private int[][] dp;
        private int n;

        public int tsp(int[][] distMatrix) {
            this.dist = distMatrix;
            this.n = distMatrix.length;

            int size = 1 << n;
            dp = new int[size][n];

            for (int[] row : dp)
                Arrays.fill(row, -1);

            // start from node 0, mask includes node 0
            return solve(1, 0);
        }

        /**
         * mask = visited set
         * pos  = current position
         */
        private int solve(int mask, int pos) {

            // if all visited, return to start
            if (mask == (1 << n) - 1)
                return dist[pos][0];

            if (dp[mask][pos] != -1)
                return dp[mask][pos];

            int ans = Integer.MAX_VALUE;

            for (int next = 0; next < n; next++) {
                if ((mask & (1 << next)) == 0) {

                    int newMask = mask | (1 << next);

                    ans = Math.min(ans,
                            dist[pos][next] +
                            solve(newMask, next));
                }
            }

            return dp[mask][pos] = ans;
        }
    }
}