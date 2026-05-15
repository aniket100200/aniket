package DSA.aniket.Arrays.SlidingWindow.MaximumConsecutiveOnes.Solution;

import DSA.aniket.Arrays.SlidingWindow.MaximumConsecutiveOnes.MaximumConsecutiveOnes;

public class Solution implements MaximumConsecutiveOnes {

    @Override
    public int longestOnes(int[] arr, int k) {
        int sp = 0;
        int ep = 0;
        int count0 = 0;
        int maxLength = 0;
        while (ep < arr.length && sp < arr.length) {
            /**
             * Introduce people to the window
             */
            if (arr[ep] == 0) count0++;
            /**
             * Shrink the window if Invalid
             */

            while (count0 > k) {
                if (arr[sp] == 0) count0--;
                sp++;
            }

            /**
             * calculate the answer
             */

            maxLength = Math.max(maxLength, ep - sp + 1);

            /**
             * add more people to the window
             */
            ep++;
        }


        return maxLength;
    }
}


//public int longestOnes(int[] arr, int k) {
//    int sp = 0;
//    int ep = 0;
//    int count0 = 0;
//    int maxLength = 0;
//    while (ep < arr.length && sp < arr.length) {
//        /**
//         * check if it 0 or 1
//         */
//        if (arr[ep] == 1) {
//            ep++;
//        } else {
//            if (count0 < k) {
//                count0++;
//                ep++;
//            } else {
//                /**
//                 * exclude the people
//                 */
//                maxLength = Math.max(maxLength, ep - sp);
//                if (arr[sp] == 0) count0--;
//
//                sp++;
//
//            }
//        }
//
//        maxLength = Math.max(maxLength, ep - sp);
//    }
//
//
//    return maxLength;
//}