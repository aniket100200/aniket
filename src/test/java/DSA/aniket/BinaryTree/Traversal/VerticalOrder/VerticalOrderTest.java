package DSA.aniket.BinaryTree.Traversal.VerticalOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticalOrderTraversalTest {


    private final Traverse verticalTraversal = new VerticalOrder();

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), verticalTraversal.traverseLevel(null));
    }

    @Test
    @DisplayName("Should return a single level for a single node tree")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> expected = Collections.singletonList(Collections.singletonList(1));
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }

    @Test
    @DisplayName("Example 1: Standard asymmetric tree")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Expected: [[9], [3, 15], [20], [7]]
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(9),
                Arrays.asList(3, 15),
                Collections.singletonList(20),
                Collections.singletonList(7)
        );
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }

    @Test
    @DisplayName("Example 2: Perfect Binary Tree with overlapping nodes")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Expected: [[4], [2], [1, 5, 6], [3], [7]]
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(4),
                Collections.singletonList(2),
                Arrays.asList(1, 5, 6),
                Collections.singletonList(3),
                Collections.singletonList(7)
        );
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }

    @Test
    @DisplayName("Should sort nodes by value if they share the exact same row and column")
    void testOverlappingNodesWithSorting() {
        /*
                  1  (0,0)
                 / \
         (-1,1) 2   3 (1,1)
                 \   \
          (0,2)  6    5 (2,2)
                 /
                4 (1,3)

            Wait, let's build a specific tree where higher values appear first
            in standard traversal, forcing a value sort.

                  3
                 / \
                1   4
                 \   \
                  2   5
                   \
                    6

             We need nodes at the same exact (row, col).
             Root = 1.
             Left = 2, Right = 3.
             Left.Right = 6. Right.Left = 5.
             Both 6 and 5 are at row=2, col=0.
             If we traverse left side first, 6 goes in before 5.
             But output MUST be [5, 6] because 5 < 6.
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);

        // Column 0 has: Node 1 (row 0), Node 5 (row 2), Node 6 (row 2).
        // Since 5 and 6 are at the exact same row, they must be sorted by value.
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(1, 5, 6), // 5 comes before 6!
                Collections.singletonList(3)
        );
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }

    @Test
    @DisplayName("Should handle heavily skewed trees properly")
    void testSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Columns: -3, -2, -1, 0
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(4),
                Collections.singletonList(3),
                Collections.singletonList(2),
                Collections.singletonList(1)
        );
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }

    @Test
    @DisplayName("Should handle heavily skewed trees properly")
    void testSkewedRightTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Columns: -3, -2, -1, 0
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4)
        );
        assertEquals(expected, verticalTraversal.traverseLevel(root));
    }
}