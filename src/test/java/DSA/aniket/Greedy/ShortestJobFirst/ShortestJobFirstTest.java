package DSA.aniket.Greedy.ShortestJobFirst;

import DSA.aniket.Greedy.ShortestJobFirst.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestJobFirstTest {

    private final ShortestJobFirst solution = new Solution();

    @Test
    @DisplayName("Standard Example 1: Unsorted burst times")
    @Timeout(1)
    public void testStandardExample1() {
        int[] bt = {4, 3, 7, 1, 2};
        assertEquals(4, solution.solve(bt));
    }

    @Test
    @DisplayName("Standard Example 2: Already sorted burst times")
    @Timeout(1)
    public void testStandardExample2() {
        int[] bt = {1, 2, 3, 4};
        assertEquals(2, solution.solve(bt));
    }

    @Test
    @DisplayName("Edge Case: Single process")
    @Timeout(1)
    public void testSingleProcess() {
        int[] bt = {5};
        // Waiting time for 1 process is always 0
        assertEquals(0, solution.solve(bt));
    }

    @Test
    @DisplayName("Corner Case: All burst times are identical")
    @Timeout(1)
    public void testIdenticalBurstTimes() {
        int[] bt = {5, 5, 5};
        // Wait times: 0, 5, 10 -> Total = 15. Avg = 15 / 3 = 5
        assertEquals(5, solution.solve(bt));
    }

    @Test
    @DisplayName("Edge Case: Large burst times")
    @Timeout(1)
    public void testLargeBurstTimes() {
        int[] bt = {10000, 10000, 10000};
        // Wait times: 0, 10000, 20000 -> Total = 30000. Avg = 10000
        assertEquals(10000, solution.solve(bt));
    }

    @Test
    @DisplayName("Edge Case: Two processes")
    @Timeout(1)
    public void testTwoProcesses() {
        int[] bt = {10, 2};
        // Sorted: 2, 10
        // Wait times: 0, 2 -> Total = 2. Avg = 2 / 2 = 1
        assertEquals(1, solution.solve(bt));
    }

    @Test
    @DisplayName("Performance Test: Large input array")
    @Timeout(1)
    public void testLargeArray() {
        int size = 100000;
        int[] bt = new int[size];
        Arrays.fill(bt, 10);

        // Wait times: 0, 10, 20, ..., (N-1)*10
        // Sum = 10 * (N-1)*N / 2
        // Average = Sum / N = 10 * (N-1) / 2
        long expectedSum = 10L * (size - 1) * size / 2;
        int expectedAvg = (int) (expectedSum / size);

        assertEquals(expectedAvg, solution.solve(bt));
    }
}