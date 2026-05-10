package DSA.aniket.BinaryTree.ChildrenSum;

import DSA.aniket.BinaryTree.ChildrenSum.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChildrenSumTest {


    private final ChildrenSum solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_ValidTree() {
        // Construct Tree: [35, 20, 15, 15, 5, 10, 5]
        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        assertTrue(solution.isSumProperty(root), "Example 1 should be valid");
    }

    @Test
    public void testExample2_InvalidTreeAtRoot() {
        // Construct Tree: [1, 4, 3, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);

        assertFalse(solution.isSumProperty(root), "Example 2 should be invalid because 1 != 4 + 3");
    }

    @Test
    public void testSingleNode() {
        // Construct Tree: [10]
        TreeNode root = new TreeNode(10);

        assertTrue(solution.isSumProperty(root), "A single leaf node is always valid");
    }

    @Test
    public void testMissingChild_Valid() {
        // Construct Tree: [10, 10, null]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        // right is null (counts as 0)

        assertTrue(solution.isSumProperty(root), "Null child should be treated as 0 (10 = 10 + 0)");
    }

    @Test
    public void testInvalidDeepNode() {
        // Construct Tree: [30, 20, 10, 15, 5, 8, 3]
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);

        // This makes it invalid: 8 + 3 = 11 (Not 10)
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(3);

        assertFalse(solution.isSumProperty(root), "Tree should be invalid if ANY node fails the property");
    }
}