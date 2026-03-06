package leetcode.top_interview_questions.hard;

import java.util.ArrayList;
import java.util.List;

public class KruskalMinimumSpanningTree {

    public static class Edge {
        int u;
        int v;
        int waight;

        public Edge(int u, int v, int waight) {
            this.u = u;
            this.v = v;
            this.waight = waight;
        }
    }

    public class Union {
        int n;
        int[] parent, rank;

        Union(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
    public int krushkal(int numberOfNodes, List<Edge> edges) {
        edges.sort((a, b) -> a.waight - b.waight);

        int totalWight = 0;
        int selectedEdges = 0;
        Union union = new Union(numberOfNodes);

        for(Edge edge : edges) {
            if(union.find(edge.u) != union.find(edge.v)) {
                selectedEdges++;
                totalWight += edge.waight;
                union.union(edge.u, edge.v);

                if (selectedEdges == numberOfNodes - 1)
                    break;
            }

        }
        return totalWight;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        KruskalMinimumSpanningTree kruskalMinimumSpanningTree = new KruskalMinimumSpanningTree();
        System.out.println(kruskalMinimumSpanningTree.krushkal(4, edges));

    }
}
