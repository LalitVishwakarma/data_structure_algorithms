package practice;

import java.util.ArrayList;
import java.util.List;

class GraphNode {
    public int val;
    List<GraphNode> neighbours;

    GraphNode() {
        val = 0;
        neighbours = new ArrayList<>();
    }

    GraphNode(int val) {
        this.val = val;
        neighbours = new ArrayList<>();
    }

    GraphNode(int val, List<GraphNode> neighbours) {
        this.val = val;
        this.neighbours = neighbours;
    }
}

public class CloneGraph {
    int[] visit = new int[101];
    public void dfs(GraphNode node, GraphNode copy) {

        copy.val = node.val;

        for(GraphNode neighbour : node.neighbours) {
            if(visit[neighbour.val] == 0) {
                List<GraphNode> n = copy.neighbours.stream().filter(node1 -> node1.val == neighbour.val).toList();
                visit[neighbour.val] = 1;
                GraphNode copy_neighbour = !n.isEmpty() ? n.getFirst() : new GraphNode();
                copy.neighbours.add(copy_neighbour);
                dfs(neighbour, copy_neighbour);
                visit[neighbour.val] = 0;
            }
        }

    }

    public GraphNode cloneGraph(GraphNode node) {
        GraphNode copy = new GraphNode();
        visit[node.val] = 1;
        dfs(node, copy);
        return copy;
    }

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node4);

        node2.neighbours.add(node1);
        node2.neighbours.add(node3);

        node3.neighbours.add(node2);
        node3.neighbours.add(node4);

        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        GraphNode clone = cloneGraph.cloneGraph(node1);
        System.out.println(clone);
    }
}
