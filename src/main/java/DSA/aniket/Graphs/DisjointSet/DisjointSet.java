package DSA.aniket.Graphs.DisjointSet;

import DSA.aniket.Graphs.Graph;

import java.util.List;

public interface DisjointSet extends Graph {


    int findParent(int node);

    void union(int u, int v);

    default List<Integer> getRankList() {
        return null;
    }

    default List<Integer> getParentList() {
        return null;
    }
}
