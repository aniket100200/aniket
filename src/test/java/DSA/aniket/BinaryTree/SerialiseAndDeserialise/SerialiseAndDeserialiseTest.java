package DSA.aniket.BinaryTree.SerialiseAndDeserialise;

import DSA.aniket.BinaryTree.MasterTree;
import DSA.aniket.BinaryTree.SerialiseAndDeserialise.Solution.Solution;
import DSA.aniket.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializeDeserializeTreeTest {

    private final SerialiseAndDeserialise codec = new Solution();

    // Helper: Validates if two trees are exactly the same (structurally and by value)
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Helper: Automates the serialize -> deserialize -> compare flow
    private void assertCodecWorks(TreeNode originalRoot) {
        String serialized = codec.serialize(originalRoot);
        TreeNode deserializedRoot = codec.deserialize(serialized);

        assertTrue(isSameTree(originalRoot, deserializedRoot),
                "The deserialized tree does not match the original tree! Serialized string was: " + serialized);
    }

    // --- Tests ---

    @Test
    public void testExample1_StandardTree() {
        // Construct Tree: [1, 2, 3, null, null, 4, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertCodecWorks(root);
    }

    @Test
    public void testExample2_EmptyTree() {
        // Construct Tree: null
        TreeNode root = null;
        assertCodecWorks(root);
    }

    @Test
    public void testSingleNode() {
        // Construct Tree: [1]
        TreeNode root = new TreeNode(1);
        assertCodecWorks(root);
    }

    @Test
    public void testLeftSkewedTree() {
        // Construct Tree: 1 -> left(2) -> left(3) -> left(4)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        assertCodecWorks(root);
    }

    @Test
    public void testNegativeValuesAndDuplicates() {
        // Construct Tree: [-1, -2, -3, -1, null, -1]
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-1);

        assertCodecWorks(root);
    }


    @Test
    public void testMasterTestCase() {
        TreeNode root = MasterTree.get();
        assertCodecWorks(root);
    }
}