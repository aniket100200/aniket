package DSA.aniket.BinarySearch.onAnswers.PaintersPartition;

import DSA.aniket.BinarySearch.onAnswers.PaintersPartition.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Painter's Partition - Binary Search on Answer")
class PaintersPartitionTest {


    // Assuming signature: public static long minTime(int[] arr, int k)
    PaintersPartition solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1")
    void testExample1() {
        int[] arr = {5, 10, 30, 20, 15};
        assertEquals(35L, solver.minTime(arr, 3),
                "Should find the optimal contiguous split for 3 painters.");
    }

    @Test
    @DisplayName("2. Standard Case: Example 2")
    void testExample2() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(60L, solver.minTime(arr, 2));
    }

    @Test
    @DisplayName("3. Only 1 Painter (Must do all the work)")
    void testOnePainter() {
        int[] arr = {100, 200, 300, 400};
        // The answer must be the exact sum of the entire array.
        assertEquals(1000L, solver.minTime(arr, 1),
                "If k=1, the answer is the sum of all board lengths.");
    }

    @Test
    @DisplayName("4. TRAP: More Painters Than Boards")
    void testMorePaintersThanBoards() {
        int[] arr = {10, 20, 5, 15};
        int k = 10;
        // 4 boards, 10 painters. 6 painters do nothing.
        // The remaining 4 take one board each.
        // The total time is dictated by the painter who takes the longest single board.
        assertEquals(-1, solver.minTime(arr, k),
                "If k >= arr.length, the answer is simply the maximum element in the array.");
    }

    @Test
    @DisplayName("5. Order Matters (Do Not Sort Constraint)")
    void testOrderMatters() {
        int[] arr = {10, 50, 10, 20};
        int k = 2;
        // If sorted to [10, 10, 20, 50], split is [10, 10, 20] and [50] -> max 50.
        // But in original order, split is [10, 50] and [10, 20] -> max 60.
        assertEquals(60L, solver.minTime(arr, k),
                "Algorithm must respect original contiguous order. Do not sort the array!");
    }

    @Test
    @DisplayName("6. Equal Length Boards")
    void testEqualBoards() {
        int[] arr = {10, 10, 10, 10, 10, 10};
        assertEquals(30L, solver.minTime(arr, 2),
                "Should cleanly divide uniform arrays.");
    }

    @Test
    @DisplayName("7. Constraint Overflow Check")
    void testConstraintOverflow() {
        // Max array size = 10^5. Max value = 10^4. Total sum = 10^9.
        // We simulate a large array to ensure the binary search high pointer doesn't behave erratically.
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10000;
        }
        assertEquals(1000000000L, solver.minTime(arr, 1),
                "Algorithm must safely accumulate sums up to 10^9 using long primitives.");
    }
}