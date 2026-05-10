package DSA.aniket.BinaryTree.Construction.FromPreOrderAndInOrder;

import DSA.aniket.BinaryTree.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;

public class FromPreOrderAndInorderOrder implements Construction {

    public TreeNode construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {

        if (psi > pei) return null;
        if (isi > iei) return null;
        TreeNode root = new TreeNode(pre[psi]);
        int i = isi;
        int countOfNodesInLeftSubtree = 0;

        while (in[i] != pre[psi]) {
            i++;
            countOfNodesInLeftSubtree++;
        }

        root.left = construct(pre, psi + 1, psi + countOfNodesInLeftSubtree, in, isi, i - 1);
        root.right = construct(pre, psi + countOfNodesInLeftSubtree + 1, pei, in, i + 1, iei);


        return root;

    }

    @Override
    public TreeNode buildTree(int[] pre, int[] in) {
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
}