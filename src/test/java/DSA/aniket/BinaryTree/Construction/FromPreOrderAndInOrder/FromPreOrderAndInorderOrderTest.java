package DSA.aniket.BinaryTree.Construction.FromPreOrderAndInOrder;

import DSA.aniket.BinaryTree.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConstructTreePreInTest {


    private final Construction solution = new FromPreOrderAndInorderOrder();

    // Helper: Validates a built tree by extracting its traversals and comparing them to inputs
    private void assertValidReconstruction(int[] expectedPreorder, int[] expectedInorder, TreeNode root) {
        assertNotNull(root, "Reconstructed tree should not be null.");

        int[] actualPreorder = getPreorder(root);
        int[] actualInorder = getInorder(root);

        assertArrayEquals(expectedPreorder, actualPreorder, "Preorder traversal does not match the reconstructed tree!");
        assertArrayEquals(expectedInorder, actualInorder, "Inorder traversal does not match the reconstructed tree!");
    }

    // Extractor: Preorder
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

    // Extractor: Inorder
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

    // --- Tests ---

    @Test
    public void testExample1_StandardTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);
        assertValidReconstruction(preorder, inorder, root);
    }

    @Test
    public void testExample2_SingleNode() {
        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode root = solution.buildTree(preorder, inorder);
        assertValidReconstruction(preorder, inorder, root);
    }

    @Test
    public void testLeftSkewedTree() {
        // Tree: 1 -> left(2) -> left(3)
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};

        TreeNode root = solution.buildTree(preorder, inorder);
        assertValidReconstruction(preorder, inorder, root);
    }

    @Test
    public void testRightSkewedTree() {
        // Tree: 1 -> right(2) -> right(3)
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};

        TreeNode root = solution.buildTree(preorder, inorder);
        assertValidReconstruction(preorder, inorder, root);
    }

    @Test
    public void testComplexUnbalancedTree() {
        // Tree: 1 -> left(2 -> left(4), right(5)), right(3 -> left(6))
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 6, 3};

        TreeNode root = solution.buildTree(preorder, inorder);
        assertValidReconstruction(preorder, inorder, root);
    }
}