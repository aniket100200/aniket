package DSA.aniket.Graphs.Directed.TopologicalSort;

import java.util.ArrayList;

/**
 * It is the Leaner ordering of Vertices such that
 * if there edge between `U` and `V` then 'U' appear before 'V'
 * that's called Topological Sort
 */
public interface TopologicalSort {
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj);
}