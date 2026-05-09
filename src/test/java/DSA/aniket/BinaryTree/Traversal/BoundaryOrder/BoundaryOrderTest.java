package DSA.aniket.BinaryTree.Traversal.BoundaryOrder;

import DSA.aniket.BinaryTree.MasterTestCase;
import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoundaryOrderTraversalTest {

    private final Traverse solution = new BoundaryOrder();

    public static TreeNode getMasterTree2() {
        //0th level
        TreeNode root = new TreeNode(10);


        //1st level
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        //2nd level

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        //3rd level
        root.left.right.left = new TreeNode(80);
        root.right.left.right = new TreeNode(90);

        root.right.right.right = new TreeNode(100);
        root.right.right.right.right = new TreeNode(110);


        root.left.left.left = new TreeNode(120);
        root.left.left.left.left = new TreeNode(130);
        return root;

    }

    @Test
    @DisplayName("Should return an empty list for an empty tree (null root)")
    void testEmptyTree() {
        assertEquals(Collections.emptyList(), solution.traverse(null));
    }

    @Test
    @DisplayName("Check the Master Test Case")
    void testMasterTest() {
        TreeNode masterTree = MasterTestCase.getMasterTree();
        List<Integer> expected = List.of(10, 20, 40, 80, 90, 70, 30);
        assertEquals(expected, solution.traverse(masterTree));
    }

    @Test
    @DisplayName("Should return a single element for a tree with only a root")
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(1);
        assertEquals(Collections.singletonList(1), solution.traverse(root));
    }

    @Test
    @DisplayName("Example 1: Standard balanced-ish tree")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        // Root: 1
        // Left Boundary: 2
        // Leaves: 4, 8, 9, 6, 7
        // Right Boundary: 3
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 9, 6, 7, 3);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Example 2: Right-heavy tree")
    void testRightHeavyTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        // Root: 1
        // Left Boundary: Empty
        // Leaves: 3, 4
        // Right Boundary (Reversed): 2
        List<Integer> expected = Arrays.asList(1, 3, 4, 2);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Should correctly handle a right child acting as the left boundary")
    void testMissingLeftChildOnLeftBoundary() {
        /*
                  1
                 / \
                2   3
                 \
                  4
                 / \
                5   6

            Root: 1
            Left Boundary: 2, 4 (Since 2 has no left, we go right to 4)
            Leaves: 5, 6, 3
            Right Boundary: empty (3 is a leaf)
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 6, 3);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Should correctly traverse a completely left-skewed tree")
    void testLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Root: 1
        // Left Boundary: 2, 3
        // Leaves: 4
        // Right Boundary: Empty
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Testing Master")
    void masterTest() {
        TreeNode root = MasterTestCase.getMasterTree();
        List<Integer> expected = Arrays.asList(10, 20, 40, 80, 90, 70, 30);
        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Testing Master 2")
    void masterTest2() {
        TreeNode root = getMasterTree2();
        List<Integer> expected = Arrays.asList(10, 20, 40, 120, 130, 80, 90, 110, 100, 70, 30);
        assertEquals(expected, solution.traverse(root));

    }

    @Test
    @DisplayName("Left Skewed Tree")
    void skewedTreeLeft() {
        Object[] option = MasterTestCase.getLeftSkewedTree(100);
        TreeNode root = (TreeNode) option[0];
        List<Integer> expected = (List<Integer>) option[1];

        assertEquals(expected, solution.traverse(root));
    }

    @Test
    @DisplayName("Right Skewed Tree")
    void skewedTreeRight() {
        Object[] option = MasterTestCase.getRightSkewedTree(100);
        TreeNode root = (TreeNode) option[0];
        List<Integer> expected = (List<Integer>) option[1];

        assertEquals(expected, solution.traverse(root));
    }
}