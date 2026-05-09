package DSA.aniket.BinaryTree;

import java.util.ArrayList;
import java.util.List;

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

    public static Object[] getLeftSkewedTree(int load) {
        int count = 100;
        TreeNode root = new TreeNode(100);
        TreeNode curr = root;

        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        while (load-- > 0) {
            count += 25;
            TreeNode node = new TreeNode(count);
            ans.add(node.val);
            curr.left = node;
            curr = node;
        }

        Object[] objects = new Object[2];
        objects[0] = root;
        objects[1] = ans;

        return objects;
    }

    public static Object[] getRightSkewedTree(int load) {
        int count = 100;
        TreeNode root = new TreeNode(100);
        TreeNode curr = root;

        List<Integer> ans = new ArrayList<>();
        while (load-- > 0) {
            count += 25;
            TreeNode node = new TreeNode(count);
            ans.add(node.val);
            curr.right = node;
            curr = node;
        }

        ans = ans.reversed();
        ans.add(0, root.val);

        Object[] objects = new Object[2];
        objects[0] = root;
        objects[1] = ans;

        return objects;
    }
}
