package DSA.aniket.Graphs.DijkstraAlgorithm.CheapestFlightWithinKStops.Solution;

import DSA.aniket.Graphs.DijkstraAlgorithm.CheapestFlightWithinKStops.CheapestFlightWithinKStops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution implements CheapestFlightWithinKStops {

    /**
     * @param V
     * @param flights
     * @param src
     * @param dest
     * @param k
     * @return
     */
    @Override
    public int findCheapestPrice(int V, int[][] flights, int src, int dest, int k) {
        /*let's Create the Graph*/
        List<List<List<Integer>>> graph = createGraph(V, flights);
        /**
         * for this que int[] means using int array of size 3
         * tupple[0] -> number of stops
         * tupple[1] -> node
         * tupple[2] -> distance from the source node or cost
         */
        Queue<int[]> que = new LinkedList<>();

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        que.add(new int[]{0, src, 0});
        /**
         * as stops are increasing each time so we are sure que will store the data in sorted order
         * and at top it will store the smallest stop one
         */

        while (que.size() > 0) {
            int[] tupple = que.remove();
            int stops = tupple[0];
            int node = tupple[1];
            int currCost = tupple[2];
            if (stops > k) continue;
            for (List<Integer> neighbourData : graph.get(node)) {
                int adjNode = neighbourData.get(0);
                int edgeWt = neighbourData.get(1);
                if (currCost + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = currCost + edgeWt;
                    que.add(new int[]{stops + 1, adjNode, currCost + edgeWt});
                }

            }

        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    List<List<List<Integer>>> createGraph(int V, int[][] flights) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.get(u).add(List.of(v, wt));
        }

        return graph;
    }
}