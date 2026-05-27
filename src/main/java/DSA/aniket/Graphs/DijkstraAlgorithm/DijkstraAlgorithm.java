package DSA.aniket.Graphs.DijkstraAlgorithm;

import java.util.ArrayList;

public interface DijkstraAlgorithm {
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src);
}
