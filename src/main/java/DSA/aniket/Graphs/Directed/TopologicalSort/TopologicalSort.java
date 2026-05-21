package DSA.aniket.Graphs.Directed.TopologicalSort;

import java.util.ArrayList;

public interface TopologicalSort {
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj);
}