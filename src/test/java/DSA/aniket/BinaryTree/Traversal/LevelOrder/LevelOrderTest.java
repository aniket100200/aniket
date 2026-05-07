package DSA.aniket.BinaryTree.Traversal.LevelOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelOrderTraversalTest {
    // --- Test Cases ---

    private final Traverse solution = new LevelOrder();

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), solution.traverseLevel(null));
    }

    @Test
    @DisplayName("Should return a single level for a single node tree")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> expected = Collections.singletonList(Collections.singletonList(1));
        assertEquals(expected, solution.traverseLevel(root));
    }

    @Test
    @DisplayName("Example 1: Standard balanced-ish tree")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }

    @Test
    @DisplayName("Should correctly group levels for a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }

    @Test
    @DisplayName("Should correctly handle an asymmetric tree with missing children")
    void testAsymmetricTree() {
        /*
               1
             /   \
            2     3
             \     \
              4     5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }
}