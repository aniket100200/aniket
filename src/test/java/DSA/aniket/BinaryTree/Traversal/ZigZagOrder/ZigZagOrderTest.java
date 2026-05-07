package DSA.aniket.BinaryTree.Traversal.ZigZagOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagLevelOrderTraversalTest {


    private final Traverse solution = new ZigZagOrder();

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

        // Expected: [3] -> [20, 9] -> [15, 7]
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }

    @Test
    @DisplayName("Should correctly zigzag a perfect binary tree of 3 levels")
    void testPerfectBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Level 0 (L->R): 1
        // Level 1 (R->L): 3, 2
        // Level 2 (L->R): 4, 5, 6, 7
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }

    @Test
    @DisplayName("Should correctly handle an asymmetric tree")
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

        // Level 0 (L->R): 1
        // Level 1 (R->L): 3, 2
        // Level 2 (L->R): 4, 5
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5)
        );
        assertEquals(expected, solution.traverseLevel(root));
    }
}