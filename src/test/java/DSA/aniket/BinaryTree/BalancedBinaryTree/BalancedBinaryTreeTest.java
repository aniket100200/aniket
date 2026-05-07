package DSA.aniket.BinaryTree.BalancedBinaryTree;

import DSA.aniket.BinaryTree.BalancedBinaryTree.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BalancedBinaryTreeTest {


    // --- Test Cases ---

    BalancedBinaryTree solution = new Solution();

    @Test
    @DisplayName("Should return true for an empty tree (null root)")
    void testEmptyTree() {
        assertTrue(solution.isBalanced(null));
    }

    @Test
    @DisplayName("Should return true for a single node tree")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Example 1: Standard balanced tree")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Example 2: Unbalanced tree (left heavy)")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Should return false for a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Should return false for a completely right-skewed tree")
    void testRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Should return false when root is balanced but a lower subtree is not")
    void testUnbalancedLowerSubtree() {
        /*
                  1
                 / \
                2   3
               / \
              4   5
             /
            6
           /
          7

          Node 2 is unbalanced, even though Node 1's immediate children heights are close.
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(7);

        assertFalse(solution.isBalanced(root));
    }
}