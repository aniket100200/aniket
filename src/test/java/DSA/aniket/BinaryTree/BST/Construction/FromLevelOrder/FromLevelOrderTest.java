package DSA.aniket.BinaryTree.BST.Construction.FromLevelOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBSTFromLevelOrderTest {

    Construction solution = new FromLevelOrder();

    // 1. Extract Level Order to ensure it matches the input
    private int[] getLevelOrder(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add(current.val);

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 2. Extract Inorder to ensure the constructed tree is actually a valid BST
    private int[] getInorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsInorder(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    // --- Verification Helpers ---

    private void dfsInorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfsInorder(node.left, list);
        list.add(node.val);
        dfsInorder(node.right, list);
    }

    // 3. Check if an array is strictly sorted (Validates BST property)
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }

    // Master Validator
    private void assertValidBSTConstruction(int[] expectedLevelOrder, TreeNode root) {
        if (expectedLevelOrder.length == 0) {
            assertNull(root, "Tree should be null for an empty input.");
            return;
        }

        assertNotNull(root, "Reconstructed tree should not be null.");

        // Check 1: Does the Level Order match the input?
        assertArrayEquals(expectedLevelOrder, getLevelOrder(root),
                "The Level Order traversal of the generated tree does not match the input.");

        // Check 2: Is it a valid BST? (Inorder must be sorted)
        int[] actualInorder = getInorder(root);
        assertTrue(isSorted(actualInorder),
                "The generated tree violates BST properties (Inorder is not strictly sorted).");
    }

    @Test
    public void testExample1_StandardTree() {
        int[] levelOrder = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }

    @Test
    public void testExample2_RightSkewedTree() {
        // If elements are inserted in ascending order, it forms a right-skewed tree
        int[] levelOrder = {1, 3, 4, 6, 7, 8};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }

    // --- Tests ---

    @Test
    public void testLeftSkewedTree() {
        // If elements are inserted in descending order, it forms a left-skewed tree
        int[] levelOrder = {50, 40, 30, 20, 10};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }

    @Test
    public void testEmptyTree() {
        int[] levelOrder = {};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }

    @Test
    public void testSingleNode() {
        int[] levelOrder = {42};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }

    @Test
    public void testCompleteBST() {
        // A perfectly balanced BST
        // Level 1: 4
        // Level 2: 2, 6
        // Level 3: 1, 3, 5, 7
        int[] levelOrder = {4, 2, 6, 1, 3, 5, 7};
        TreeNode root = solution.constructBST(levelOrder);
        assertValidBSTConstruction(levelOrder, root);
    }
}