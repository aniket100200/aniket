package DSA.aniket.Graphs.DijkstraAlgorithm.UsingPriorityQueue;

import DSA.aniket.Graphs.DijkstraAlgorithm.DijkstraAlgorithm;
import DSA.aniket.Graphs.WordLadder.WordLadder1.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UsingPriorityQueue implements DijkstraAlgorithm {

    @Override
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        PriorityQueue<Pair<Integer, Integer>> que = new PriorityQueue<>((x, y) -> {
            if (x.getT() == y.getT()) return x.getV() - y.getV();
            return x.getT() - x.getT();
        });


        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        que.add(new Pair<>(0, src));
        dist[src] = 0;


        while (que.size() > 0) {
            int currDist = que.peek().getT();
            int node = que.peek().getV();
            que.poll();
            for (ArrayList<Integer> neighbour : adj.get(node)) {
                int nebor = neighbour.get(0);
                int wt = neighbour.get(1);
                int newDist = currDist + wt;
                if (newDist < dist[nebor]) {
                    dist[nebor] = newDist;
                    que.add(new Pair<>(newDist, nebor));

                }

            }
        }


        return dist;
    }
}