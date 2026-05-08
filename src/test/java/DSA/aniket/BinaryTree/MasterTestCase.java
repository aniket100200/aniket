package DSA.aniket.BinaryTree;

public class MasterTestCase {
    public static TreeNode getMasterTree() {
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

        return root;

    }
}
