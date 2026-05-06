package DSA.aniket.BinaryTree.SizeSumMaxHeight;

import DSA.aniket.BinaryTree.SizeSumMaxHeight.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePropertiesTest {

    SizeSumMaxHeight solution = new Solution();

    @Test
    @DisplayName("Example 1: Balanced-ish Tree")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        assertEquals(5, solution.getSize(root), "Size should be 5");
        assertEquals(15, solution.getSum(root), "Sum should be 15");
        assertEquals(5, solution.getMax(root), "Max should be 5");
        assertEquals(3, solution.getHeight(root), "Height should be 3");
    }

    @Test
    @DisplayName("Example 2: Left-Skewed Tree")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        assertEquals(4, solution.getSize(root), "Size should be 4");
        assertEquals(10, solution.getSum(root), "Sum should be 10");
        assertEquals(4, solution.getMax(root), "Max should be 4");
        assertEquals(4, solution.getHeight(root), "Height should be 4");
    }

    @Test
    @DisplayName("Should handle a single node tree")
    void testSingleNode() {
        TreeNode root = new TreeNode(42);

        assertEquals(1, solution.getSize(root), "Size should be 1");
        assertEquals(42, solution.getSum(root), "Sum should be 42");
        assertEquals(42, solution.getMax(root), "Max should be 42");
        assertEquals(1, solution.getHeight(root), "Height should be 1");
    }

    @Test
    @DisplayName("Should handle an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(0, solution.getSize(null), "Size should be 0");
        assertEquals(0, solution.getSum(null), "Sum should be 0");
        assertEquals(Integer.MIN_VALUE, solution.getMax(null), "Max should be Integer.MIN_VALUE");
        assertEquals(0, solution.getHeight(null), "Height should be 0");
    }

    @Test
    @DisplayName("Should correctly find max when tree contains negative numbers")
    void testNegativeNumbers() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-20);
        root.right = new TreeNode(-5);
        root.left.left = new TreeNode(-30);

        assertEquals(4, solution.getSize(root), "Size should be 4");
        assertEquals(-65, solution.getSum(root), "Sum should be -65");
        assertEquals(-5, solution.getMax(root), "Max should be -5");
        assertEquals(3, solution.getHeight(root), "Height should be 3");
    }

    @Test
    @DisplayName("Should correctly compute properties for a complex right-heavy tree")
    void testComplexTree() {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);
        root.right.right.right = new TreeNode(40);
        root.right.right.right.left = new TreeNode(35);

        assertEquals(6, solution.getSize(root), "Size should be 6");
        assertEquals(150, solution.getSum(root), "Sum should be 150");
        assertEquals(40, solution.getMax(root), "Max should be 40");
        assertEquals(5, solution.getHeight(root), "Height should be 5");
    }
}