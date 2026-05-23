package DSA.aniket.Graphs.Directed.EventualSafeStates;

import DSA.aniket.Graphs.Graph;

import java.util.List;

public interface EventualSafeStates extends Graph {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj);
}