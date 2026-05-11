package DSA.aniket.BinaryTree.BST.DeleteANode;

import DSA.aniket.BinaryTree.BST.DeleteANode.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeleteNodeBSTTest {

    private final DeleteANode solution = new Solution();

    // Helper: Extracts the Inorder traversal to verify the BST property is maintained
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

    // Helper: Builds the standard Example 1 Tree -> [5,3,6,2,4,null,7]
    private TreeNode buildStandardTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    // --- Tests ---

    @Test
    @DisplayName("Delete A Node With Two Children")
    public void testExample1_DeleteNodeWithTwoChildren() {
        TreeNode root = buildStandardTree();
        int keyToDelete = 3;

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        // Original inorder: 2, 3, 4, 5, 6, 7.  Expected after removing 3: 2, 4, 5, 6, 7
        int[] expectedInorder = {2, 4, 5, 6, 7};
        assertArrayEquals(expectedInorder, getInorder(updatedRoot),
                "Failed to delete a node with two children correctly.");
    }

    @Test
    @DisplayName("If Key is Not Present")
    public void testExample2_KeyNotFound() {
        TreeNode root = buildStandardTree();
        int keyToDelete = 0;

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        // Tree should remain unchanged
        int[] expectedInorder = {2, 3, 4, 5, 6, 7};
        assertArrayEquals(expectedInorder, getInorder(updatedRoot),
                "Tree should remain unchanged if key is not found.");
    }

    @Test
    @DisplayName("If Tree is Empty")
    public void testExample3_EmptyTree() {
        TreeNode root = null;
        int keyToDelete = 0;

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        assertNull(updatedRoot, "Deleting from an empty tree should return null.");
    }

    @Test
    @DisplayName("Deleting A Leaf Node")
    public void testDeleteLeafNode() {
        TreeNode root = buildStandardTree();
        int keyToDelete = 2; // Node 2 is a leaf

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        int[] expectedInorder = {3, 4, 5, 6, 7};
        assertArrayEquals(expectedInorder, getInorder(updatedRoot),
                "Failed to delete a leaf node correctly.");
    }

    @Test
    @DisplayName("Deleting A node with Single Child")
    public void testDeleteNodeWithOneChild() {
        TreeNode root = buildStandardTree();
        int keyToDelete = 6; // Node 6 only has a right child (7)

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        int[] expectedInorder = {2, 3, 4, 5, 7};
        assertArrayEquals(expectedInorder, getInorder(updatedRoot),
                "Failed to delete a node with exactly one child.");
    }

    @Test
    @DisplayName("Deleting a Root Node")
    public void testDeleteRootNode() {
        TreeNode root = buildStandardTree();
        int keyToDelete = 5; // Deleting the root of the tree

        TreeNode updatedRoot = solution.deleteNode(root, keyToDelete);

        int[] expectedInorder = {2, 3, 4, 6, 7};
        assertArrayEquals(expectedInorder, getInorder(updatedRoot),
                "Failed to delete the root node of the BST.");
    }


    @DisplayName("Deleting a Root Node and the right subtree has some left Tree")
    @Test
    public void testingANodeRoot() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.right = new TreeNode(40);

        root.right = new TreeNode(70);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        int[] expectedInorder = {60, 30, 70, 40, 80};
    }
}