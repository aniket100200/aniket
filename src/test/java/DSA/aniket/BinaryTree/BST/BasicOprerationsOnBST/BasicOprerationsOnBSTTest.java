package DSA.aniket.BinaryTree.BST.BasicOprerationsOnBST;

import DSA.aniket.BinaryTree.BST.BasicOprerationsOnBST.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTOperationsTest {

    BasicOprerationsOnBST bst = new Solution();

    // --- Helper to build tree from the problem's specific input format ---
    private int buildIndex = 0;

    private TreeNode constructTree(String input) {
        buildIndex = 0; // Reset index for each test
        String[] arr = input.split(" ");
        return buildTreeHelper(arr);
    }

    private TreeNode buildTreeHelper(String[] arr) {
        if (buildIndex >= arr.length || arr[buildIndex].equals("n")) {
            buildIndex++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[buildIndex++]));
        node.left = buildTreeHelper(arr);
        node.right = buildTreeHelper(arr);
        return node;
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        String treeInput = "50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n";
        int targetData = 70;

        TreeNode root = constructTree(treeInput);

        assertEquals(9, bst.size(root), "Size should be 9");
        assertEquals(448, bst.sum(root), "Sum should be 448");
        assertEquals(87, bst.max(root), "Max should be 87");
        assertEquals(12, bst.min(root), "Min should be 12");
        assertTrue(bst.find(root, targetData), "Tree should contain 70");
    }

    @Test
    public void testExample2() {
        String treeInput = "4 3 2 n n n 5 n n";
        int targetData = 8;

        TreeNode root = constructTree(treeInput);

        assertEquals(4, bst.size(root), "Size should be 4");
        assertEquals(14, bst.sum(root), "Sum should be 14");
        assertEquals(5, bst.max(root), "Max should be 5");
        assertEquals(2, bst.min(root), "Min should be 2");
        assertFalse(bst.find(root, targetData), "Tree should NOT contain 8");
    }

    @Test
    public void testSingleNodeTree() {
        String treeInput = "42 n n";
        int targetData = 42;

        TreeNode root = constructTree(treeInput);

        assertEquals(1, bst.size(root));
        assertEquals(42, bst.sum(root));
        assertEquals(42, bst.max(root));
        assertEquals(42, bst.min(root));
        assertTrue(bst.find(root, targetData));
        assertFalse(bst.find(root, 99)); // Check for non-existent element
    }

    @Test
    public void testLeftSkewedTree() {
        String treeInput = "10 5 2 n n n n";

        TreeNode root = constructTree(treeInput);

        assertEquals(3, bst.size(root));
        assertEquals(17, bst.sum(root));
        assertEquals(10, bst.max(root));
        assertEquals(2, bst.min(root));
    }

    @Test
    public void testRightSkewedTree() {
        String treeInput = "10 n 20 n 30 n n";

        TreeNode root = constructTree(treeInput);

        assertEquals(3, bst.size(root));
        assertEquals(60, bst.sum(root));
        assertEquals(30, bst.max(root));
        assertEquals(10, bst.min(root));
    }

}