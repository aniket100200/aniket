package DSA.aniket.BinaryTree.FindTheNode;

import DSA.aniket.BinaryTree.FindTheNode.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNodeInBinaryTreeTest {


    FindTheNode solution = new Solution();

    // --- YOUR IMPLEMENTATION GOES HERE ---

    @Test
    @DisplayName("Should return null for an empty tree (null root)")
    void testEmptyTree() {
        assertNull(solution.searchNode(null, 5));
    }

    // --- Test Cases ---

    @Test
    @DisplayName("Should return the root node if it matches the target")
    void testTargetIsRoot() {
        TreeNode root = new TreeNode(10);

        TreeNode result = solution.searchNode(root, 10);
        assertNotNull(result);
        assertEquals(10, result.val);
    }

    @Test
    @DisplayName("Example 1: Should find target deep in the left subtree")
    void testTargetInLeftSubtree() {
        /*
               4
              / \
             2   7
            / \
           1   3
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = solution.searchNode(root, 3);
        assertNotNull(result, "Node should be found");
        assertEquals(3, result.val);
    }

    @Test
    @DisplayName("Should find target deep in the right subtree")
    void testTargetInRightSubtree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode result = solution.searchNode(root, 4);
        assertNotNull(result, "Node should be found");
        assertEquals(4, result.val);
    }

    @Test
    @DisplayName("Example 2: Should return null if the target does not exist in the tree")
    void testTargetNotFound() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = solution.searchNode(root, 5);
        assertNull(result, "Should return null for non-existent target");
    }

    @Test
    @DisplayName("Should return the correct node even if there are negative values")
    void testNegativeValues() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-20);
        root.right = new TreeNode(-5);
        root.right.left = new TreeNode(-15);

        TreeNode result = solution.searchNode(root, -15);
        assertNotNull(result);
        assertEquals(-15, result.val);
    }


}