package DSA.aniket.BinaryTree.BST.Construction;

import DSA.aniket.BinaryTree.BST.Construction.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayToBSTTest {

    private final Construction solution = new Solution();

    // --- Verification Helpers ---

    // 1. Check if the tree is height-balanced
    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 2. Extract Inorder to verify BST integrity (must match the input sorted array)
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

    // 3. Master Validator
    private void assertValidBalancedBST(int[] nums, TreeNode root) {
        assertNotNull(root, "The returned tree should not be null.");

        assertTrue(isBalanced(root), "The generated tree is not height-balanced.");

        int[] actualInorder = getInorder(root);
        assertArrayEquals(nums, actualInorder, "The tree is not a valid BST or is missing elements. Inorder traversal does not match the input.");
    }

    // --- Tests ---

    @Test
    public void testExample1_OddLengthArray() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertValidBalancedBST(nums, root);
    }

    @Test
    public void testExample2_TwoElements() {
        int[] nums = {1, 3};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertValidBalancedBST(nums, root);
    }

    @Test
    public void testEvenLengthArray() {
        int[] nums = {1, 2, 3, 4};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertValidBalancedBST(nums, root);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {42};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertValidBalancedBST(nums, root);
    }

    @Test
    public void testPerfectlyBalancedLargeTree() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = solution.sortedArrayToBST(nums);
        assertValidBalancedBST(nums, root);
    }
}