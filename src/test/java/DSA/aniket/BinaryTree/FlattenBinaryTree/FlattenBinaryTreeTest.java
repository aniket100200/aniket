package DSA.aniket.BinaryTree.FlattenBinaryTree;

import DSA.aniket.BinaryTree.FlattenBinaryTree.RightSkewedTree.RightSkewedTree;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlattenBinaryTreeTest {

    private FlattenBinaryTree solution = new RightSkewedTree();

    // Helper: Validates that the tree is flattened and matches the expected pre-order values
    private void assertIsFlattened(TreeNode root, int[] expectedValues) {
        if (expectedValues.length == 0) {
            assertNull(root, "Expected an empty tree, but root is not null.");
            return;
        }

        TreeNode current = root;
        List<Integer> actualValues = new ArrayList<>();

        while (current != null) {
            // Left child MUST be null in a flattened tree
            assertNull(current.left, "Found a non-null left child at node with value: " + current.val);

            actualValues.add(current.val);
            current = current.right;
        }

        // Convert List to Array for easy comparison
        int[] actualArray = actualValues.stream().mapToInt(i -> i).toArray();
        assertArrayEquals(expectedValues, actualArray, "The flattened tree does not match the expected pre-order sequence.");
    }

    // --- Tests ---

    @Test
    public void testExample1_StandardTree() {
        // Construct Tree: [1, 2, 5, 3, 4, null, 6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);

        int[] expectedPreorder = {1, 2, 3, 4, 5, 6};
        assertIsFlattened(root, expectedPreorder);
    }

    @Test
    public void testExample2_EmptyTree() {
        TreeNode root = null;
        solution.flatten(root);

        int[] expectedPreorder = {};
        assertIsFlattened(root, expectedPreorder);
    }

    @Test
    public void testExample3_SingleNode() {
        TreeNode root = new TreeNode(0);
        solution.flatten(root);

        int[] expectedPreorder = {0};
        assertIsFlattened(root, expectedPreorder);
    }

    @Test
    public void testLeftSkewedTree() {
        // Construct Tree: 1 -> left(2) -> left(3)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        solution.flatten(root);

        int[] expectedPreorder = {1, 2, 3};
        assertIsFlattened(root, expectedPreorder);
    }

    @Test
    public void testRightSkewedTree_AlreadyFlattened() {
        // Construct Tree: 1 -> right(2) -> right(3)
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        solution.flatten(root);

        int[] expectedPreorder = {1, 2, 3};
        assertIsFlattened(root, expectedPreorder);
    }
}