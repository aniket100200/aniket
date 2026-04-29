package DSA.aniket.BinarySearch.Basics.NumberOfOccurencesOfElement.solutions.OptimalSolution;

import DSA.aniket.BinarySearch.Basics.FirstAndLastIndex.FirstAndLastIndexImpl;
import DSA.aniket.BinarySearch.Basics.NumberOfOccurencesOfElement.NumberOfOccurencesOfElement;


public class OptimalSolution implements NumberOfOccurencesOfElement {

    @Override
    public int countOccurrences(int[] sortedArray, int target) {
        //will find the first Occurence which can be find using lower bound approach
        FirstAndLastIndexImpl helper = new FirstAndLastIndexImpl();
        int n = sortedArray.length;

        int lb = helper.lowerBound(sortedArray, n, target);
        if (lb == n || sortedArray[lb] != target) return 0;

        int ub = helper.upperBound(sortedArray, n, target);

        return ub - lb;
    }
}