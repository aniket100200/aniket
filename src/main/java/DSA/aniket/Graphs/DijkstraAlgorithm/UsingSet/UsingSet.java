package DSA.aniket.Graphs.DijkstraAlgorithm.UsingSet;

import DSA.aniket.Graphs.DijkstraAlgorithm.DijkstraAlgorithm;
import DSA.aniket.Graphs.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class UsingSet implements DijkstraAlgorithm {
    @Override
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        return new int[0];
    }

    public int[] dijstra(int V, int[][] edges, int src) {
        List<List<List<Integer>>> graph = getWeightedGraph(V, edges, true);
        TreeSet<Pair> set = new TreeSet<>((p1, p2) -> {
            if (p1.getA() == p2.getA()) return p1.getB() - p2.getB();
            return p1.getA() - p2.getA();
        });
        set.add(new Pair(0, src));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while (set.size() > 0) {
            Pair r1 = set.removeFirst();
            int pathWeight = r1.getA();
            int node = r1.getB();

            for (List<Integer> neighbour : graph.get(node)) {
                int edgeWt = neighbour.get(1);
                int nebor = neighbour.get(0);
                if (edgeWt + pathWeight < dist[nebor]) {
                    if (dist[nebor] != Integer.MAX_VALUE) {
                        set.remove(new Pair(dist[nebor], nebor));
                    }
                    dist[nebor] = edgeWt + pathWeight;
                    set.add(new Pair(edgeWt + pathWeight, nebor));
                }
            }
        }

        return dist;
    }

}