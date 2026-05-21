package DSA.aniket.Graphs.Directed.EventualSafeStates;

import java.util.List;

public interface EventualSafeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj);
}