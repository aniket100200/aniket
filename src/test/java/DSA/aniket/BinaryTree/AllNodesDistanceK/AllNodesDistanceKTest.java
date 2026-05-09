package DSA.aniket.BinaryTree.AllNodesDistanceK;


import DSA.aniket.BinaryTree.AllNodesDistanceK.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DistanceKTest {


    private final AllNodesDistanceK solution = new Solution();

    // Helper method to compare lists regardless of order
    private void assertListEqualsIgnoreOrder(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size(), "Lists should be the same size");
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected),
                "Lists do not contain the same elements. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testExample1_StandardCase() {
        // Construct Tree: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // Target node with value 5
        int k = 2;

        List<Integer> expected = Arrays.asList(7, 4, 1);
        List<Integer> actual = solution.distanceK(root, target, k);

        assertListEqualsIgnoreOrder(expected, actual);
    }

    @Test
    public void testExample2_SingleNodeTree() {
        // Construct Tree: [1]
        TreeNode root = new TreeNode(1);
        TreeNode target = root; // Target node with value 1
        int k = 3;

        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = solution.distanceK(root, target, k);

        assertListEqualsIgnoreOrder(expected, actual);
    }

    @Test
    public void testTargetIsRoot() {
        // Construct Tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode target = root; // Target node with value 1
        int k = 1;

        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> actual = solution.distanceK(root, target, k);

        assertListEqualsIgnoreOrder(expected, actual);
    }

    @Test
    public void testTargetIsLeaf_UpwardTraversalRequired() {
        // Construct Tree: [0,1,null,3,2]
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        TreeNode target = root.left.right; // Target node with value 2
        int k = 1;

        List<Integer> expected = Collections.singletonList(1);
        List<Integer> actual = solution.distanceK(root, target, k);

        assertListEqualsIgnoreOrder(expected, actual);
    }

    @Test
    public void testDistanceZero() {
        // Construct Tree: [3,5,1]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        TreeNode target = root.left; // Target node with value 5
        int k = 0; // Distance 0 should just return the target itself

        List<Integer> expected = Collections.singletonList(5);
        List<Integer> actual = solution.distanceK(root, target, k);

        assertListEqualsIgnoreOrder(expected, actual);
    }
}