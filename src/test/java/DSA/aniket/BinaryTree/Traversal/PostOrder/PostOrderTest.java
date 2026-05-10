package DSA.aniket.BinaryTree.Traversal.PostOrder;

import DSA.aniket.BinaryTree.Traversal.PostOrder.WithoutRecurssionPostOrder.WithoutRecurssionPostOrder;
import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostorderTraversalTest {


    //    Traverse solution = new PostOrder();
    Traverse solution = new WithoutRecurssionPostOrder();

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), solution.traverse(null));
    }

    @Test
    @DisplayName("Should return a single element for a tree with only a root")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertEquals(Collections.singletonList(1), solution.traverse(root));
    }

    @Test
    @DisplayName("Example 1: Right-leaning tree with a left child")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Postorder: Left(null), Right(Left(3), Right(null), Root(2)), Root(1) -> 3, 2, 1
        List<Integer> expected = Arrays.asList(3, 2, 1);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Should correctly traverse a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Postorder: Bottom-up for left leaning -> 4, 3, 2, 1
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Should correctly traverse a completely right-skewed tree")
    void testRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Postorder: Bottom-up for right leaning -> 4, 3, 2, 1
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Should correctly traverse a balanced/full binary tree")
    void testFullBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Expected Postorder: Left(4,5,2), Right(6,7,3), Root(1) -> 4, 5, 2, 6, 7, 3, 1
        List<Integer> expected = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Example 4: Complex asymmetric tree")
    void testComplexTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);

        // Expected Postorder: Left(4, 6, 7, 5, 2), Right(9, 8, 3), Root(1)
        List<Integer> expected = Arrays.asList(4, 6, 7, 5, 2, 9, 8, 3, 1);
        assertEquals(expected, solution.traverse(root));
    }
}