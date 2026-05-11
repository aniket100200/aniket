package DSA.aniket.BinaryTree.BST.LCA;

import DSA.aniket.BinaryTree.BST.LCA.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LowestCommonAncestorBSTTest {

    private final LCA solution = new Solution();

    // Helper: Builds the standard Example 1 & 2 Tree -> [6,2,8,0,4,7,9,null,null,3,5]
    private TreeNode[] buildStandardTreeAndGetNodes() {
        TreeNode root = new TreeNode(6);

        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node8;

        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node2.left = node0;
        node2.right = node4;

        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node8.left = node7;
        node8.right = node9;

        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node4.left = node3;
        node4.right = node5;

        // Return an array where [0] is root, [1] is node2, [2] is node8, [3] is node4
        return new TreeNode[]{root, node2, node8, node4};
    }

    // --- Tests ---

    @Test
    public void testExample1_StandardLCA() {
        TreeNode[] nodes = buildStandardTreeAndGetNodes();
        TreeNode root = nodes[0];
        TreeNode p = nodes[1]; // Node 2
        TreeNode q = nodes[2]; // Node 8

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        assertNotNull(lca);
        assertEquals(6, lca.val, "The LCA of 2 and 8 should be 6.");
    }

    @Test
    public void testExample2_LCAIsOneOfNodes() {
        TreeNode[] nodes = buildStandardTreeAndGetNodes();
        TreeNode root = nodes[0];
        TreeNode p = nodes[1]; // Node 2
        TreeNode q = nodes[3]; // Node 4

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        assertNotNull(lca);
        assertEquals(2, lca.val, "The LCA of 2 and 4 should be 2.");
    }

    @Test
    public void testExample3_TwoNodes() {
        // Construct Tree: [2, 1]
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;

        TreeNode p = root;   // Node 2
        TreeNode q = node1;  // Node 1

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        assertNotNull(lca);
        assertEquals(2, lca.val, "The LCA of 2 and 1 should be 2.");
    }

    @Test
    public void testLeftSkewedTree() {
        // Construct Tree: 4 -> 3 -> 2 -> 1
        TreeNode root = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        root.left = node3;
        node3.left = node2;
        node2.left = node1;

        TreeNode p = node1; // Node 1
        TreeNode q = node3; // Node 3

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        assertNotNull(lca);
        assertEquals(3, lca.val, "The LCA of 1 and 3 should be 3.");
    }

    @Test
    public void testDeepCommonAncestor() {
        // Construct Tree: [10, 5, 15, 3, 7, null, null, null, null, 6, 8]
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        root.left = node5;
        root.right = node15;

        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node7;

        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        node7.left = node6;
        node7.right = node8;

        TreeNode p = node6; // Node 6
        TreeNode q = node8; // Node 8

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        assertNotNull(lca);
        assertEquals(7, lca.val, "The LCA of 6 and 8 should be 7.");
    }
}