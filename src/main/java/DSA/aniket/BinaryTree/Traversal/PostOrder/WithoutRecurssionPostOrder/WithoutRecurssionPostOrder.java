package DSA.aniket.BinaryTree.Traversal.PostOrder.WithoutRecurssionPostOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WithoutRecurssionPostOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode node) {
        /**
         * I can do this using Stack
         */

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 0));
        List<Integer> ans = new ArrayList<>();

        if (node == null) return ans;

        while (st.size() > 0) {
            Pair p1 = st.peek();
            TreeNode curr = p1.node;
            int state = p1.state;

            if (state == 0) {
                if (curr.left != null) {
                    st.push(new Pair(curr.left, 0));
                }
            } else if (state == 1) {

                if (curr.right != null) {
                    st.push(new Pair(curr.right, 0));
                }
            } else {
                ans.add(curr.val);
                st.pop();
            }

            p1.setState(state + 1);
        }
        return ans;
    }


    /**
     * state 0 -> means go left
     * steate 1-> add and  go right
     * state 2 -> remove from the stack
     */
    class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }

        void setState(int state) {
            this.state = state;
        }
    }
}