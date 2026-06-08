package DSA.aniket.Graphs.DisjointSet.MostStoneRemoval.Solution;

import DSA.aniket.Graphs.DisjointSet.MostStoneRemoval.MostStoneRemoval;

import java.util.HashMap;
import java.util.Map;

public class Solution implements MostStoneRemoval {

    /**
     * @param stones
     * @param n
     * @return
     */
    @Override
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (int key : stoneNodes.keySet()) {
            if (ds.findParent(key) == key) cnt++;
        }
        return n - cnt;
    }
}

class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        if (ultimateParentOfV == ultimateParentOfU) return;
        if (size[ultimateParentOfV] > size[ultimateParentOfU]) {
            parent[ultimateParentOfU] = ultimateParentOfV;
            size[ultimateParentOfV] += size[ultimateParentOfU];
        } else {
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        }
    }
}