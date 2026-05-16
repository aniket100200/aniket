package DSA.aniket.Arrays.SlidingWindow.MinLenAfterDeletingSimillarEnds.Solution;

import DSA.aniket.Arrays.SlidingWindow.MinLenAfterDeletingSimillarEnds.MinLenAfterDeletingSimillarEnds;

public class Solution implements MinLenAfterDeletingSimillarEnds {

    @Override
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char currChar = s.charAt(left);
            if (s.charAt(right) != currChar) break;
            while (left + 1 < s.length() && s.charAt(left + 1) == currChar) left++;
            while (right - 1 >= 0 && s.charAt(right - 1) == currChar) right--;
            left++;
            right--;

        }

        if (left > right) return 0;
        return right - left + 1;
    }
}