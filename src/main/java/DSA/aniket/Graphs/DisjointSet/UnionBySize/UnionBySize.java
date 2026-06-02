package DSA.aniket.Graphs.DisjointSet.UnionBySize;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;

public class UnionBySize implements DisjointSet {

    /**
     * @param node
     * @return
     */
    private int[] size;
    private int[] parent;

    public UnionBySize(int size) {
        this.size = new int[size + 1];
        this.parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    @Override
    public int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    /**
     * @param u
     * @param v
     */
    @Override
    public void union(int u, int v) {
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        if (ultimateParentOfU == ultimateParentOfV) return;
        if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
            size[ultimateParentOfV] += size[ultimateParentOfU];
            parent[ultimateParentOfU] = ultimateParentOfV;
        } else {
            size[ultimateParentOfU] += size[ultimateParentOfV];
            parent[ultimateParentOfV] = ultimateParentOfU;
        }
    }

    /**
     * @return
     */
    @Override
    public int[] getParentArray() {
        return parent;
    }

    /**
     * @return
     */
    @Override
    public int[] getSize() {
        return size;
    }
}