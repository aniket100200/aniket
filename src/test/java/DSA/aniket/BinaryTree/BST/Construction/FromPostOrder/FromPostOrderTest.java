package DSA.aniket.BinaryTree.BST.Construction.FromPostOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBSTFromPostorderTest {


    private final Construction solution = new FromPostOrder();

    // --- Verification Helpers ---

    // 1. Extract Postorder to ensure it matches the input
    private int[] getPostorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsPostorder(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void dfsPostorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfsPostorder(node.left, list);
        dfsPostorder(node.right, list);
        list.add(node.val);
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
    private void assertValidBSTConstruction(int[] expectedPostorder, TreeNode root) {
        if (expectedPostorder.length == 0) {
            assertNull(root, "Tree should be null for an empty input.");
            return;
        }

        assertNotNull(root, "Reconstructed tree should not be null.");

        // Check 1: Does the Postorder match the input?
        assertArrayEquals(expectedPostorder, getPostorder(root),
                "The Postorder traversal of the generated tree does not match the input.");

        // Check 2: Is it a valid BST? (Inorder must be sorted)
        int[] actualInorder = getInorder(root);
        assertTrue(isSorted(actualInorder),
                "The generated tree violates BST properties (Inorder is not sorted).");
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] postOrder = {1, 2, 5, 7, 6, 3};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }

    @Test
    public void testExample2() {
        int[] postOrder = {1, 7, 5, 12, 10, 8};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }

    @Test
    public void testEmptyTree() {
        int[] postOrder = {};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }

    @Test
    public void testSingleNode() {
        int[] postOrder = {42};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }

    @Test
    public void testLeftSkewedTree() {
        // Tree: 50 -> left(40) -> left(30) -> left(20) -> left(10)
        // Postorder travels bottom-up left
        int[] postOrder = {10, 20, 30, 40, 50};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }

    @Test
    public void testRightSkewedTree() {
        // Tree: 10 -> right(20) -> right(30) -> right(40) -> right(50)
        // Postorder travels bottom-up right
        int[] postOrder = {50, 40, 30, 20, 10};
        TreeNode root = solution.constructBST(postOrder);
        assertValidBSTConstruction(postOrder, root);
    }
}