package DSA.aniket.BinaryTree.SingleChildNode;

import DSA.aniket.BinaryTree.SingleChildNode.BrutzForceSolution.BrutzForceSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleChildNodesTest {

    SingleChildNode solution = new BrutzForceSolution();

    @Test
    @DisplayName("Example 1: Standard tree with single children on both sides")
    void testExample1() {
        SingleChildNode.TreeNode root = new SingleChildNode.TreeNode(50);
        root.left = new SingleChildNode.TreeNode(25);
        root.right = new SingleChildNode.TreeNode(75);

        root.left.left = new SingleChildNode.TreeNode(12);
        root.left.right = new SingleChildNode.TreeNode(37);
        root.left.right.left = new SingleChildNode.TreeNode(30); // Single child

        root.right.left = new SingleChildNode.TreeNode(62);
        root.right.right = new SingleChildNode.TreeNode(87);
        root.right.left.right = new SingleChildNode.TreeNode(70); // Single child

        List<Integer> expected = Arrays.asList(30, 70);
        assertEquals(expected, solution.getSingleChildren(root));
    }

    // --- Tests ---

    @Test
    @DisplayName("Example 2: Left-heavy and right-heavy single children")
    void testExample2() {
        SingleChildNode.TreeNode root = new SingleChildNode.TreeNode(50);
        root.left = new SingleChildNode.TreeNode(25);
        root.right = new SingleChildNode.TreeNode(75);

        root.left.left = new SingleChildNode.TreeNode(12); // Single child

        root.right.left = new SingleChildNode.TreeNode(62);
        root.right.right = new SingleChildNode.TreeNode(87);
        root.right.left.left = new SingleChildNode.TreeNode(30); // Single child

        List<Integer> expected = Arrays.asList(12, 30);
        assertEquals(expected, solution.getSingleChildren(root));
    }

    @Test
    @DisplayName("Should return empty list for a perfect binary tree (no single children)")
    void testPerfectBinaryTree() {
        SingleChildNode.TreeNode root = new SingleChildNode.TreeNode(1);
        root.left = new SingleChildNode.TreeNode(2);
        root.right = new SingleChildNode.TreeNode(3);
        root.left.left = new SingleChildNode.TreeNode(4);
        root.left.right = new SingleChildNode.TreeNode(5);
        root.right.left = new SingleChildNode.TreeNode(6);
        root.right.right = new SingleChildNode.TreeNode(7);

        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.getSingleChildren(root));
    }

    @Test
    @DisplayName("Should return all elements (except root) for a completely skewed tree")
    void testSkewedTree() {
        SingleChildNode.TreeNode root = new SingleChildNode.TreeNode(1);
        root.left = new SingleChildNode.TreeNode(2);
        root.left.left = new SingleChildNode.TreeNode(3);
        root.left.left.left = new SingleChildNode.TreeNode(4);

        List<Integer> expected = Arrays.asList(2, 3, 4);
        assertEquals(expected, solution.getSingleChildren(root));
    }

    @Test
    @DisplayName("Should return empty list for a single node tree")
    void testSingleNode() {
        SingleChildNode.TreeNode root = new SingleChildNode.TreeNode(100);
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.getSingleChildren(root));
    }

    @Test
    @DisplayName("Should return empty list for a null tree")
    void testNullTree() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.getSingleChildren(null));
    }

    // --- Provided Classes for Testing ---

}