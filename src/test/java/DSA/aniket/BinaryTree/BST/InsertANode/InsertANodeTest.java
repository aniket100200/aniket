package DSA.aniket.BinaryTree.BST.InsertANode;

import DSA.aniket.BinaryTree.BST.InsertANode.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntoBSTTest {

    private final InsertANode solution = new Solution();

    // Helper: Builds a BST by sequentially inserting values
    private TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int val : values) {
            root = solution.insertIntoBST(root, val);
        }
        return root;
    }

    // Helper: Extracts the Preorder traversal into an array
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

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] initialNodes = {2, 81, 87, 90, 42, 41};
        int keyToInsert = 44;

        TreeNode root = buildBST(initialNodes);
        root = solution.insertIntoBST(root, keyToInsert);

        int[] expectedPreorder = {2, 81, 42, 41, 44, 87, 90};
        assertArrayEquals(expectedPreorder, getPreorder(root), "Preorder traversal does not match Example 1.");
    }

    @Test
    public void testExample2() {
        int[] initialNodes = {14, 3, 11};
        int keyToInsert = 8;

        TreeNode root = buildBST(initialNodes);
        root = solution.insertIntoBST(root, keyToInsert);

        int[] expectedPreorder = {14, 3, 11, 8};
        assertArrayEquals(expectedPreorder, getPreorder(root), "Preorder traversal does not match Example 2.");
    }

    @Test
    public void testInsertIntoEmptyTree() {
        TreeNode root = null;
        root = solution.insertIntoBST(root, 50);

        int[] expectedPreorder = {50};
        assertArrayEquals(expectedPreorder, getPreorder(root), "Failed to insert into an empty tree.");
    }

    @Test
    public void testInsertLeftSkewed() {
        int[] initialNodes = {50, 40, 30, 20}; // Already left skewed
        int keyToInsert = 10;

        TreeNode root = buildBST(initialNodes);
        root = solution.insertIntoBST(root, keyToInsert);

        int[] expectedPreorder = {50, 40, 30, 20, 10};
        assertArrayEquals(expectedPreorder, getPreorder(root), "Failed insertion on a left-skewed tree.");
    }

    @Test
    public void testInsertRightSkewed() {
        int[] initialNodes = {10, 20, 30, 40}; // Already right skewed
        int keyToInsert = 50;

        TreeNode root = buildBST(initialNodes);
        root = solution.insertIntoBST(root, keyToInsert);

        int[] expectedPreorder = {10, 20, 30, 40, 50};
        assertArrayEquals(expectedPreorder, getPreorder(root), "Failed insertion on a right-skewed tree.");
    }
}