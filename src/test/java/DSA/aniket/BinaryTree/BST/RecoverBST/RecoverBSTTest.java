package DSA.aniket.BinaryTree.BST.RecoverBST;

import DSA.aniket.BinaryTree.BST.RecoverBST.UsingDFS.UsingDFS;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoverBSTTest {

    //    private RecoverBST solution = new UsingIterativeDFS();
    private RecoverBST solution = new UsingDFS();
    // --- Helper: Build Tree from Preorder with -1 as Null ---
    private int buildIndex = 0;

    private TreeNode constructTree(int[] arr) {
        buildIndex = 0; // Reset index before building
        return buildTreeHelper(arr);
    }

    private TreeNode buildTreeHelper(int[] arr) {
        if (buildIndex >= arr.length || arr[buildIndex] == -1) {
            buildIndex++;
            return null;
        }
        TreeNode node = new TreeNode(arr[buildIndex++]);
        node.left = buildTreeHelper(arr);
        node.right = buildTreeHelper(arr);
        return node;
    }

    // --- Verification Helpers ---

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

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }

    // Master Validator
    private void assertValidRecovery(TreeNode root) {
        assertNotNull(root, "Tree should not be null.");

        int[] actualInorder = getInorder(root);
        assertTrue(isSorted(actualInorder),
                "The tree is not completely recovered. The Inorder traversal is not strictly sorted.");
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] preorderWithNulls = {4, 2, 3, -1, -1, -1, 5, -1, -1};
        TreeNode root = constructTree(preorderWithNulls);

        solution.recoverTree(root);
        assertValidRecovery(root);
    }

    @Test
    public void testExample2() {
        int[] preorderWithNulls = {7, 3, 2, -1, -1, 10, -1, -1, 5, -1, 12, -1, -1};
        TreeNode root = constructTree(preorderWithNulls);

        solution.recoverTree(root);
        assertValidRecovery(root);
    }

    @Test
    public void testSwappedAdjacentNodes() {
        // Correct tree: 2 -> left(1), right(3).
        // Let's swap 1 and 2.
        // Bad tree: 1 -> left(2), right(3).
        // Preorder: 1, 2, -1, -1, 3, -1, -1
        int[] preorderWithNulls = {1, 2, -1, -1, 3, -1, -1};
        TreeNode root = constructTree(preorderWithNulls);

        solution.recoverTree(root);
        assertValidRecovery(root);
    }

    @Test
    public void testSwappedDistantNodes() {
        // Correct tree: 5 -> left(3), right(8) -> left(1), right(4), left(6), right(9)
        // Let's swap 1 (min) and 9 (max).
        // Preorder structure matching the bad tree...
        // 5 -> left(3 -> left(9), right(4)), right(8 -> left(6), right(1))
        int[] preorderWithNulls = {5, 3, 9, -1, -1, 4, -1, -1, 8, 6, -1, -1, 1, -1, -1};
        TreeNode root = constructTree(preorderWithNulls);

        solution.recoverTree(root);
        assertValidRecovery(root);
    }
}