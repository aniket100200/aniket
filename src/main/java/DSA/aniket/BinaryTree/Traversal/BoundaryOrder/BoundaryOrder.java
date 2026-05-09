package DSA.aniket.BinaryTree.Traversal.BoundaryOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) return List.of(root.val);
        /**
         * You'll have to do it with
         * root + left Wall +  bottom Wall + right Wall(in reverse order)
         */

        //step1: Print root
        ans.add(root.val);

        leftWall(root.left, ans);
        bottomWall(root, ans);
        rightWall(root.right, ans);

        return ans;

    }

    private void leftWall(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        /**
         * Excluding the Leaf Node as it'll be not part of bottom Wall
         */
        if (root.left == null && root.right == null) return;
        ans.add(root.val);

        if (root.left != null) {
            leftWall(root.left, ans);
        } else leftWall(root.right, ans);

    }

    private void bottomWall(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            //this is leafnode
            ans.add(root.val);
            return;
        }

        bottomWall(root.left, ans);
        bottomWall(root.right, ans);
    }

    private void rightWall(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        /**
         * Excluding the Leaf Node as it'll be part of bottom Wall
         */
        if (root.left == null && root.right == null) return;


        if (root.right != null) {
            rightWall(root.right, ans);
        } else rightWall(root.left, ans);

        ans.add(root.val);


    }
}