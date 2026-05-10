package DSA.aniket.BinaryTree.Construction.FromPreOrderAndInOrder;

import DSA.aniket.BinaryTree.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConstructTreePrePostTest {

    private final Construction solution = new FromPreOrderAndInorderOrder();

    // Helper: Validates a built tree by extracting its traversals and comparing them to inputs
    private void assertValidReconstruction(int[] expectedPreorder, int[] expectedPostorder, TreeNode root) {
        assertNotNull(root, "Reconstructed tree should not be null.");

        int[] actualPreorder = getPreorder(root);
        int[] actualPostorder = getPostorder(root);

        assertArrayEquals(expectedPreorder, actualPreorder, "Preorder traversal does not match!");
        assertArrayEquals(expectedPostorder, actualPostorder, "Postorder traversal does not match!");
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

    // Extractor: Postorder
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

    @Test
    public void testExample1_FullTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = solution.buildTree(preorder, postorder);
        assertValidReconstruction(preorder, postorder, root);
    }

    @Test
    public void testExample2_SingleNode() {
        int[] preorder = {1};
        int[] postorder = {1};

        TreeNode root = solution.buildTree(preorder, postorder);
        assertValidReconstruction(preorder, postorder, root);
    }


    // --- Tests ---

    @Test
    public void testTwoNodes_Ambiguous() {
        // Can be 1->left(2) OR 1->right(2). Both are valid as long as pre/post match.
        int[] preorder = {1, 2};
        int[] postorder = {2, 1};

        TreeNode root = solution.buildTree(preorder, postorder);
        assertValidReconstruction(preorder, postorder, root);
    }

    @Test
    public void testSkewedTree() {
        // A tree that goes straight down: 1 -> 2 -> 3
        int[] preorder = {1, 2, 3};
        int[] postorder = {3, 2, 1};

        TreeNode root = solution.buildTree(preorder, postorder);
        assertValidReconstruction(preorder, postorder, root);
    }

    @Test
    public void testUnbalancedTree() {
        // Tree: 1 -> left: 2 (left: 4), right: 3 (left: 5)
        int[] preorder = {1, 2, 4, 3, 5};
        int[] postorder = {4, 2, 5, 3, 1};

        TreeNode root = solution.buildTree(preorder, postorder);
        assertValidReconstruction(preorder, postorder, root);
    }
}