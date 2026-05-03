package DSA.aniket.BinarySearch.onAnswers.AggressiveCows;

import DSA.aniket.BinarySearch.onAnswers.AggressiveCows.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Aggressive Cows - Binary Search on Answer")
class AggressiveCowsTest {

    // Replace 'YourClass.aggressiveCows' with your actual method.
    // Assuming signature: public static int aggressiveCows(int[] stalls, int k)
//    AggressiveCows solver = new LinearSolution();
    AggressiveCows solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1 (Sorted Input)")
    void testExample1() {
        int[] stalls = {1, 2, 4, 8, 9};
        assertEquals(3, solver.aggressiveCows(stalls, 3),
                "Should find the optimal max-min distance for sorted stalls.");
    }

    @Test
    @DisplayName("2. Unsorted Input Trap: Example 2")
    void testExample2() {
        int[] stalls = {10, 1, 2, 7, 5};
        // TRAP: If the code doesn't sort the array first, the greedy placement will fail.
        assertEquals(4, solver.aggressiveCows(stalls, 3),
                "Must sort the array before applying binary search and greedy placement.");
    }

    @Test
    @DisplayName("3. High Density Case: Example 3")
    void testExample3() {
        int[] stalls = {2, 12, 11, 3, 26, 7};
        assertEquals(1, solver.aggressiveCows(stalls, 5),
                "Should correctly handle placing many cows in close proximity.");
    }

    @Test
    @DisplayName("4. Only 2 Cows (Boundary Case)")
    void testTwoCows() {
        int[] stalls = {1, 2, 8, 4, 9};
        // If there are only 2 cows, you ALWAYS put them at the two extreme ends of the sorted array.
        // Sorted: [1, 2, 4, 8, 9] -> distance is 9 - 1 = 8.
        assertEquals(8, solver.aggressiveCows(stalls, 2),
                "For k=2, the answer is always the difference between the maximum and minimum stall.");
    }

    @Test
    @DisplayName("5. Cows equals Stalls (Boundary Case)")
    void testCowsEqualsStalls() {
        int[] stalls = {10, 20, 30, 40};
        // 4 stalls, 4 cows. The answer is the smallest gap between any two adjacent sorted stalls.
        assertEquals(10, solver.aggressiveCows(stalls, 4),
                "If k == stalls.length, the answer is the minimum adjacent difference.");
    }

    @Test
    @DisplayName("6. Large Distances (Constraint Max)")
    void testLargeDistances() {
        // Values up to 10^8
        int[] stalls = {0, 100000000};
        assertEquals(100000000, solver.aggressiveCows(stalls, 2),
                "Algorithm must handle maximum constraint values without error.");
    }

    @Test
    @DisplayName("7. Stalls with minimum gap of 1")
    void testConsecutiveStalls() {
        int[] stalls = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(3, solver.aggressiveCows(stalls, 3),
                "Should optimally place 3 cows at 1, 4, and 7.");
    }

    @Test
    @DisplayName("8. Uneven large gaps")
    void testUnevenGaps() {
        int[] stalls = {1, 2, 8, 4, 9, 15, 25};
        // Sorted: [1, 2, 4, 8, 9, 15, 25]
        // k = 4. Placements: 1, 8, 15, 25. Min diffs: 7, 7, 10 -> min is 7.
        assertEquals(7, solver.aggressiveCows(stalls, 4),
                "Should correctly navigate uneven gaps to maximize the minimum distance.");
    }
}