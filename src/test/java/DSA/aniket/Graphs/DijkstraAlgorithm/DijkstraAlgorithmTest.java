package DSA.aniket.Graphs.DijkstraAlgorithm;

import DSA.aniket.Graphs.DijkstraAlgorithm.UsingPriorityQueue.UsingPriorityQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DijkstrasAlgorithmTest {

    private final DijkstraAlgorithm solution = new UsingPriorityQueue();

    private ArrayList<ArrayList<ArrayList<Integer>>> createGraph(int V) {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }

    private void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj,
                         int u,
                         int v,
                         int w) {

        ArrayList<Integer> edge = new ArrayList<>();

        edge.add(v);
        edge.add(w);

        adj.get(u).add(edge);
    }

    @Test
    @DisplayName("Should compute shortest distances correctly for sample graph")
    @Timeout(1)
    void testExample1() {

        int V = 3;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        addEdge(adj, 0, 1, 1);
        addEdge(adj, 0, 2, 6);

        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 0, 1);

        addEdge(adj, 2, 1, 3);
        addEdge(adj, 2, 0, 6);

        int[] result = solution.dijkstra(V, adj, 2);

        assertArrayEquals(
                new int[]{4, 3, 0},
                result
        );
    }

    @Test
    @DisplayName("Should handle directed weighted graph correctly")
    @Timeout(1)
    void testExample2() {

        int V = 5;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 4);

        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 7);

        addEdge(adj, 2, 4, 3);

        addEdge(adj, 3, 4, 1);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{0, 2, 3, 9, 6},
                result
        );
    }

    @Test
    @DisplayName("Should keep unreachable nodes as Integer.MAX_VALUE")
    @Timeout(1)
    void testUnreachableNodes() {

        int V = 4;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        addEdge(adj, 0, 1, 5);

        addEdge(adj, 2, 3, 2);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{0, 5, Integer.MAX_VALUE, Integer.MAX_VALUE},
                result
        );
    }

    @Test
    @DisplayName("Should handle graph with single node")
    @Timeout(1)
    void testSingleNodeGraph() {

        int V = 1;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{0},
                result
        );
    }

    @Test
    @DisplayName("Should handle graph with no edges")
    @Timeout(1)
    void testNoEdges() {

        int V = 5;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{
                        0,
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE
                },
                result
        );
    }

    @Test
    @DisplayName("Should choose shorter indirect path over direct path")
    @Timeout(1)
    void testIndirectShorterPath() {

        int V = 3;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        addEdge(adj, 0, 1, 10);

        addEdge(adj, 0, 2, 1);

        addEdge(adj, 2, 1, 2);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{0, 3, 1},
                result
        );
    }

    @Test
    @DisplayName("Should handle larger weighted graph correctly")
    @Timeout(1)
    void testLargerGraph() {

        int V = 6;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(V);

        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 1);

        addEdge(adj, 2, 1, 2);
        addEdge(adj, 1, 3, 1);

        addEdge(adj, 2, 3, 5);

        addEdge(adj, 3, 4, 3);

        addEdge(adj, 4, 5, 1);

        int[] result = solution.dijkstra(V, adj, 0);

        assertArrayEquals(
                new int[]{0, 3, 1, 4, 7, 8},
                result
        );
    }
}