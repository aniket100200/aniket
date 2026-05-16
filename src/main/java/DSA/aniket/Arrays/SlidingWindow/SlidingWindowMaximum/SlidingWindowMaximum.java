package DSA.aniket.Arrays.SlidingWindow.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum implements DSA.aniket.Queue.SlidingWindowMaximum.SlidingWindowMaximum {

    @Override
    public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
        /**
         * there will be n-k+1 windows
         */
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        /**
         * use this Deque as Stack
         * dq.addLast()
         * dq.removeLast();
         */

        int index = 0;
        for (int i = 0; i < n; ) {
            /**
             * clean the garbage
             */
            boolean isOutOfWindow = dq.size() > 0 && dq.getFirst() <= i - k;

            while (isOutOfWindow) {

                dq.removeFirst();
                isOutOfWindow = dq.size() > 0 && dq.getFirst() <= i - k;
            }
            int curr = nums[i];

            boolean isCurrGreater = !dq.isEmpty() && curr > nums[dq.getLast()];
            while (isCurrGreater) {
                dq.removeLast();
                isCurrGreater = !dq.isEmpty() && curr > nums[dq.getLast()];
            }
            dq.addLast(i);
            /**
             * calculate the Answer
             */
            if (i - k + 1 >= 0)
                ans[index++] = nums[dq.getFirst()];
            /** Include More Elements*/
            i++;
        }

        return ans;

    }
}