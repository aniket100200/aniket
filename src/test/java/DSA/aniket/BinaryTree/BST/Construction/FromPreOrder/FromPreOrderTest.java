package DSA.aniket.BinaryTree.BST.Construction.FromPreOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBSTFromPreorderTest {


    private final Construction solution = new FromPreOrder();

    // --- Verification Helpers ---

    // 1. Extract Preorder to ensure it matches the input
    private int[] getPreorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsPreorder(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void dfsPreorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        dfsPreorder(node.left, list);
        dfsPreorder(node.right, list);
    }

    // 2. Extract Inorder to ensure the constructed tree is actually a valid BST
    private int[] getInorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsInorder(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

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
    private void assertValidBSTConstruction(int[] expectedPreorder, TreeNode root) {
        if (expectedPreorder.length == 0) {
            assertNull(root, "Tree should be null for an empty input.");
            return;
        }

        assertNotNull(root, "Reconstructed tree should not be null.");

        // Check 1: Does the Preorder match the input?
        assertArrayEquals(expectedPreorder, getPreorder(root),
                "The Preorder traversal of the generated tree does not match the input.");

        // Check 2: Is it a valid BST? (Inorder must be sorted)
        int[] actualInorder = getInorder(root);
        assertTrue(isSorted(actualInorder),
                "The generated tree violates BST properties (Inorder is not sorted).");
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] preOrder = {3, 2, 1, 6, 5, 7};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }

    @Test
    public void testExample2() {
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }

    @Test
    public void testEmptyTree() {
        int[] preOrder = {};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }

    @Test
    public void testSingleNode() {
        int[] preOrder = {42};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }

    @Test
    public void testLeftSkewedTree() {
        // Tree: 50 -> 40 -> 30 -> 20 -> 10
        int[] preOrder = {50, 40, 30, 20, 10};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }

    @Test
    public void testRightSkewedTree() {
        // Tree: 10 -> 20 -> 30 -> 40 -> 50
        int[] preOrder = {10, 20, 30, 40, 50};
        TreeNode root = solution.constructBST(preOrder);
        assertValidBSTConstruction(preOrder, root);
    }
}