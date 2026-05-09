package DSA.aniket.BinaryTree.NodeToRootPath;

import DSA.aniket.BinaryTree.NodeToRootPath.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeToRootPathTest {

    NodeToRootPath solution = new Solution();

    /*
            Tree Structure

                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7

    */

    private TreeNode createTree() {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    @Test
    void testNodeExistsLeftSubtree() {

        TreeNode root = createTree();

        List<Integer> expected = Arrays.asList(5, 2, 1);

        assertEquals(expected, solution.find(root, 5));
    }

    @Test
    void testNodeExistsRightSubtree() {

        TreeNode root = createTree();

        List<Integer> expected = Arrays.asList(7, 3, 1);

        assertEquals(expected, solution.find(root, 7));
    }

    @Test
    void testRootNode() {

        TreeNode root = createTree();

        List<Integer> expected = Collections.singletonList(1);

        assertEquals(expected, solution.find(root, 1));
    }

    @Test
    void testLeafNode() {

        TreeNode root = createTree();

        List<Integer> expected = Arrays.asList(4, 2, 1);

        assertEquals(expected, solution.find(root, 4));
    }

    @Test
    void testNodeDoesNotExist() {

        TreeNode root = createTree();

        List<Integer> expected = new ArrayList<>();

        assertEquals(expected, solution.find(root, 100));
    }

    @Test
    void testSingleNodeTreeFound() {

        TreeNode root = new TreeNode(10);

        List<Integer> expected = Collections.singletonList(10);

        assertEquals(expected, solution.find(root, 10));
    }

    @Test
    void testSingleNodeTreeNotFound() {

        TreeNode root = new TreeNode(10);

        List<Integer> expected = new ArrayList<>();

        assertEquals(expected, solution.find(root, 5));
    }

    @Test
    void testNullTree() {

        List<Integer> expected = new ArrayList<>();

        assertEquals(expected, solution.find(null, 1));
    }
}
