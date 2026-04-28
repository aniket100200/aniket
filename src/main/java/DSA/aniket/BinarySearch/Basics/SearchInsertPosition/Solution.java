package DSA.aniket.BinarySearch.Basics.SearchInsertPosition;

import DSA.aniket.BinarySearch.Basics.lowerBound.LowerBound;

public class Solution implements SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("Running SearchInsertPosition...");
    }

    @Override
    public int findInsertPosition(int[] arr, int target) {
        LowerBound lowerBound = new DSA.aniket.BinarySearch.Basics.lowerBound.Solution();
        return lowerBound.binarySearch(arr, target);
    }
}