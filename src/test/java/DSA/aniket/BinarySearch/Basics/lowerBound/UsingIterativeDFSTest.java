package DSA.aniket.BinarySearch.Basics.lowerBound;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsingIterativeDFSTest {

    LowerBound lowerBound = new Solution();
    int[] arr = new int[]{1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
    int target1 = 1, target8 = 8;

    @Test
    public void testLowerBound() {
        assertEquals(0, lowerBound.binarySearch(arr, target1));
    }

    @Test
    public void testLowerBound2() {
        assertEquals(5, lowerBound.binarySearch(arr, 8));
    }

    @Test
    public void testLowerBoundIfValueIsNotPresent() {
        assertEquals(0, lowerBound.binarySearch(new int[0], 1));
    }
}
