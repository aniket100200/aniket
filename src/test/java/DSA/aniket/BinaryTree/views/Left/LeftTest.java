package DSA.aniket.BinaryTree.views.Left;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeftViewOfBinaryTreeTest {

    View solution = new Left();

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), solution.draw(null));
    }

    @Test
    @DisplayName("Should return a single element for a single node tree")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertEquals(Collections.singletonList(1), solution.draw(root));
    }

    @Test
    @DisplayName("Example 1: Standard balanced-ish tree")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> expected = Arrays.asList(1, 2, 4);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should correctly return the left view for a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Entire tree is visible from the left
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should correctly return the left view for a completely right-skewed tree")
    void testRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Because there are no left nodes to block the view, all right nodes are visible
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should expose right nodes when the left branch doesn't reach as deep")
    void testRightHeavyVisibleLeft() {
        /*
                  1
                /   \
               2     3
                \     \
                 4     5
                        \
                         6

           Level 0: 1
           Level 1: 2 (blocks 3)
           Level 2: 4 (blocks 5)
           Level 3: 6 (nothing blocking it)
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        List<Integer> expected = Arrays.asList(1, 2, 4, 6);
        assertEquals(expected, solution.draw(root));
    }
}