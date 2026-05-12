package DSA.aniket.BinaryTree.BST.RecoverBST.UsingIterativeDFS;

import DSA.aniket.BinaryTree.BST.RecoverBST.RecoverBST;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.Stack;

public class UsingIterativeDFS implements RecoverBST {

    @Override
    public TreeNode recoverTree(TreeNode root) {

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        TreeNode prev = null;
        TreeNode curr = getNextInOrder(st);

        TreeNode a = null;
        TreeNode b = null;

        while (curr != null) {
            if (prev == null) {
                prev = curr;
                curr = getNextInOrder(st);
            } else {
                if (prev.val > curr.val) {
                    //This is Bad and we have to detect whether it's first encounter or 2nd one
                    if (a == null) {
                        a = prev;
                        b = curr;
                    } else {
                        b = curr;
                    }

                }

                prev = curr;
                curr = getNextInOrder(st);
            }


        }

        int temp = a.val;
        a.val = b.val;
        b.val = temp;


        return root;
    }

    /**
     * Iterative DFS
     */
    public TreeNode getNextInOrder(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair p1 = st.peek();
            TreeNode node = p1.node;
            int state = p1.state;
            if (state == 0) {
                p1.setState(1);
                if (node.left != null) {
                    st.push(new Pair(node.left, 0));
                }
            } else if (state == 1) {
                p1.setState(2);
                if (node.right != null)
                    st.push(new Pair(node.right, 0));
                return node;
            } else {
                st.pop();
            }

        }

        return null;
    }

    class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}