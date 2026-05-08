package DSA.aniket.BinaryTree.views.Bottom;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BottomViewOfBinaryTreeTest {

    private final View solution = new Bottom();

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
    @DisplayName("Example 1: Tree with overlapping nodes")
    void testOverlappingNodes() {
        /*
                20 (0)
              /    \
        (-1) 8      22 (+1)
            / \       \
      (-2) 5   3 (0)   25 (+2)
              / \
        (-1) 10  14 (+1)
        */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(25);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        // HDs: -2(5), -1(10 overrides 8), 0(3 overrides 20), 1(14 overrides 22), 2(25)
        List<Integer> expected = Arrays.asList(5, 10, 3, 14, 25);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should correctly handle a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // HDs: 4(-3), 3(-2), 2(-1), 1(0)
        // Since no HD overlaps, everything is visible from the bottom
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should correctly handle a right-skewed tree crossing back over the center")
    void testZigZagTree() {
        /*
                  1  (0)
                   \
                    2 (+1)
                   /
                  3 (0 - overrides 1)
                 /
                4 (-1)
                 \
                  5 (0 - overrides 3)
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        root.right.left.left.right = new TreeNode(5);

        // HDs: -1(4), 0(5 overrides 3 overrides 1), +1(2)
        List<Integer> expected = Arrays.asList(4, 5, 2);
        assertEquals(expected, solution.draw(root));
    }

    @Test
    @DisplayName("Should prefer the rightmost node if two nodes share the exact same spot")
    void testExactSameSpot() {
        /*
                  1  (0)
                 / \
         (-1)   2   3 (+1)
                 \   \
          (0)     4   5 (0)

          Nodes 4 and 5 will both land on HD 0.
          In a standard BFS, we process Left -> Right.
          So 4 will be processed, and then 5 will be processed and overwrite 4.
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        // HDs: -1(2), 0(5 overrides 4 overrides 1), +1(3)
        List<Integer> expected = Arrays.asList(2, 5, 3);
        assertEquals(expected, solution.draw(root));
    }
}