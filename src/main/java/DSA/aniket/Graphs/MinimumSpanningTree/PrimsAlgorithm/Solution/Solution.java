package DSA.aniket.Graphs.MinimumSpanningTree.PrimsAlgorithm.Solution;

import DSA.aniket.Graphs.MinimumSpanningTree.PrimsAlgorithm.PrimsAlgorithm;

import java.util.List;
import java.util.PriorityQueue;

public class Solution implements PrimsAlgorithm {

    /**
     * @param V
     * @param edges
     * @return
     */
    @Override
    public int spanningTree(int V, int[][] edges) {
        /**
         * create a Graph
         */
        List<List<List<Integer>>> adj = getWeightedGraph(V, edges, true);
        int[] visited = new int[V];
        int total = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) {
                if (x[1] == y[1]) return x[2] - y[2];
                return x[1] - y[1];
            }

            return x[0] - y[0];
        });
        pq.add(new int[]{0, 0, -1});
        /**
         *  {x,y,z}
         *  x-> dist or weight
         *  y-> node
         *  z-> parent
         */

        while (pq.size() > 0) {
            int[] rTuple = pq.poll();
            int dist = rTuple[0];
            int node = rTuple[1];
            int parent = rTuple[2];
            if (visited[node] == 1) continue;
            if (parent != -1) {
                total += dist;
            }
            visited[node] = 1;
            for (List<Integer> neighbour : adj.get(node)) {
                int neighbourNode = neighbour.get(0);
                int wt = neighbour.get(1);
                pq.add(new int[]{wt, neighbourNode, node});

            }

        }
        return total;
    }
}