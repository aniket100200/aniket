package DSA.aniket.Graphs.DisjointSet.MakeNetworkConnected.Solution;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.MakeNetworkConnected.MakeNetworkConnected;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

public class Solution implements MakeNetworkConnected {

    /**
     * @param n
     * @param connections
     * @return
     */
    @Override
    public int makeConnected(int n, int[][] connections) {
        DisjointSet set = new UnionBySize(n);
        /**
         * find the number of Connected Components
         */
        int extraEdges = 0;
        int totalConnectedComponents = 0;
        int[] parent = set.getParentArray();
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            if (parent[u] == parent[v]) {
                extraEdges++;
            } else set.union(u, v);
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) totalConnectedComponents++;
        }

        int edgesReuired = totalConnectedComponents - 1;
        return extraEdges >= edgesReuired ? edgesReuired : -1;
    }
}

