package DSA.aniket.BinarySearch.Basics.upperBound;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsingIterativeDFSTest {
    UpperBound solution = new Solution();

    int[] arr = new int[]{1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
    int target1 = 1, target8 = 8;

    @Test
    public void testUpperBound() {
        assertEquals(1, solution.upperBound(arr, target1));
    }

    @Test
    public void testUpperBoundForTarget8() {
        assertEquals(7, solution.upperBound(arr, 8));
    }

}