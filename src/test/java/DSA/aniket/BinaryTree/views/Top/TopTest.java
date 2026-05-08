package DSA.aniket.BinaryTree.views.Top;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopViewOfBinaryTreeTest {

    private final View view = new Top();

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), view.draw(null));
    }

    @Test
    @DisplayName("Should return a single element for a single node tree")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertEquals(Collections.singletonList(1), view.draw(root));
    }

    @Test
    @DisplayName("Example 1: Perfect Binary Tree")
    void testPerfectBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // HDs: 4(-2), 2(-1), 1(0), 3(1), 7(2).
        // 5 and 6 are at HD 0, blocked by 1.
        List<Integer> expected = Arrays.asList(4, 2, 1, 3, 7);
        assertEquals(expected, view.draw(root));
    }

    @Test
    @DisplayName("Should correctly hide nodes that share a horizontal distance with higher nodes")
    void testHiddenNodes() {
        /*
                  1  (HD 0)
                 / \
         (-1)   2   3 (HD +1)
                 \
                  4 (HD 0 - hidden by 1)
                   \
                    5 (HD +1 - hidden by 3)
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        List<Integer> expected = Arrays.asList(2, 1, 3);
        assertEquals(expected, view.draw(root));
    }

    @Test
    @DisplayName("Should expose a lower branch if it extends past the top boundaries")
    void testLongAngledBranch() {
        /*
                  1  (0)
                   \
                    2 (+1)
                   /
                  3 (0 - hidden)
                 /
                4 (-1)
               /
              5 (-2 - visible!)
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.left.left = new TreeNode(5);

        // Leftmost visible is 5(-2), then 4(-1), then 1(0), then 2(1).
        List<Integer> expected = Arrays.asList(5, 4, 1, 2);
        assertEquals(expected, view.draw(root));
    }

    @Test
    @DisplayName("Should return left skewed tree from top to bottom")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        // HDs: 3(-2), 2(-1), 1(0)
        List<Integer> expected = Arrays.asList(3, 2, 1);
        assertEquals(expected, view.draw(root));
    }
}