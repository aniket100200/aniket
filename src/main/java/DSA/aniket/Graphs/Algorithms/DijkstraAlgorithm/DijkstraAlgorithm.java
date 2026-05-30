package DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm;

import DSA.aniket.Graphs.Graph;

import java.util.ArrayList;

public interface DijkstraAlgorithm extends Graph {
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src);
}
