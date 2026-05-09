package DSA.aniket.BinaryTree.LCA;

import DSA.aniket.BinaryTree.LCA.OptimalSolution.OptimalSolution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

    // --- Provided Classes (Do not modify the TreeNode class) ---


    private final LCA solution = new OptimalSolution();

    @Test
    @DisplayName("Should return null for an empty tree")
    void testEmptyTree() {
        assertNull(solution.findLca(null, 5, 7));
    }

    @Test
    @DisplayName("Example 1: Nodes in entirely different subtrees (LCA is Root)")
    void testExample1() {
        /*
              1
            /   \
          2      3
         /      / \
        4      5   6
         \
          7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        assertEquals(1, solution.findLca(root, 7, 5));
    }

    @Test
    @DisplayName("Example 2: One node is the ancestor of the other")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        assertEquals(2, solution.findLca(root, 4, 2));
    }

    @Test
    @DisplayName("Should find LCA when both nodes are deep in the same subtree")
    void testNodesInSameSubtree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Build right side heavily
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        // LCA of 8 and 9 should be 5
        Integer lca = solution.findLca(root, 8, 9);
        assertNotNull(lca);
        assertEquals(5, lca);
    }

    @Test
    @DisplayName("Should return the root if x and y are the direct children of the root")
    void testDirectChildren() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        assertEquals(10, solution.findLca(root, 20, 30));
    }
}