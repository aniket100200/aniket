package DSA.aniket.BinaryTree.BST.ValidateBST;

import DSA.aniket.BinaryTree.BST.ValidateBST.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBSTTest {

    private final ValidateBST solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_ValidBST() {
        // Construct Tree: [2, 1, 3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        assertTrue(solution.isValidBST(root), "Tree [2, 1, 3] should be a valid BST.");
    }

    @Test
    public void testExample2_LocalViolation() {
        // Construct Tree: [5, 1, 4, null, null, 3, 6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        assertFalse(solution.isValidBST(root), "Tree should be invalid because right child (4) is less than root (5).");
    }

    @Test
    public void testGlobalPropertyViolation() {
        // Construct Tree: [5, 4, 6, null, null, 3, 7]
        // This tests the trap where a node is locally valid but globally invalid.
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        // 3 is less than 6 (valid locally), but it's in the right subtree of 5! (Invalid globally)
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        assertFalse(solution.isValidBST(root), "Tree should be invalid because 3 is in the right subtree of 5.");
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(0);
        assertTrue(solution.isValidBST(root), "A single node tree is always a valid BST.");
    }

    @Test
    public void testIntegerBoundaries() {
        // Construct Tree: [2147483647, -2147483648, null]
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);

        assertTrue(solution.isValidBST(root), "Tree with Integer.MAX_VALUE and MIN_VALUE should be valid.");
    }

    @Test
    public void testDuplicateValues() {
        // Construct Tree: [2, 2, 2]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        assertFalse(solution.isValidBST(root), "Tree should be invalid because duplicates are not allowed.");
    }

    @Test
    @DisplayName("Integer Max value Twice")
    public void testDuplicateMax() {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);

        assertFalse(solution.isValidBST(root));
    }
}