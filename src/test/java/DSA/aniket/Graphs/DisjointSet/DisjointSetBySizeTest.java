package DSA.aniket.Graphs.DisjointSet;

import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UnionBySizeDisjointSetUnionTest {

    @Test
    @DisplayName("Union Two Nodes")
    @Timeout(1)
    void testUnionTwoNodes() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(5);

        ds.union(1, 2);

        assertEquals(
                ds.findParent(1),
                ds.findParent(2)
        );
    }

    @Test
    @DisplayName("Multiple Unions Create Single Component")
    @Timeout(1)
    void testMultipleUnions() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(7);

        ds.union(1, 2);
        ds.union(2, 3);

        assertEquals(
                ds.findParent(1),
                ds.findParent(3)
        );
    }

    @Test
    @DisplayName("Separate Components Remain Separate")
    @Timeout(1)
    void testSeparateComponents() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(7);

        ds.union(1, 2);
        ds.union(4, 5);

        assertNotEquals(
                ds.findParent(1),
                ds.findParent(4)
        );
    }

    @Test
    @DisplayName("Merge Two Existing Components")
    @Timeout(1)
    void testMergeComponents() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(7);

        ds.union(1, 2);
        ds.union(3, 4);

        ds.union(2, 3);

        assertEquals(
                ds.findParent(1),
                ds.findParent(4)
        );
    }

    @Test
    @DisplayName("Find Parent Of Isolated Node")
    @Timeout(1)
    void testIsolatedNode() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(5);

        assertEquals(
                3,
                ds.findParent(3)
        );
    }

    @Test
    @DisplayName("Union Same Node")
    @Timeout(1)
    void testUnionSameNode() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(5);

        ds.union(2, 2);

        assertEquals(
                2,
                ds.findParent(2)
        );
    }

    @Test
    @DisplayName("Union Already Connected Nodes")
    @Timeout(1)
    void testAlreadyConnectedNodes() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(5);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(1, 3);

        assertEquals(
                ds.findParent(1),
                ds.findParent(3)
        );
    }

    @Test
    @DisplayName("Verify Size Update After Union")
    @Timeout(1)
    void testSizeUpdate() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(5);

        ds.union(1, 2);
        ds.union(2, 3);

        int parent = ds.findParent(1);

        assertEquals(3, ds.getSize()[parent]);
    }

    @Test
    @DisplayName("Large Connected Component")
    @Timeout(1)
    void testLargeConnectedComponent() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(100);

        for (int i = 1; i < 100; i++) {
            ds.union(i, i + 1);
        }

        assertEquals(
                ds.findParent(1),
                ds.findParent(100)
        );
    }

    @Test
    @DisplayName("Multiple Independent Components")
    @Timeout(1)
    void testMultipleIndependentComponents() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionBySize(10);

        ds.union(1, 2);
        ds.union(2, 3);

        ds.union(5, 6);
        ds.union(6, 7);

        assertNotEquals(
                ds.findParent(1),
                ds.findParent(5)
        );
    }
}