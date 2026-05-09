package DSA.aniket.BinaryTree.PathToGivenNode;

import DSA.aniket.BinaryTree.PathToGivenNode.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final PathToGivenNode solution = new Solution();

    // Helper method to build a binary tree from level order array
    private TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    @Test
    void testExample1() {
        // Tree: [1, 2, 3, 4, 5, 6, 7], Target: 5
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> expected = Arrays.asList(1, 2, 5);
        assertEquals(expected, solution.solve(root, 5), "Should return path {1, 2, 5}");
    }

    @Test
    void testExample2() {
        // Tree: [1, 2, 3, 4, 5], Target: 1
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, 5});
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, solution.solve(root, 1), "Should return path {1} when target is root");
    }

    @Test
    void testRightmostNode() {
        // Tree: [1, 2, 3, 4, 5, 6, 7], Target: 7
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<Integer> expected = Arrays.asList(1, 3, 7);
        assertEquals(expected, solution.solve(root, 7), "Should traverse right branches correctly");
    }

    @Test
    void testLeftmostDeepNode() {
        // Tree: [1, 2, null, 3, null, 4], Target: 4
        TreeNode root = buildTree(new Integer[]{1, 2, null, 3, null, 4});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, solution.solve(root, 4), "Should handle unbalanced left-heavy trees");
    }

    @Test
    void testNodeNotFound() {
        // Constraints state 1 <= b <= n, meaning b is always present,
        // but it's good practice to ensure empty path is handled safely.
        TreeNode root = buildTree(new Integer[]{1, 2, 3});
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.solve(root, 99), "Should return empty list if node doesn't exist");
    }
}