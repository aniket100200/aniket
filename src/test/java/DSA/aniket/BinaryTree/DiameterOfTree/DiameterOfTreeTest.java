package DSA.aniket.BinaryTree.DiameterOfTree;

import DSA.aniket.BinaryTree.DiameterOfTree.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiameterOfBinaryTreeTest {
    private DiameterOfTree solution = new Solution();

    @Test
    @DisplayName("Example 1: Standard balanced-ish tree")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Path: 4 -> 2 -> 1 -> 3 (3 edges)
        assertEquals(3, -1 + solution.diameter(root));
    }

    @Test
    @DisplayName("Example 2: Two node tree")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // Path: 2 -> 1 (1 edge)
        assertEquals(1, -1 + solution.diameter(root));
    }

    @Test
    @DisplayName("Should return 0 for a single node tree (0 edges)")
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        assertEquals(0, -1 + solution.diameter(root));
    }

    @Test
    @DisplayName("Should return 0 for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(0, solution.diameter(null));
    }

    @Test
    @DisplayName("Should correctly calculate diameter when longest path does NOT pass through the root")
    void testPathNotThroughRoot() {
        /*
                  1
                 / \
                2   3
               / \
              4   5
             /     \
            6       7
           /         \
          8           9

          The longest path is 8 -> 6 -> 4 -> 2 -> 5 -> 7 -> 9
          This has 6 edges. It never passes through the root (1).
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.left.left.left.left = new TreeNode(8);
        root.left.right.right.right = new TreeNode(9);

        assertEquals(6, -1 + solution.diameter(root));
    }

    @Test
    @DisplayName("Should correctly calculate diameter for a completely skewed tree")
    void testSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);

        // Path is the entire tree: 1 -> 2 -> 3 -> 4 -> 5 (4 edges)
        assertEquals(4, -1 + solution.diameter(root));
    }
}