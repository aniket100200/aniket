package DSA.aniket.Graphs.DisjointSet.KrushkalsAlgorithm.Solution;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.KrushkalsAlgorithm.KrushkalsAlgorithm;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

import java.util.Arrays;

public class Solution implements KrushkalsAlgorithm {

    /**
     * @param V
     * @param edges
     * @return
     */
    @Override
    public int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges, (x, y) -> {
            if (x[2] == y[2]) {
                if (x[0] == y[0]) return x[1] - y[1];
                return x[0] - y[0];
            }

            return x[2] - y[2];
        });
        int totalSum = 0;
        DisjointSet set = new UnionBySize(V);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int wt = edge[2];
            if (set.findParent(u) == set.findParent(v)) continue;
            totalSum += wt;
            set.union(u, v);
        }
        return totalSum;
    }
}