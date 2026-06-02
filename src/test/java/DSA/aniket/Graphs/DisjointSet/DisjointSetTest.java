package DSA.aniket.Graphs.DisjointSet;

import DSA.aniket.Graphs.DisjointSet.UnionByRank.UnionByRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UnionByRankDisjointSetUnionTest {

    @Test
    @DisplayName("Union Two Nodes")
    @Timeout(1)
    void testUnionTwoNodes() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(5);

        ds.union(1, 2);

        assertEquals(
                ds.findParent(1),
                ds.findParent(2)
        );
    }

    @Test
    @DisplayName("Multiple Unions Create One Set")
    @Timeout(1)
    void testMultipleUnions() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(7);

        ds.union(1, 2);
        ds.union(2, 3);

        assertEquals(
                ds.findParent(1),
                ds.findParent(3)
        );
    }

    @Test
    @DisplayName("Separate Sets Remain Separate")
    @Timeout(1)
    void testSeparateSets() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(7);

        ds.union(1, 2);
        ds.union(4, 5);

        assertNotEquals(
                ds.findParent(1),
                ds.findParent(4)
        );
    }

    @Test
    @DisplayName("Merge Two Existing Sets")
    @Timeout(1)
    void testMergeTwoSets() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(7);

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
//    @Timeout(1)
    void testIsolatedNode() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(5);

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
                new UnionByRank(5);

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
                new UnionByRank(5);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(1, 3);

        assertEquals(
                ds.findParent(1),
                ds.findParent(3)
        );
    }

    @Test
    @DisplayName("Path Compression Works")
    @Timeout(1)
    void testPathCompression() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(10);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(3, 4);

        int parentBefore =
                ds.findParent(4);

        int parentAfter =
                ds.getParentList().get(4);

        assertEquals(
                parentBefore,
                parentAfter
        );
    }

    @Test
    @DisplayName("Large Connected Component")
    @Timeout(1)
    void testLargeConnectedComponent() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(100);

        for (int i = 1; i < 100; i++) {
            ds.union(i, i + 1);
        }

        assertEquals(
                ds.findParent(1),
                ds.findParent(100)
        );
    }

    @Test
    @DisplayName("Multiple Components")
    @Timeout(1)
    void testMultipleComponents() {

        DSA.aniket.Graphs.DisjointSet.DisjointSet ds =
                new UnionByRank(10);

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