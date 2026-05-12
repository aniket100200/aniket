package DSA.aniket.BinaryTree.BST.Construction.FromLevelOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FromLevelOrder implements Construction {

    @Override
    public TreeNode constructBST(int[] arr) {

        if (arr == null) return null;
        if (arr.length == 0) return null;

        Queue<Trio> que = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        que.add(new Trio(root, Integer.MIN_VALUE, root.val - 1));
        que.add(new Trio(root, root.val + 1, Integer.MAX_VALUE));
        int idx = 1;

        while (que.size() > 0) {
            Trio rTrio = que.poll();
            TreeNode parent = rTrio.node;
            int l = rTrio.l;
            int r = rTrio.r;
            if (idx >= arr.length) continue;
            int curr = arr[idx];
            if (curr >= l && curr <= r) {
                TreeNode newNode = new TreeNode(curr);
                if (curr < parent.val) {
                    parent.left = newNode;
                } else parent.right = newNode;

                /**
                 * add it's childrens
                 */
                que.add(new Trio(newNode, l, curr - 1));
                que.add(new Trio(newNode, curr + 1, r));

                idx++;
            }
        }

        return root;

    }
}

class Trio {
    TreeNode node;
    int l;
    int r;

    public Trio(TreeNode node, int l, int r) {
        this.node = node;
        this.l = l;
        this.r = r;
    }
}