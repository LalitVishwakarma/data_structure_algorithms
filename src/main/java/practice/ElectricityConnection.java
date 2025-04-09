package practice;

import java.util.*;

/**
 * Build electricity network
 * <p>
 * Imagine we are an electricity infrastructure company and we are building an electricity network in a new country. We want to connect all cities in the country to one electricity network. Additionally, we want to minimize the cost of building the network. The country has roads and many farms. Farm owners don't allow us to build on their ground, which means we can only build electric lines along roads and cities.
 * <p>
 * We can picture the country as a matrix where:
 * -  `1` - is a road
 * -  `0` - is farm or any place where we cannot build
 * - `-1` - is a city that we want to connect to the grid
 * <p>
 * Input: int[][] of geographic map of cities, farms, and roads
 * <p>
 * Output: unsorted list of cell coordinates of where to build the network
 * Example input of roads, farms, and cities:
 * 1  |  1  |  1  |  1  |  1  | -1
 * 1  |  0  |  0  |  0  |  0  |  1
 * 1  |  1  |  0  |  0  |  0  |  1
 * 0  | -1  |  0  | -1  |  1  | -1
 * 0  |  1  |  0  |  0  |  0  |  1
 * 0  |  1  |  1  |  1  |  1  |  1
 * <p>
 * <p>
 * Example output of roads/cities where electric lines will be built:
 * 1  |  1  |  1  |  1  |  1  | -1*
 * 1  |  0  |  0  |  0  |  0  |  1*
 * 1  |  1  |  0  |  0  |  0  |  1*
 * 0  | -1* |  0  | -1* |  1* | -1*
 * 0  |  1* |  0  |  0  |  0  |  1*
 * 0  |  1* |  1* |  1* |  1* |  1*
 */


public class ElectricityConnection {

    // Constants for directions: up, down, left, right
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int componentId = 0;
    private Map<Integer, List<int[]>> components = new HashMap<>();

    public int minCostToConnectCities(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] componentMap = new int[rows][cols];

        // Step 1: Identify all city components using DFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -1 && componentMap[i][j] == 0) {
                    componentId++;
                    components.put(componentId, new ArrayList<>());
                    dfs(grid, componentMap, i, j, componentId);
                }
            }
        }

        // Step 2: Calculate minimum connection costs between components
        int[][] minDistance = new int[componentId + 1][componentId + 1];
        for (int i = 1; i <= componentId; i++) {
            Arrays.fill(minDistance[i], Integer.MAX_VALUE);
            minDistance[i][i] = 0;
        }

        for (int i = 1; i <= componentId; i++) {
            calculateComponentDistances(grid, componentMap, minDistance, i, rows, cols);
        }

        // Step 3: Kruskal's MST algorithm to connect all components
        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= componentId; i++) {
            for (int j = i + 1; j <= componentId; j++) {
                if (minDistance[i][j] < Integer.MAX_VALUE) {
                    edges.add(new Edge(i, j, minDistance[i][j]));
                }
            }
        }

        Collections.sort(edges);
        UnionFind uf = new UnionFind(componentId + 1);
        int totalCost = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalCost += edge.weight;
                edgesUsed++;
                if (edgesUsed == componentId - 1) break;
            }
        }

        return (edgesUsed == componentId - 1) ? totalCost : -1;
    }

    private void dfs(int[][] grid, int[][] componentMap, int row, int col, int compId) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        componentMap[row][col] = compId;
        components.get(compId).add(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            for (int[] dir : DIRECTIONS) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == -1 && componentMap[newRow][newCol] == 0) {
                    componentMap[newRow][newCol] = compId;
                    components.get(compId).add(new int[]{newRow, newCol});
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }

    private void calculateComponentDistances(int[][] grid, int[][] componentMap, int[][] minDistance, int compId, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[rows][cols];
        for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);

        // Start BFS from all cities in the current component
        for (int[] city : components.get(compId)) {
            queue.offer(city);
            distances[city[0]][city[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int distance = distances[cell[0]][cell[1]];

            for (int[] dir : DIRECTIONS) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] != 0 && distances[newRow][newCol] > distance + 1) {
                    distances[newRow][newCol] = distance + 1;
                    queue.offer(new int[]{newRow, newCol});

                    // If reaching a different component, update minDistance
                    int newCompId = componentMap[newRow][newCol];
                    if (newCompId != 0 && newCompId != compId) {
                        minDistance[compId][newCompId] = Math.min(minDistance[compId][newCompId], distances[newRow][newCol]);
                        minDistance[newCompId][compId] = minDistance[compId][newCompId];
                    }
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static class UnionFind {
        private int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;
            if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }


    public static void main(String[] args) {
        int[][] input = {
                {1, 1, 1, 1, 1, -1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1},
                {0, -1, 0, -1, 1, -1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}

//                {1, 1, 1, -1, 1},
//                {1, 0, 1, 1, 1},
//                {-1, 1, 1, 1, -1},
//                {1, 1, 0, 1, 1},
//                {-1, 1, 1, -1, 1}
        };

        ElectricityConnection electricityConnection = new ElectricityConnection();
        System.out.println(electricityConnection.minCostToConnectCities(input));
    }


}
