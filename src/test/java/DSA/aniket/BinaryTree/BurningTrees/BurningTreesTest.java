package DSA.aniket.BinaryTree.BurningTrees;

import DSA.aniket.BinaryTree.BurningTrees.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurningTreeTest {

    BurningTrees solution = new Solution();

    @Test
    public void testExample1_StandardCase() {
        // Construct Tree: [1, 2, 3, 4, 5, 6, 7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int target = 2;
        int expected = 3;

        assertEquals(expected, solution.minTime(root, target));
    }

    @Test
    public void testExample2_UnbalancedTree() {
        // Construct Tree: [1, 2, 3, 4, 5, null, 7, 8, null, null, 10]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.right = new TreeNode(10);

        int target = 10;
        int expected = 5;

        assertEquals(expected, solution.minTime(root, target));
    }

    @Test
    public void testTargetIsRoot() {
        // Construct Tree: [1, 2, 3, 4, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int target = 1;
        int expected = 2;

        assertEquals(expected, solution.minTime(root, target));
    }

    @Test
    public void testSingleNodeTree() {
        // Construct Tree: [1]
        TreeNode root = new TreeNode(1);

        int target = 1;
        int expected = 0; // Burns instantly at time 0

        assertEquals(expected, solution.minTime(root, target));
    }

    @Test
    public void testSkewedTree_BottomUpBurn() {
        // Construct Left-Skewed Tree: [1, 2, null, 3, null, 4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        int target = 4;
        int expected = 3; // Travels linearly 4 -> 3 -> 2 -> 1

        assertEquals(expected, solution.minTime(root, target));
    }
}